package com.junction.seoul.hunterandroid

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import kotlin.math.roundToInt

class VoiceRecordView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val startTime = System.currentTimeMillis()
    private val voiceBitmap = BitmapFactory.decodeResource(resources, R.drawable.icon_voice)
    private val paint = Paint()
    private val colorList = listOf(
        Color.rgb(30, 125, 213),
        Color.rgb(30, 125, 213),
        Color.rgb(30, 125, 213)
    )
    private val alphaList = listOf(
        255,
        153,
        76,
        0
    )

    init {
        paint.isAntiAlias = true
        paint.textAlign = Paint.Align.CENTER
        paint.textSize = 40f
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val defaultRadios = width / 5f
        val timeDiff = System.currentTimeMillis() - startTime
        val speed = 1 / 10f
        val percent = ((timeDiff * speed) % (defaultRadios / 2f)) / (defaultRadios / 2f)
        for ((index, color) in colorList.withIndex()) {
            paint.color = color
            paint.alpha = if (index == 0) {
                alphaList[0]
            } else {
                (alphaList[index] - (alphaList[index] - alphaList[index + 1]) * percent).roundToInt()
            }
            print("${(alphaList[index] - (alphaList[index] - alphaList[index + 1]) * percent).roundToInt()} ")
            canvas.drawCircle(
                width / 2f,
                height / 2f,
                defaultRadios + index * defaultRadios / 2 +
                        (timeDiff * speed) % (defaultRadios / 2),
                paint
            )
        }
        println()
        paint.alpha = 255
        canvas.drawBitmap(
            voiceBitmap,
            null,
            Rect(
                width / 10 * 4,
                height / 10 * 4,
                width / 10 * 6,
                height / 10 * 6
            ),
            null
        )
        paint.color = Color.WHITE
        canvas.drawText("음성 검색", width / 2f, height / 6 * 4f, paint)

        invalidate()
    }
}
