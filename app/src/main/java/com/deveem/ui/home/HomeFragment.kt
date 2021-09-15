package com.deveem.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deveem.core.ui.BaseNavFragment
import com.deveem.core.utils.Log
import com.deveem.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseNavFragment<HomeViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModel()

    override fun initViewModel() {
        super.initViewModel()

        viewModel.posts.observe(this) {

            it.data?.let { data ->

                Log.d("Posts size: ${data.size}")
            }
        }

        viewModel.onGetPosts()
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding {

        val v = FragmentHomeBinding.inflate(inflater, container, false)
//        v.toolBar.bind(
//            leftButton = MainToolbar.ActionInfo(
//                onClick = {
//                    viewModel.setFirebaseUser(null)
//                    requireActivity().onBackPressed()
//                }
//            )
//        )
        return v
    }

    override fun bindViewBinding(view: View): FragmentHomeBinding {
        return FragmentHomeBinding.bind(view)
    }
}