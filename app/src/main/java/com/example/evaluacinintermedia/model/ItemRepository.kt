package com.example.evaluacinintermedia.model

import androidx.lifecycle.LiveData

class ItemRepository(private val itemDao: ItemDao) {
    val listAllItem: LiveData<List<ItemEntity>> = itemDao.getAllItem()

    suspend fun insertItem(item: ItemEntity) {
        itemDao.insertItem(item)
    }

    suspend fun updateItem(item: ItemEntity) {
        itemDao.updateItem(item)
    }

    suspend fun deleteAll() {
        itemDao.deleteAll()
    }
    suspend fun deleteItem(item: ItemEntity){
        itemDao.deleteItem(item)
    }

    fun getItemByID(id: Int): LiveData<ItemEntity> {
        return itemDao.getItemByID(id)
    }
}