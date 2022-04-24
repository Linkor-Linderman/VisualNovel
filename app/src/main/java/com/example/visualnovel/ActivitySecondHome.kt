package com.example.visualnovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class ActivitySecondHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_home)

        val textView  = findViewById<TextView>(R.id.textView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonStartActivity = findViewById<Button>(R.id.buttonStart)
        val plainText = findViewById<EditText>(R.id.editTextTextPersonName)

        val identifier: String? =  intent.getStringExtra("identifier")
        val activity = ActivityHelpClass(identifier!!, this)

        val image  = activity.getImage()
        val text  = activity.getText()
        textView.text = text[0]
        plainText.hint = text[1]
        buttonStartActivity.text = text[2]
        val resID = resources.getIdentifier(image, "drawable", packageName)
        imageView.setImageResource(resID)

        val intent = Intent(this, ThirdHomeActivity::class.java)
        buttonStartActivity.setOnClickListener {
            intent.putExtra("identifier", "activityThirdHome")
            val name  = if (plainText.text.toString().isNotEmpty()) plainText.text.toString() else "username"
            intent.putExtra("name", name)
            startActivity(intent)
        }
    }
}