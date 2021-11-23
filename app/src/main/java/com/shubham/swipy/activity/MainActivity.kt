package com.shubham.swipy.activity

import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.shubham.swipy.R
import com.shubham.swipy.adapter.AudioInterface
import com.shubham.swipy.adapter.ListAdapter
import com.shubham.swipy.model.Audio
import com.shubham.swipy.model.Response
import com.shubham.swipy.viewmodel.MainViewModel
import java.util.ArrayList
import android.media.MediaPlayer.OnCompletionListener
import android.util.Patterns
import java.util.regex.Pattern


class MainActivity : AppCompatActivity(), AudioInterface {
    private lateinit var viewPager: ViewPager2
    private var mAdapter: ListAdapter? = null;
    private var mediaPlayer: MediaPlayer? = null
    private var length: Int = 0
    private lateinit var audioData: Response
    private lateinit var viewModel: MainViewModel
    private var audioList: MutableList<Audio> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewPager = findViewById(R.id.ViewPager)

        mAdapter = ListAdapter(audioList, this, R.layout.audio_item)
        viewPager.adapter = mAdapter


        viewModel.audioList.observe(this, {
            audioData = it
            audioList.addAll(it.shorts)
            mAdapter!!.notifyDataSetChanged()
        })
        viewModel.fetchAudioList()

    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }


    override fun onClickPlay(url: String, position: Int, play: ImageButton, pause: ImageButton) {
        mediaPlayer = MediaPlayer()
        mediaPlayer?.setDataSource(audioData.shorts[position].audioPath)
        mediaPlayer?.prepareAsync()
        mediaPlayer?.setOnPreparedListener {
            it.start()
        }


        length = audioData.shorts[position].curPos
        if (length > 0) {
            mediaPlayer!!.seekTo(length)
            mediaPlayer!!.start()
        }


        mediaPlayer?.setOnCompletionListener {
            pause.visibility = View.GONE
            play.visibility = View.VISIBLE
        }

    }

    override fun onClickPause(position: Int) {
        mediaPlayer?.pause()
        length = mediaPlayer?.currentPosition!!
        audioData.shorts[position].curPos = length
    }


}