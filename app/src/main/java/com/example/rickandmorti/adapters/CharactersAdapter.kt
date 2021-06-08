package com.example.rickandmorti.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorti.R
import com.example.rickandmorti.characters.Character
import com.example.rickandmorti.data.GlideLibraryLoad


class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>(){
    var listCharacter = emptyList<Character>()
    private lateinit var onButtonListener : OnButtonListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.characters_item,parent,false)
        onButtonListener = parent.context as OnButtonListener
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(listCharacter[position])
        holder.itemView.setOnClickListener{
            onButtonListener.onButtonClicked(listCharacter[position])}
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

}