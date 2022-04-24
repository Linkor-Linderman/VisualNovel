package com.example.visualnovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class ThirdHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_home)

        val textView  = findViewById<TextView>(R.id.textView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonStartRunningActivity = findViewById<Button>(R.id.buttonStart)
        val buttonStartCampActivity = findViewById<Button>(R.id.buttonCamp)
        val buttonStartFieldActivity = findViewById<Button>(R.id.buttonField)

        val identifier: String? =  intent.getStringExtra("identifier")
        val name =  intent.getStringExtra("name")

        val activity = ActivityHelpClass(identifier!!, this)

        val image  = activity.getImage()
        val text  = activity.getText()
        val finalTextForTextView = StringBuffer(text[0]).insert(text[0].split(" ")[0].length+1, name)
        textView.text = finalTextForTextView
        buttonStartRunningActivity.text = text[1]
        buttonStartCampActivity.text = text[2]
        buttonStartFieldActivity.text = text[3]
        val resID = resources.getIdentifier(image, "drawable", packageName)
        imageView.setImageResource(resID)

        buttonStartCampActivity.setOnClickListener {
            val intent = Intent(this, CampingActivity::class.java)
            intent.putExtra("identifier", "activityCamping")
            startActivity(intent)
        }
        buttonStartFieldActivity.setOnClickListener {
            val intent = Intent(this, FieldActivity::class.java)
            intent.putExtra("identifier", "activityWalking")
            startActivity(intent)
        }
        buttonStartRunningActivity.setOnClickListener {
            val intent = Intent(this, WalkingActivity::class.java)
            intent.putExtra("identifier", "activityRunning")
            startActivity(intent)
        }



    }
}