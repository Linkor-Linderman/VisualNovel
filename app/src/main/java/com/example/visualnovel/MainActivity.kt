package com.example.visualnovel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView  = findViewById<TextView>(R.id.textView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonStart = findViewById<Button>(R.id.buttonStart)


        val activity = ActivityHelpClass("activityFirstHome", this)

        val image  = activity.getImage()
        val text  = activity.getText()
        textView.text = text[0]
        buttonStart.text = text[1]
        val resID = resources.getIdentifier(image, "drawable", packageName)
        imageView.setImageResource(resID)
        val intent = Intent(this, ActivitySecondHome::class.java)
        buttonStart.setOnClickListener {
            intent.putExtra("identifier", "activitySecondHome")
            startActivity(intent)
        }

    }
}