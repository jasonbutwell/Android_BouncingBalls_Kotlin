package com.example.bouncingballskotlin

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

class Ball (
    ballX: Float,
    ballY: Float,
    radius: Float,
    ballSpeedX: Float,
    ballSpeedY: Float,
    alpha: Int,
    red: Int,
    green: Int,
    blue: Int
) {
    private var ballRadius = radius
    private var ballX = ballX
    private var ballY = ballY
    private var ballSpeedX = ballSpeedX
    private var ballSpeedY = ballSpeedY
    private var ballBounds: RectF? = RectF();
    private var paint: Paint? = Paint()

    init {
        this.paint?.setARGB(alpha, red, green, blue)
    }

    private fun setBallSpeed( speedX: Float, speedY: Float) {
        this.ballSpeedX = speedX
        this.ballSpeedY = speedY
    }

    public fun update( xMin : Int, xMax : Int , yMin :Int, yMax : Int) {
        this.ballX += this.ballSpeedX
        this.ballY += this.ballSpeedY

        if (this.ballX + this.ballRadius > xMax) {
            this.ballSpeedX = -this.ballSpeedX
            this.ballX = xMax - this.ballRadius
        }
        else
            if (this.ballX - this.ballSpeedX < xMin) {
                this.ballSpeedX = -this.ballSpeedX
                this.ballX = xMin + this.ballRadius
            }

            if (this.ballY + this.ballRadius > yMax) {
                this.ballSpeedY = -ballSpeedY
                this.ballY = yMax - this.ballRadius
            }
            else
                if (this.ballY - this.ballRadius < yMin) {
                    this.ballSpeedY = -this.ballSpeedY
                    this.ballY = yMin + this.ballRadius
                }
        }

    private fun draw( canvas: Canvas) {
        this.ballBounds?.set(this.ballX-ballRadius,
                            this.ballY-ballRadius,
                            this.ballX+ballRadius,
                            this.ballY+ballRadius
            )
    }

}

