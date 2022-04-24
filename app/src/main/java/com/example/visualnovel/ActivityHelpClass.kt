package com.example.visualnovel

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.*
import java.lang.reflect.Type


class ActivityHelpClass(var identifier: String, var context: Context){
    private val contextOfApp = context
    private val fileName = "some.json"



   private fun getJsonFromAssets(context: Context): String? {
        return try {
            val inputStream : InputStream = context.assets.open(fileName!!)
            val size: Int = inputStream .available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer)
            } catch (e: IOException) {
                e.printStackTrace()
                return null
            }
    }
   private fun getListOfActivity(): List<ActivityClass>{
        val jsonFileString = getJsonFromAssets(contextOfApp)
        Log.i("data", jsonFileString!!)
        val gson = Gson()
        val listUserType = object : TypeToken<List<ActivityClass?>?>(){}.type
        val activates: List<ActivityClass> = gson.fromJson(jsonFileString, listUserType)
        Log.i("Activity", activates[0].name)
        return activates
    }
    fun getImage():String{
        val listOfActivity = this.getListOfActivity()
        var image = ""
        for (activity in listOfActivity){
            if (activity.name ==identifier){
                image = activity.image
            }
        }
        Log.i("Image", image)
        return image;
    }

    fun getText():Array<String>{
        val listOfActivity = this.getListOfActivity()
        var text:Array<String> = arrayOf()
        for (activity in listOfActivity){
            if (activity.name == identifier){
                text = activity.text
            }
        }
        Log.i("Text", text[0])
        return text;
    }
}
