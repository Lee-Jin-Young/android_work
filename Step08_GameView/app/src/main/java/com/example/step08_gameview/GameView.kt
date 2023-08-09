package com.example.step08_gameview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.util.Random


class GameView @JvmOverloads constructor(context: Context, attrs: AttributeSet?=null) : View(context, attrs) {

    lateinit var handler2: Handler
    
    lateinit var backImg: Bitmap

    //화면의 폭과 높이를 저장할 필드
    private var width = 0
    private var height = 0
    
    var backOneY = 0
    var backTwoY = 0

    //유저
    var unitImgs = arrayOfNulls<Bitmap>(4)
    var unitIndex = 0
    var count = 0
    var unitSize = 0
    var unitX = 0
    var unitY = 0

    //미사일
    val miImgs = arrayOfNulls<Bitmap>(3)
    var miSize = 0
    val miList = mutableListOf<Missile>()
    var missSpeed = 0

    // 적
    var enemyImgs = Array(2){ arrayOfNulls<Bitmap>(2) }
    var enemyList = mutableListOf<Enemy>()
    var enemyX = IntArray(5)
    var ran = Random()
    var postCount = 0

    fun init() {
        //원본 이미지
        var backImg:Bitmap = BitmapFactory.decodeResource(resources, R.drawable.backbg)
        //원본 이미지를 원하는 크기로 변경해서 필드에 저장하기
        this.backImg = Bitmap.createScaledBitmap(backImg, width, height, false)

        var unitImg1 = BitmapFactory.decodeResource(resources, R.drawable.unit1)
        unitImgs[0] = Bitmap.createScaledBitmap(unitImg1, unitSize, unitSize, false)
        var unitImg2 = BitmapFactory.decodeResource(resources, R.drawable.unit2)
        unitImgs[1] = Bitmap.createScaledBitmap(unitImg2, unitSize, unitSize, false)
        var unitImg3 = BitmapFactory.decodeResource(resources, R.drawable.unit3)
        unitImgs[2] = Bitmap.createScaledBitmap(unitImg3, unitSize, unitSize, false)
        var unitImg4 = BitmapFactory.decodeResource(resources, R.drawable.unit2)
        unitImgs[3] = Bitmap.createScaledBitmap(unitImg4, unitSize, unitSize, false)

        // 미사일 이미지 로딩
        val miImg1 = BitmapFactory.decodeResource(resources, R.drawable.mi1)
        val miImg2 = BitmapFactory.decodeResource(resources, R.drawable.mi2)
        val miImg3 = BitmapFactory.decodeResource(resources, R.drawable.mi3)
        // 미사일 이미지 크기 조절
        miImgs[0] = Bitmap.createScaledBitmap(miImg1, miSize, miSize, false)
        miImgs[1] = Bitmap.createScaledBitmap(miImg2, miSize, miSize, false)
        miImgs[2] = Bitmap.createScaledBitmap(miImg3, miSize, miSize, false)

        // 적 이미지 로딩
        val enemyImg1 = BitmapFactory.decodeResource(resources, R.drawable.silver1)
        val enemyImg2 = BitmapFactory.decodeResource(resources, R.drawable.silver2)
        val enemyImg3 = BitmapFactory.decodeResource(resources, R.drawable.gold1)
        val enemyImg4 = BitmapFactory.decodeResource(resources, R.drawable.gold2)
        // 적 이미지 사이즈 조절
        enemyImgs[0][0] = Bitmap.createScaledBitmap(enemyImg1, unitSize, unitSize, false)
        enemyImgs[0][1] = Bitmap.createScaledBitmap(enemyImg2, unitSize, unitSize, false)
        enemyImgs[1][0] = Bitmap.createScaledBitmap(enemyImg3, unitSize, unitSize, false)
        enemyImgs[1][1] = Bitmap.createScaledBitmap(enemyImg4, unitSize, unitSize, false)
        // 적의 x 좌표를 구해서 배열에 저장한다.
        for(i in 0..4){
            enemyX[i] = unitSize/2 + unitSize*i
        }
        
        // handler 객체에 빈 메시지를 10/1000 초 이후마다 보낸다
        handler2 = object:Handler() {
            override fun handleMessage(msg: Message) {
                invalidate()
                sendEmptyMessageDelayed(0, 10)
            }
        }
        handler2.sendEmptyMessageDelayed(0, 20)
    } //init
    
    override fun onDraw(canvas: Canvas?) {
        canvas?.drawBitmap(backImg, 0f, backOneY.toFloat(), null)
        canvas?.drawBitmap(backImg, 0f, backTwoY.toFloat(), null)

        //드래곤 이미지 그리기
        unitImgs[unitIndex]?.let{
            canvas?.drawBitmap(it, (unitX-unitSize/2).toFloat(), (unitY-unitSize/2).toFloat(), null)
        }

        //드래곤 이미지 움직임
        count++
        if(count == 10) {
            unitIndex++
            count = 0
        }
        if(unitIndex == 4) {
            unitIndex = 0
        }

        //미사일 이미지
        for(tmp in miList) {
            miImgs[0]?.let{
                canvas?.drawBitmap(it, tmp.x-miSize/2.toFloat(), tmp.y-miSize/2.toFloat(), null)
            }
        }

        //적기 그리기
        enemyList.forEach{
            // it 즉 Enemy 객체의 참조값을 tmp 에 대입해서 사용
            var tmp = it
            enemyImgs[tmp.type][tmp.imageIndex]?.let {
                canvas?.drawBitmap(it, (tmp.x - unitSize/2).toFloat(), (tmp.y - unitSize/2).toFloat(), null)
            }
        }

        //미사일 관련 처리를 하는 함수 호출
        missileService()
        //적 관련 처리를 하는 함수
        enemyService()

        //배경이미지
        backOneY += 5
        backTwoY += 5
        if(backOneY >= height) {
            backOneY = -height
            backTwoY = 0
        }
        if(backTwoY >= height) {
            backTwoY = -height
            backOneY = 0
        }
    } //draw

    fun missileService() {
        if(count%5 == 0) {
            val missile = Missile(unitX, unitY)
            miList.add(missile)
        }
        for(tmp in miList) {
            tmp.y -= 5
        }
    }

    //적 관련 처리를 하는 함수
    fun enemyService() {
        postCount++
        //랜덤한 숫자를 하나 얻어낸다 (0~19 사이)
        val ranNum = ran.nextInt(20)
        if(ranNum == 10 && postCount > 15) {
            postCount = 0
            //적을 5개 1세트 만들어서 List 에 누적 시키기
            for(i in 0 until 5) {
                val tmp = Enemy()
                tmp.x = enemyX[i]
                tmp.y = unitSize/2 //임시 y 좌표
                tmp.type = ran.nextInt(2)// 적의 type 은 0 또는 1 랜덤하게 부여
                tmp.energy = if(tmp.type == 0){ 50 } else { 100 }
                enemyList.add(tmp)
            }
        }
    }

    //View 가 차지하고 있는 영역의 width 와 height
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w
        height = h

        //배경 이미지의 초기좌표
        backTwoY = -height
        
        unitSize = w / 5
        // 드래곤의 초기 좌표
        unitX = w / 2
        unitY = height - unitSize / 2

        //미사일의 크기
        miSize = unitSize / 4

        init()
    }

    //View 에 터치 이벤트가 발생하면 호출되는 함수
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_MOVE -> {
                unitX = event.x.toInt()
            }
        }
        return true
    }
}