package com.usman.mvvmsample.features

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.usman.mvvmsample.R
import com.usman.mvvmsample.core.BaseActivity
import com.usman.mvvmsample.core.Status
import com.usman.mvvmsample.databinding.ActivityAlbumsBinding
import com.usman.mvvmsample.features.model.Album
import com.usman.mvvmsample.features.viewmodel.AlbumsViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_albums.*
import javax.inject.Inject

class AlbumsActivity : BaseActivity<ActivityAlbumsBinding, AlbumsViewModel>(AlbumsViewModel::class.java) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun getLayoutRes() = R.layout.activity_albums

    override fun getVMFactory(): ViewModelProvider.Factory {
        return viewModelFactory
    }

    override fun onInject() {
        AndroidInjection.inject(this)
    }

    override fun initViewModel(viewModel: AlbumsViewModel) {
        viewModel.getAlbums().observe(this, Observer { albums ->
            albums?.let {
                when (it.status) {
                    Status.SUCCESS -> {
                        hideProgressBar()
                        inflateRecyclerView(it.data)
                    }
                    Status.ERROR -> {
                        hideProgressBar()
                        showError(it.message)
                    }

                    else -> {
                        showProgressBar()
                    }
                }
            } ?: kotlin.run {
                hideProgressBar()
            }


        })

    }

    private fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun inflateRecyclerView(albums: List<Album>?) {
        albums?.let {
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = AlbumAdapter(it)
        }

    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

}
