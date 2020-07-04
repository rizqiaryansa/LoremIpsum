package com.aryansa.rizqi.loremipsum.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aryansa.rizqi.loremipsum.databinding.ActivityMainBinding
import com.aryansa.rizqi.loremipsum.presentation.adapters.LoremAdapter
import com.aryansa.rizqi.loremipsum.presentation.adapters.ShimmerAdapter
import com.aryansa.rizqi.loremipsum.presentation.viewmodels.LoremViewModel
import com.aryansa.rizqi.loremipsum.common.utils.ResultResponse
import com.aryansa.rizqi.loremipsum.common.utils.extensions.gone
import com.aryansa.rizqi.loremipsum.common.utils.extensions.observeData
import com.aryansa.rizqi.loremipsum.common.utils.extensions.showToast
import com.aryansa.rizqi.loremipsum.common.utils.extensions.visible
import com.aryansa.rizqi.loremipsum.domain.model.remote.LoremIpSumResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModelLorem: LoremViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    private val adapterLorem by lazy { LoremAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
            shimmerShow()
            when (it) {
                is ResultResponse.Success -> {
                    shimmerHide()
                    if (it.responseData?.statusCode == 200) {
                        setLoremList(it.responseData.data)
                    }
                }
                is ResultResponse.Failure -> {
                    shimmerHide()
                    showToast(it.throwable.toString())
                }
            }
        }
    }

    private fun setLoremList(data: List<LoremIpSumResponse.Data>) {
        adapterLorem.setLoremListData(data)
    }

    private fun setRecyclerView() {
        binding.rvLoremMain.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = adapterLorem
        }
    }

    private fun shimmerShow() {
        with(binding) {
            shimmer.startShimmer()
            shimmer.visible()
        }
    }

    private fun shimmerHide() {
        with(binding) {
            shimmer.stopShimmer()
            shimmer.gone()
        }
    }
}
