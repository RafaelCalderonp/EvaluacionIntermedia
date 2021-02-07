package com.example.evaluacinintermedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evaluacinintermedia.databinding.FragmentSecondBinding
import com.example.evaluacinintermedia.databinding.ItemListBinding
import com.example.evaluacinintermedia.viewModel.ItemViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    private lateinit var mBinding: FragmentSecondBinding
    private lateinit var binding: ItemListBinding
    private val mViewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSecondBinding.inflate(inflater, container,false)
        return mBinding.root

        binding = ItemListBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter =ItemAdapter()
        mBinding.recyclerView.adapter = adapter
        mBinding.recyclerView.layoutManager = LinearLayoutManager(context)
        mViewModel.allItem.observe(viewLifecycleOwner, Observer {
            it?.let{
                adapter.update(it)
            }
            mBinding.fbBorrar.setOnClickListener {
                mViewModel.deleteAll()
            }

        })


    }
}