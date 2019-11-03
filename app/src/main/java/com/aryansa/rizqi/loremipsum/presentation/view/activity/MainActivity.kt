package com.aryansa.rizqi.loremipsum.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aryansa.rizqi.loremipsum.R
import com.aryansa.rizqi.loremipsum.databinding.ActivityMainBinding
import com.aryansa.rizqi.loremipsum.domain.model.remote.LoremIpSumResponse
import com.aryansa.rizqi.loremipsum.presentation.adapters.LoremAdapter
import com.aryansa.rizqi.loremipsum.presentation.adapters.ShimmerAdapter
import com.aryansa.rizqi.loremipsum.presentation.viewmodels.LoremViewModel
import com.aryansa.rizqi.loremipsum.utils.ResultResponse
import com.aryansa.rizqi.loremipsum.utils.extensions.observeData
import com.aryansa.rizqi.loremipsum.utils.extensions.showToast
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_shimmer.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModelLorem: LoremViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        viewModelLorem = ViewModelProviders.of(this, viewModelFactory)
            .get(LoremViewModel::class.java)

        with(binding) {
            viewModel = viewModelLorem
            lifecycleOwner = this@MainActivity
            return@with root
        }

        setRecyclerView()
        viewModelLorem.getLorem()

        setShimmer()

        observeViewModel()

    }

    private fun setShimmer() {
        binding.rvShimmer.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ShimmerAdapter()
        }
    }

    private fun observeViewModel() {
        observeData(viewModelLorem.state) {
            when (it) {
                is ResultResponse.Success -> {
                    if(it.responseData?.statusCode == 200) {
                        rvLoremMain.apply {
                            adapter = LoremAdapter(it.responseData.data, this@MainActivity)
                        }
                    }
                }
                is ResultResponse.Failure -> {
                    showToast(it.throwable.toString())
                }
            }
        }
    }

    private fun setRecyclerView() {
        binding.rvLoremMain.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }
}
