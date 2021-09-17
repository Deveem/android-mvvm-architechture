package com.deveem.ui.post.single

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.deveem.core.ui.BaseNavFragment
import com.deveem.core.ui.widgets.MainToolbar
import com.deveem.databinding.FragmentPostBinding
import com.deveem.ui.post.PostViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostFragment : BaseNavFragment<PostViewModel, FragmentPostBinding>() {

    private val navArgs: PostFragmentArgs by navArgs()

    override val viewModel: PostViewModel by viewModel()

    override fun initView() {
        super.initView()

        navArgs.post?.let {
            binding.tvTitle.text = it.title
            binding.tvBody.text = it.body
        }
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentPostBinding {

        val v = FragmentPostBinding.inflate(inflater, container, false)
        v.toolBar.bind(
            leftButton = MainToolbar.ActionInfo(
                onClick = {
                    requireActivity().onBackPressed()
                }
            )
        )
        return v
    }

    override fun bindViewBinding(view: View): FragmentPostBinding {
        return FragmentPostBinding.bind(view)
    }
}