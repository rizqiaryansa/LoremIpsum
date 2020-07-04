package com.aryansa.rizqi.loremipsum.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aryansa.rizqi.loremipsum.databinding.ActivityMainBinding
import com.aryansa.rizqi.loremipsum.domain.model.remote.Data
import com.aryansa.rizqi.loremipsum.presentation.adapters.LoremAdapter
import com.aryansa.rizqi.loremipsum.presentation.adapters.ShimmerAdapter
import com.aryansa.rizqi.loremipsum.presentation.viewmodels.LoremViewModel
import com.aryansa.rizqi.loremipsum.utils.ResultResponse
import com.aryansa.rizqi.loremipsum.utils.extensions.gone
import com.aryansa.rizqi.loremipsum.utils.extensions.observeData
import com.aryansa.rizqi.loremipsum.utils.extensions.showToast
import com.aryansa.rizqi.loremipsum.utils.extensions.visible
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModelLorem: LoremViewModel

    private lateinit var binding: ActivityMainBinding

    private val adapterLorem by lazy { LoremAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelLorem = ViewModelProvider(this, viewModelFactory)
            .get(LoremViewModel::class.java)

        setRecyclerView()
        viewModelLorem.getLorem()
        viewModelLorem.getLorem()
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

    private fun setLoremList(data: List<Data>) {
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
