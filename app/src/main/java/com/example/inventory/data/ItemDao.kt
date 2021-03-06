package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("select * from item where id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("select * from item order by name desc")
    fun getItems(): Flow<List<Item>>
}