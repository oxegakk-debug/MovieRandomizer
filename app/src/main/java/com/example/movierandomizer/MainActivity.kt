package com.example.movierandomizer

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var movieText: TextView
    private lateinit var randomButton: Button
    private lateinit var resetButton: Button

    private var remainingMovies = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieText = findViewById(R.id.movieText)
        randomButton = findViewById(R.id.randomButton)
        resetButton = findViewById(R.id.resetButton)

        resetMovies()

        randomButton.setOnClickListener {
            showRandomMovie()
        }

        resetButton.setOnClickListener {
            resetMovies()
        }
    }

    private fun showRandomMovie() {
        if (remainingMovies.isEmpty()) {
            movieText.setText(R.string.no_movies)
            return
        }

        val randomIndex = (0 until remainingMovies.size).random()
        val movie = remainingMovies.removeAt(randomIndex)

        movieText.text = movie
    }

    private fun resetMovies() {
        remainingMovies = resources
            .getStringArray(R.array.movies)
            .toMutableList()

        movieText.setText(R.string.initial_message)
    }
}
