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


class GameView @JvmOverloads constructor(context: Context, attrs: AttributeSet?=null) : View(context, attrs) {

    lateinit var handler2: Handler
    
    lateinit var backImg: Bitmap
    lateinit var unitImgOne: Bitmap

    //화면의 폭과 높이를 저장할 필드
    private var width = 0
    private var height = 0
    
    var backOneY = 0
    var backTwoY = 0
    
    var unitSize = 0
    var unitX = 0
    var unitY = 0

    fun init() {
        //원본 이미지
        var backImg:Bitmap = BitmapFactory.decodeResource(resources, R.drawable.backbg)
        //원본 이미지를 원하는 크기로 변경해서 필드에 저장하기
        this.backImg = Bitmap.createScaledBitmap(backImg, width, height, false)
        
        var unitImgOne = BitmapFactory.decodeResource(resources, R.drawable.unit1)
        this.unitImgOne = Bitmap.createScaledBitmap(unitImgOne, unitSize, unitSize, false)
        
        // handler 객체에 빈 메시지를 10/1000 초 이후마다 보낸다
        handler2 = object:Handler() {
            override fun handleMessage(msg: Message) {
                invalidate()
                sendEmptyMessageDelayed(0, 10)
            }
        }
        handler2.sendEmptyMessageDelayed(0, 20)
    }
    
    override fun onDraw(canvas: Canvas?) {
        canvas?.drawBitmap(backImg, 0f, backOneY.toFloat(), null)
        canvas?.drawBitmap(backImg, 0f, backTwoY.toFloat(), null)

        canvas?.drawBitmap(unitImgOne, (unitX-unitSize/2).toFloat(), (unitY-unitSize/2).toFloat(), null)

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

    }
    //View 가 차지하고 있는 영역의 width 와 height
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w
        height = h

        //배경 이미지의 초기좌표
        backTwoY = -height
        
        unitSize = w / 5
        // 드레곤의 초기 좌표
        unitX = w / 2
        unitY = height - unitSize / 2

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