package com.example.evaluacinintermedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.evaluacinintermedia.databinding.FragmentFirstBinding
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.evaluacinintermedia.model.ItemEntity
import com.example.evaluacinintermedia.viewModel.ItemViewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var mBinding: FragmentFirstBinding
    private val mViewModel: ItemViewModel by activityViewModels()
    private var ctdTemp = 0
    private var total= 0
    private  var precio = 0


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentFirstBinding.inflate(inflater, container, false)
        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.spCtd.minValue = 1
        mBinding.spCtd.maxValue =100

        mBinding.spCtd.setOnValueChangedListener { picker, oldVal, newVal ->
            mBinding.spCtd.value
            ctdTemp = newVal

            if(mBinding.etPrecio.text.isEmpty()) {
                Toast.makeText(context, "Ingrese precio unitario", Toast.LENGTH_SHORT).show()
            }
            else {
                precio = mBinding.etPrecio.text.toString().toInt()
            }
            total = mViewModel.total(precio , newVal)
            mBinding.tvTotal.setText(total.toString())
            //Toast.makeText(context,mBinding.etPrecio.text.toString(),Toast.LENGTH_LONG ).show()
        }
       mBinding.btGuardar.setOnClickListener {
          saveItem()
       }


        mBinding.btMostrar.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
           
        }
    private fun saveItem(){
        val nombre:String = mBinding.etNombre.text.toString()
        if(nombre.isEmpty()){
            Toast.makeText(context,"asopao",Toast.LENGTH_SHORT ).show()
        }else{
            val newItem = ItemEntity(nombre=nombre, precio = precio, ctd = ctdTemp, total = total)
            mViewModel.insertItem(newItem)
            Toast.makeText(context,"Item agregado exitosamente",Toast.LENGTH_SHORT ).show()

        }

    }

}