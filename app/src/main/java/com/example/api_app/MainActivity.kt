package com.example.api_app

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import kotlinx.coroutines.runBlocking
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun fetchPokemonImage() {
        val client = AsyncHttpClient()

        client["https://pokeapi.github.io/pokekotlin/api/#-1752852885%2FPackages%2F1558683979", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("Pokemon", "response successful")
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Pokemon Error", errorResponse)
            }
        }]
    }

//    fun main() = runBlocking {
//        with(PokeApi) {
//            runCatching {
//                // Get a list of Pokémon species
//                val list = getPokemonSpeciesList(0, 10)
//
//                for (handle in list.results) {
//                    // Get each species by its handle
//                    val species = handle.get()
//                    println("Species: $species")
//                }
//            }.onFailure { e ->
//                println("Error: ${e.message}")
//            }
//        }
//    }

}