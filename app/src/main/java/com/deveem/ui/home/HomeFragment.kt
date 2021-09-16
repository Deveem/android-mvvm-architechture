package com.deveem.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.deveem.R
import com.deveem.core.ui.BaseNavFragment
import com.deveem.core.ui.widgets.MainToolbar
import com.deveem.core.utils.Log
import com.deveem.core.utils.Toast
import com.deveem.data.models.Post
import com.deveem.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseNavFragment<HomeViewModel, FragmentHomeBinding>(), PostListAdapter.OnItemClickListener {

    override val viewModel: HomeViewModel by viewModel()

    override fun initViewModel() {
        super.initViewModel()

        viewModel.posts.observe(this) {

            it.data?.let { data ->
                setRecyclerView(data)
            }
        }

        viewModel.onGetPosts()
    }

    private fun setRecyclerView(items: List<Post>) {

        val chatListAdapter = PostListAdapter(items, this)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = chatListAdapter
        }
    }

    override fun onItemClick(item: Post, position: Int) {
        TODO("Not yet implemented")
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding {

        val v = FragmentHomeBinding.inflate(inflater, container, false)
        v.toolBar.bind(
            leftButton = MainToolbar.ActionInfo(
                onClick = {
                    Toast.show(requireContext(), "Action left")
                }
            ),
            rightButton = MainToolbar.ActionInfo(
            onClick = {
                Toast.show(requireContext(), "Action right")
            },
            iconRes = R.drawable.ic_home_black_24dp
        )
        )
        return v
    }

    override fun bindViewBinding(view: View): FragmentHomeBinding {
        return FragmentHomeBinding.bind(view)
    }
}