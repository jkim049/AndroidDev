package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun makeColored(view: View){
        val backgroundView = findViewById<View>(R.id.constraint_layout)
        when(view.id){

            R.id.box_one_text -> backgroundView.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> backgroundView.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> backgroundView.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> backgroundView.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> backgroundView.setBackgroundColor(Color.BLUE)
            R.id.yellow_button -> backgroundView.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> backgroundView.setBackgroundResource(R.color.my_green)
            R.id.red_button -> backgroundView.setBackgroundResource(R.color.my_red)

            else -> view.setBackgroundColor(Color.LTGRAY);
        }
    }
    private fun setListeners(){
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val yellowButton = findViewById<TextView>(R.id.yellow_button)
        val greenButton = findViewById<TextView>(R.id.green_button)
        val redButton = findViewById<TextView>(R.id.red_button)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, yellowButton, greenButton, redButton, rootConstraintLayout)

        for(item in clickableViews){
            item.setOnClickListener{
                makeColored(it)
            }
        }
    }
}
