package com.example.coroutines

import android.graphics.BitmapFactory
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainLooper = mainLooper
        Log.d("Task Thread", Thread.currentThread().name)
        GlobalScope.launch (context = Dispatchers.IO){
            Log.d("Task Thread", Thread.currentThread().name)
            val imageUrl = URL("https://c4.wallpaperflare.com/wallpaper/932/891/825/hogwarts-legacy-video-games-dragon-owl-harry-potter-hd-wallpaper-preview.jpg")
            val connection = imageUrl.openConnection() as HttpURLConnection
            connection.doInput  = true
            connection.connect()

            val inputStream = connection.inputStream
            val bitmap = BitmapFactory.decodeStream(inputStream)
            val image = findViewById<ImageView>(R.id.image)

                launch (Dispatchers.Main){
                    Log.d("Task Thread", Thread.currentThread().name)
                    image.setImageBitmap(bitmap)}}


//        val mainLooper = mainLooper // or Looper.getMainLooper() this is the second method to display the picture in the main activity usinf looper
//        Thread(Runnable {
//
////            runOnUiThread{image.setImageBitmap(bitmap)}// first method to display the picture to the Main activity
//        })
//            .start()
    }




}