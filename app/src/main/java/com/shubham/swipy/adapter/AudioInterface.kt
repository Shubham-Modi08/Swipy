package com.shubham.swipy.adapter

import android.widget.ImageButton

interface AudioInterface {
    fun onClickPlay(url: String, position: Int, play:ImageButton, pause:ImageButton)
    fun onClickPause(position: Int)
}