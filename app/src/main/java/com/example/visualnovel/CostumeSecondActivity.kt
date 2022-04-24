package com.example.visualnovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class CostumeSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_costume_second)


        val textView  = findViewById<TextView>(R.id.textView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonStartHomeActivity = findViewById<Button>(R.id.buttonStart)

        val identifier: String? =  intent.getStringExtra("identifier")
        val like:Boolean = intent.getBooleanExtra("like",true)
        val activity = ActivityHelpClass(identifier!!, this)
        val image  = activity.getImage()
        val text  = activity.getText()
        textView.text = if (like) text[0] else text[1]

        buttonStartHomeActivity.text = text[2]
        val resID = resources.getIdentifier(image, "drawable", packageName)
        imageView.setImageResource(resID)

        buttonStartHomeActivity.setOnClickListener{
            val intent = Intent(this, FinalActivity::class.java)
            intent.putExtra("identifier", "activityEndHome")
            startActivity(intent)
        }
    }
}