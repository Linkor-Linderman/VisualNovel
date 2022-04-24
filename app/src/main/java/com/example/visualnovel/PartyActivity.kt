package com.example.visualnovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PartyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_party)

        val textView  = findViewById<TextView>(R.id.textView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonStartFilmActivity = findViewById<Button>(R.id.buttonStart)
        val buttonStartCostumeActivity = findViewById<Button>(R.id.buttonStart1)

        val identifier: String? =  intent.getStringExtra("identifier")

        val activity = ActivityHelpClass(identifier!!, this)
        val image  = activity.getImage()
        val text  = activity.getText()
        textView.text = text[0]
        buttonStartFilmActivity.text = text[1]
        buttonStartCostumeActivity.text = text[2]
        val resID = resources.getIdentifier(image, "drawable", packageName)
        imageView.setImageResource(resID)

        buttonStartFilmActivity.setOnClickListener{
            val intent = Intent(this, FilmActivity::class.java)
            intent.putExtra("identifier", "activityCinemaFirst")
            startActivity(intent)
        }
        buttonStartCostumeActivity.setOnClickListener{
            val intent = Intent(this, CostumeActivity::class.java)
            intent.putExtra("identifier", "activityCostumeFirst")
            startActivity(intent)
        }
    }
}