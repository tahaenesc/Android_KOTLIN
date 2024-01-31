package com.example.myapplication

import android.app.Application
import android.graphics.Canvas
import android.graphics.Color
import android.media.audiofx.DynamicsProcessing


class HaritaCizimUygulamasi : Application() {
    private lateinit var canvas: Canvas
    private lateinit var gc: GraphicsContext

    fun start(primaryStage: DynamicsProcessing.Stage) {
        primaryStage.title = "Harita Çizim Uygulaması"
        canvas = Canvas(800.0, 600.0)
        gc = canvas.graphicsContext2D
        setupCanvas()

        val root = StackPane()
        root.children.add(canvas)

        canvas.setOnMousePressed { handleMousePress(it) }
        canvas.setOnMouseDragged { handleMouseDrag(it) }

        primaryStage.scene = Scene(root, 800.0, 600.0)
        primaryStage.show()
    }

    private fun setupCanvas() {
        gc.fill = Color.WHITE
        gc.fillRect(0.0, 0.0, canvas.width, canvas.height)
        gc.stroke = Color.BLACK
        gc.lineWidth = 2.0
    }

    private fun handleMousePress(event: MouseEvent) {
        gc.beginPath()
        gc.moveTo(event.x, event.y)
        gc.stroke()
    }

    private fun handleMouseDrag(event: MouseEvent) {
        gc.lineTo(event.x, event.y)
        gc.stroke()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(HaritaCizimUygulamasi::class.java, *args)
        }
    }
}