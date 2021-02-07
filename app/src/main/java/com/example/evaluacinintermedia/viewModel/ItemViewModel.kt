package com.example.evaluacinintermedia.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.evaluacinintermedia.model.ItemDataBase
import com.example.evaluacinintermedia.model.ItemEntity
import com.example.evaluacinintermedia.model.ItemRepository
import com.example.evaluacinintermedia.model.RegisterModel
import kotlinx.coroutines.launch

class ItemViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ItemRepository
    private val register: RegisterModel
    val allItem: LiveData<List<ItemEntity>>

    init {
        val itemDao = ItemDataBase.getDataBase(application).getItemDao()
        repository = ItemRepository(itemDao)
        allItem = repository.listAllItem
        register=RegisterModel()
    }

    fun insertItem(item: ItemEntity) = viewModelScope.launch {
        repository.insertItem(item)
    }

    fun updateItem(item: ItemEntity) = viewModelScope.launch {
        repository.updateItem(item)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }
    fun deleteItem(item: ItemEntity) = viewModelScope.launch{
        repository.deleteItem(item)
    }

    fun getItemById(id: Int): LiveData<ItemEntity> {
        return repository.getItemByID(id)
    }
    fun total(precio: Int, ctd: Int):Int{
        return register.total(precio, ctd)
    }

}