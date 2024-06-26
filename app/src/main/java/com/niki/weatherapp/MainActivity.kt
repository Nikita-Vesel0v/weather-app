package com.niki.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.niki.weatherapp.databinding.MainActivityBinding
import org.json.JSONObject

const val API_KEY = "c2cb54503a3140859a8145001242606"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bGet.setOnClickListener {
            getResult("London")
        }
    }
    private fun getResult(name: String) {
        val url = "https://api.weatherapi.com/v1/current.json" +
                "?key=$API_KEY&q=$name&aqi=no"
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {
                response->
                    val obj = JSONObject(response)
                    val temp = obj.getJSONObject("current")
                    Log.d("AppLog", "Response: ${temp.getString("temp_c")}")
            },
            {
                Log.d("AppLog", "Volley Error: $it")
            }
        )
        val queue = Volley.newRequestQueue(this)
        queue.add(stringRequest)

    }
 }