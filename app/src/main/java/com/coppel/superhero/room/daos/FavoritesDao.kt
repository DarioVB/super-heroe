package com.coppel.superhero.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coppel.superhero.models.Hero

@Dao
interface FavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(hero: Hero) : Long

    @Query("SELECT * FROM favorites_table WHERE hero_id LIKE :id")
    fun getHero(id: String?) : LiveData<List<Hero>>

    @Query("SELECT EXISTS(SELECT * FROM favorites_table WHERE hero_id = :id)")
    fun isRowExist(id : String) : Boolean

    @Query("DELETE FROM favorites_table")
    fun delete() : Int

    @Query("SELECT * FROM favorites_table ORDER BY hero_name ASC")
    fun favoriteHeroes() : LiveData<List<Hero>>
}