package com.example.visualnovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class CostumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_costume)

        val textView  = findViewById<TextView>(R.id.textView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonStartPartyLikeActivity = findViewById<Button>(R.id.buttonStart)
        val buttonStartPartyDislikeActivity = findViewById<Button>(R.id.buttonStart1)

        val identifier: String? =  intent.getStringExtra("identifier")

        val activity = ActivityHelpClass(identifier!!, this)
        val image  = activity.getImage()
        val text  = activity.getText()
        textView.text = text[0]
        buttonStartPartyLikeActivity.text = text[1]
        buttonStartPartyDislikeActivity.text = text[2]
        val resID = resources.getIdentifier(image, "drawable", packageName)
        imageView.setImageResource(resID)

        buttonStartPartyLikeActivity.setOnClickListener{
            val intent = Intent(this, CostumeSecondActivity::class.java)
            intent.putExtra("identifier", "activityCostumeSecond")
            intent.putExtra("like", true)
            startActivity(intent)
        }
        buttonStartPartyDislikeActivity.setOnClickListener{
            val intent = Intent(this, CostumeSecondActivity::class.java)
            intent.putExtra("identifier", "activityCostumeSecond")
            intent.putExtra("like", false)
            startActivity(intent)
        }
    }
}