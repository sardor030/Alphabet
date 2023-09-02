package com.example.alphabet.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.alphabet.R
import com.example.alphabet.ui.english.EnglishAlphabetActivity
import com.example.alphabet.ui.russian.RussianAlphabetActivity

class MainActivity : AppCompatActivity() {

    private var btnEnglish: Button? = null
    private var btnRussian: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListeners()
    }

    private fun initViews() {
        btnEnglish = findViewById(R.id.btn_english)
        btnRussian = findViewById(R.id.btn_russian)
    }

    private fun initListeners() {

        btnRussian?.setOnClickListener {
            val intent = Intent(this,RussianAlphabetActivity::class.java)
            startActivity(intent)
        }

        btnEnglish?.setOnClickListener {
            val intent = Intent(this, EnglishAlphabetActivity::class.java)
            startActivity(intent)
        }
    }
}