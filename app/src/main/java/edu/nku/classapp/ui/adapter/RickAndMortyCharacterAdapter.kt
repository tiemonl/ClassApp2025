package edu.nku.classapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.nku.classapp.R
import edu.nku.classapp.databinding.CharacterCardViewBinding
import edu.nku.classapp.model.RickAndMortyCharacterResponse

class RickAndMortyCharacterAdapter(
    private val onCharacterClicked: (character: RickAndMortyCharacterResponse.Character, position: Int) -> Unit,
) : RecyclerView.Adapter<RickAndMortyCharacterAdapter.RickAndMortyCharacterViewHolder>() {

    class RickAndMortyCharacterViewHolder(
        private val binding: CharacterCardViewBinding,
        private val onCharacterClicked: (position: Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onCharacterClicked(adapterPosition)
            }
        }

        fun bind(character: RickAndMortyCharacterResponse.Character) {
            binding.characterAge.text = binding.root.context.getString(R.string.age, character.id)
            binding.characterName.text =
                binding.root.context.getString(R.string.name, character.name)
            Glide.with(binding.root).load(character.image).into(binding.characterImage)
        }
    }

    private val rickAndMortyCharacters = mutableListOf<RickAndMortyCharacterResponse.Character>()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(characters: List<RickAndMortyCharacterResponse.Character>) {
        rickAndMortyCharacters.clear()
        rickAndMortyCharacters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RickAndMortyCharacterViewHolder {
        val binding =
            CharacterCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RickAndMortyCharacterViewHolder(binding) { position ->
            onCharacterClicked(rickAndMortyCharacters[position], position)
        }
    }


    override fun getItemCount() = rickAndMortyCharacters.size

    override fun onBindViewHolder(
        holder: RickAndMortyCharacterViewHolder,
        position: Int
    ) {
        val character = rickAndMortyCharacters[position]
        holder.bind(character)
    }
}