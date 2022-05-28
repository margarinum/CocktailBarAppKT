package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import okhttp3.*
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL


public class MainActivity : AppCompatActivity() {
    private val client = OkHttpClient()
    private val moshi = Moshi.Builder().build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val res: TextView = findViewById(R.id.apiResult)
        button.setOnClickListener {
            startActivity(Intent(this, CocktalList::class.java))
        }
        val getResp: Button = findViewById(R.id.get_resp)
        getResp.setOnClickListener {
            run()
        }

    }

    fun run() {
        val request = Request.Builder()
            .url("http://publicobject.com/helloworld.txt")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    for ((name, value) in response.headers) {
                        println("$name: $value")
                    }

                    println(response.body!!.string())
                }
            }
        })
    }

}

