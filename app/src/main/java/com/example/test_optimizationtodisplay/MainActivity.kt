package com.example.test_optimizationtodisplay

import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Display
import androidx.annotation.InspectableProperty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val display = windowManager.defaultDisplay // in case of Activity

        val size = Point()
        display.getRealSize(size) // or getSize(size)
        val width = size.x.toFloat()
        val height = size.y.toFloat()

        val newWidth : Float = (width / 1080).toFloat()
        val newHeight : Float = (height / 1823).toFloat()
        val area : Float = ((width * height) / (1080 * 1823)).toFloat()

        Log.d("MainActivity", "width: $width")
        Log.d("MainActivity", "height: $height")

        // 뷰들의 사이즈를 가져온다
        val textTextSize = textView.textSize
        val buttonWidth = 100

        val density = resources.displayMetrics.density

        val ratio = (density/2.75).toFloat()

        Log.d("MainActivity", "textTextSize: $textTextSize")
        Log.d("MainActivity", "buttonTextSize: $buttonWidth")
        Log.d("MainActivity", "area: $area")
        Log.d("MainActivity", "density: $density")


        // 뷰들의 사이즈를 재정의
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textTextSize / density * ratio)
        button.layoutParams.width = buttonWidth
    }
}