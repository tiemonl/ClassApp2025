package edu.nku.classapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import edu.nku.classapp.databinding.ActivityMainBinding
import edu.nku.classapp.ui.RickAndMortyCharacterListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.commit {
            add(R.id.fragment_container_view, RickAndMortyCharacterListFragment())
            setReorderingAllowed(true)
        }

    }
}