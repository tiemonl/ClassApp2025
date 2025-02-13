package edu.nku.classapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RickAndMortyCharacterAdapter(private val characters: List<RickAndMortyCharacter>) :
    RecyclerView.Adapter<RickAndMortyCharacterAdapter.RickAndMortyCharacterViewHolder>() {

    class RickAndMortyCharacterViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.character_image)
        val characterName: TextView = itemView.findViewById(R.id.character_name)
        val characterAge: TextView = itemView.findViewById(R.id.character_age)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = RickAndMortyCharacterViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.character_card_view,
            parent,
            false
        )
    )

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(
        holder: RickAndMortyCharacterViewHolder,
        position: Int
    ) {
        val character = characters[position]
        holder.characterName.text = holder.itemView.context.getString(R.string.name, character.name)
        holder.characterAge.text = holder.itemView.context.getString(R.string.age, character.age)

        Glide.with(holder.itemView.context)
            .load(character.picture)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.characterImage)
    }

}