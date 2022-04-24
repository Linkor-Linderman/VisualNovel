package com.example.visualnovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class FilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)

        val textView  = findViewById<TextView>(R.id.textView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonStartFilmActivity = findViewById<Button>(R.id.buttonStart)
        val buttonStartPartyActivity = findViewById<Button>(R.id.buttonStart1)

        val identifier: String? =  intent.getStringExtra("identifier")

        val activity = ActivityHelpClass(identifier!!, this)
        val image  = activity.getImage()
        val text  = activity.getText()
        textView.text = text[0]
        buttonStartFilmActivity.text = text[1]
        buttonStartPartyActivity.text = text[2]
        val resID = resources.getIdentifier(image, "drawable", packageName)
        imageView.setImageResource(resID)

        buttonStartFilmActivity.setOnClickListener{
            val intent = Intent(this, FilmSecondActivity::class.java)
            intent.putExtra("identifier", "activityCinemaSecond")
            intent.putExtra("like", true)
            startActivity(intent)
        }
        buttonStartPartyActivity.setOnClickListener{
            val intent = Intent(this, FilmSecondActivity::class.java)
            intent.putExtra("identifier", "activityCinemaSecond")
            intent.putExtra("like", false)
            startActivity(intent)
        }
    }
}