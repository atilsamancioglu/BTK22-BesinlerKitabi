package com.atilsamancioglu.besinlerkitabi.servis

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.atilsamancioglu.besinlerkitabi.model.Besin

@Dao
interface BesinDAO {

    //Data Access Object

    @Insert
    suspend fun insertAll(vararg besin : Besin) : List<Long>

    //Insert -> Room, insert into
    // suspend -> coroutine scope
    // vararg -> birden fazla ve istediğimiz sayıda besin
    // List<Long> -> long, id'ler

    @Query("SELECT * FROM besin")
    suspend fun getAllBesin() : List<Besin>

    @Query("SELECT * FROM besin WHERE uuid = :besinId")
    suspend fun getBesin(besinId : Int) : Besin

    @Query("DELETE FROM besin")
    suspend fun deleteAllBesin()



}