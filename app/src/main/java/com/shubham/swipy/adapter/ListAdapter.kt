package com.shubham.swipy.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shubham.swipy.R
import com.shubham.swipy.model.Audio


class ListAdapter(
    private val audioList: List<Audio>,
    listener: AudioInterface,
    private val mRowLayout: Int
) :
    RecyclerView.Adapter<ListAdapter.AudioViewHolder>() {

    var listener = listener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(mRowLayout, parent, false)
        return AudioViewHolder(view)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {

        holder.title.text = audioList[position].title
        holder.date.text = audioList[position].dateCreated
        holder.buttonPlay.setOnClickListener {
            listener.onClickPlay(audioList[position].audioPath, position,holder.buttonPlay,holder.buttonPause)
            holder.buttonPlay.visibility = View.GONE
            holder.buttonPause.visibility = View.VISIBLE
        }
        holder.buttonPause.setOnClickListener {
            holder.buttonPlay.visibility = View.VISIBLE
            holder.buttonPause.visibility = View.GONE
            listener.onClickPause(position)
        }


    }

    override fun getItemCount(): Int {
        return audioList.size
    }

    class AudioViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val buttonPlay: ImageButton = itemView.findViewById(R.id.playButton)
        val buttonPause: ImageButton = itemView.findViewById(R.id.pauseButton)
        val date: TextView = itemView.findViewById(R.id.date)
    }
}
