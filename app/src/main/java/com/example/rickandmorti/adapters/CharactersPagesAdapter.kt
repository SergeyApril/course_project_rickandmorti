package com.example.rickandmorti.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorti.R
import com.example.rickandmorti.characters.Character
import com.example.rickandmorti.data.GlideLibraryLoad

class CharactersPagesAdapter : PagingDataAdapter<Character,CharactersPagesAdapter.CharacterViewHolder>(DiffUtilCallBack()) {
    var listCharacter = emptyList<Character>()
    private lateinit var onButtonListener : CharactersPagesAdapter.OnButtonListener
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.characters_item,parent,false)
        onButtonListener = parent.context as CharactersPagesAdapter.OnButtonListener
        return CharacterViewHolder(view)
    }

    public class CharacterViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        private var tvNameCharacterForRecycler = itemView.findViewById<TextView>(R.id.tvNameCharacter)
        private var ivImageCharacterForRecycler = itemView.findViewById<ImageView>(R.id.ivImageCharacter)
        fun bind(character: Character){
            tvNameCharacterForRecycler.text = character.nameCharacter
            GlideLibraryLoad().loadImage(itemView,ivImageCharacterForRecycler, character.imageCharacter)
        }

    }
    interface OnButtonListener {
        fun onButtonClicked(character: Character) {}

    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<Character>(){
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.nameCharacter == newItem.nameCharacter
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.nameCharacter == newItem.nameCharacter
                    && oldItem.speciesCharacter == newItem.speciesCharacter
        }


    }
}