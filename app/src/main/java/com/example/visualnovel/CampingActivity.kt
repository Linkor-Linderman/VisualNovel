package com.example.visualnovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class CampingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camping)

        val textView  = findViewById<TextView>(R.id.textView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonStartFilmLikeActivity = findViewById<Button>(R.id.buttonStart)
        val buttonStartFilmDislikeActivity = findViewById<Button>(R.id.buttonStart1)

        val identifier: String? =  intent.getStringExtra("identifier")

        val activity = ActivityHelpClass(identifier!!, this)
        val image  = activity.getImage()
        val text  = activity.getText()
        textView.text = text[0]
        buttonStartFilmLikeActivity.text = text[1]
        buttonStartFilmDislikeActivity.text = text[2]
        val resID = resources.getIdentifier(image, "drawable", packageName)
        imageView.setImageResource(resID)

        buttonStartFilmLikeActivity.setOnClickListener{
            val intent = Intent(this, FilmActivity::class.java)
            intent.putExtra("identifier", "activityCinemaFirst")
            startActivity(intent)
        }
        buttonStartFilmDislikeActivity.setOnClickListener{
            val intent = Intent(this, PartyActivity::class.java)
            intent.putExtra("identifier", "activityParty")
            startActivity(intent)
        }
    }
}