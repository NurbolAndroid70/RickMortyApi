package com.example.rickmortyapi.ui.first_activity
import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickmortyapi.base.BaseActivity
import com.example.rickmortyapi.databinding.ActivityMainBinding
import com.example.rickmortyapi.ui.CharacterAdapter
import com.example.rickmortyapi.ui.second_activity.SecondActivity
import com.example.rickmortyapi.utils.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<MainViewModel>()

    private val characterAdapter by lazy {
        CharacterAdapter(this::onClick)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecycler()


        viewModel.getCharacters()
        viewModel.charactersLv.stateObserver(
            success = {
                characterAdapter.submitList(it.results)
            },
            state = {
                binding.progressIndicator.isVisible = it is Resource.Loading
            }
        )
    }

    private fun setupRecycler() = with(binding.recyclerView) {
        layoutManager = LinearLayoutManager(
            this@MainActivity,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = characterAdapter
    }

    private fun onClick(character: Character) {
        startActivity(
            Intent(
                this, SecondActivity::class.java
            ).apply {
                putExtra(
                    CHARACTER_ID_ARG,
                    character.id
                )
            }
        )
    }

    companion object {
        const val CHARACTER_ID_ARG = "key"
    }
}