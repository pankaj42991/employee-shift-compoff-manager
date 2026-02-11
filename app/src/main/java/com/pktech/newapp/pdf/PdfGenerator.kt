package com.pktech.newapp.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import java.io.File
import java.io.FileOutputStream

object PdfGenerator {

    fun generateReport(
        context: Context,
        title: String,
        content: List<String>,
        fileName: String
    ): File {

        val pdf = PdfDocument()
        val paint = Paint()

        val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create()
        val page = pdf.startPage(pageInfo)
        val canvas: Canvas = page.canvas

        paint.textSize = 18f
        canvas.drawText(title, 40f, 50f, paint)

        paint.textSize = 12f
        var y = 90f

        content.forEach {
            canvas.drawText(it, 40f, y, paint)
            y += 20
        }

        pdf.finishPage(page)

        val file = File(context.getExternalFilesDir(null), fileName)
        pdf.writeTo(FileOutputStream(file))
        pdf.close()

        return file
    }
}