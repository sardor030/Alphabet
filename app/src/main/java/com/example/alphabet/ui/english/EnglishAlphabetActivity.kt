package com.example.alphabet.ui.english

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alphabet.Mock.AppMock
import com.example.alphabet.R
import com.example.alphabet.ui.english.list.EnglishLettersAdapter

class EnglishAlphabetActivity : AppCompatActivity() {

    private var btnBack: ImageButton? = null
    private var tvLetter: TextView? = null
    private var tvDesc: TextView? = null
    private var tvTranslate: TextView? = null
    private var ivDesc: ImageView? = null
    private var rvLetters: RecyclerView? = null

    private var adapter = EnglishLettersAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english_alphabet)

        initViews()

        initData()

        initListeners()
    }

    private fun initViews() {
        btnBack = findViewById(R.id.btn_back)
        tvLetter = findViewById(R.id.tv_letter)
        tvDesc = findViewById(R.id.tv_desc)
        tvTranslate = findViewById(R.id.tv_translate)
        ivDesc = findViewById(R.id.iv_desc)
        rvLetters = findViewById(R.id.rv_litters)
    }

    private fun initData(){

        adapter.items = AppMock.englishLetters
        adapter.onClick = {
            tvLetter?.text = it.letter
            tvDesc?.text = it.example
            tvTranslate?.text = it.translate
            ivDesc?.setImageResource(it.image)
            playAudio(it.audio)
        }
        rvLetters?.adapter = adapter
    }

    private fun initListeners(){
        btnBack?.setOnClickListener {
            finish()
        }
    }

    private fun playAudio(audio: Int) {
        val player = MediaPlayer.create(this, audio)
        player.start()
        player.setOnCompletionListener {
            player.release()
        }
    }
}