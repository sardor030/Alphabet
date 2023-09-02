package com.example.alphabet.ui.russian

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.alphabet.Mock.AppMock
import com.example.alphabet.R
import com.example.alphabet.ui.russian.list.RussianLettersAdapter

class RussianAlphabetActivity : AppCompatActivity() {

    private var btnBack: ImageButton? = null
    private var rvLetters: RecyclerView? = null

    private var adapter = RussianLettersAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_russian_alphabet)

        initViews()

        initData()

        initListeners()
    }

    private fun initViews() {
        btnBack = findViewById(R.id.btn_back)
        rvLetters = findViewById(R.id.rv_letters)
    }

    private fun initData(){
        adapter.items = AppMock.russianLetters
        adapter.onClick = {
            playAudio(it.audio)
        }

        rvLetters?.adapter = adapter
    }

    private fun playAudio(audio: Int) {
        val player = MediaPlayer.create(this, audio)
        player.start()
        player.setOnCompletionListener {
            player.release()
        }
    }

    private fun initListeners(){

        btnBack?.setOnClickListener {
            finish()
        }
    }
}