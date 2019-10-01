package com.example.bouncingballskotlin

import android.content.Context
import android.graphics.Canvas
import android.view.View

class BouncingBallView(context: Context?) : View(context) {

    private val xMin : Int = 0
    private var xMax : Int = 0
    private val yMin : Int = 0
    private var yMax : Int = 0

    private val balls = arrayListOf<Ball>()

    init {
        for (i in 1..150)
            balls += addBall()
    }

    private fun addBall() : Ball
    {
        val red : Int = (Math.random()*(255-5)).toInt()
        val green : Int = (Math.random()*(255-5)).toInt()
        val blue : Int = (Math.random()*(255-5)).toInt()

        val velX = 1 + (Math.random()*20).toFloat()
        val velY = 1 + (Math.random()*20).toFloat()

        val radius = 2 + (Math.random()*50).toFloat()

        return Ball(0.0f,0.0f, radius, velX, velY, 255, red, green, blue)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        for(ball in balls)
            ball.update(xMin, xMax, yMin, yMax)

        try {
            Thread.sleep(20)
        } catch (e: InterruptedException) {}

        invalidate()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        this.xMax = w-1
        this.yMax = h-1
    }
}