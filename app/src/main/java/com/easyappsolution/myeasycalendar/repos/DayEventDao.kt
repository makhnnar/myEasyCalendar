package com.easyappsolution.myeasycalendar.repos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easyappsolution.myeasycalendar.repos.models.DayEvent

@Dao
interface DayEventDao {

    //SELECT usuario_player.id_player,player.nickname FROM login.usuario_player LEFT JOIN nucleo.player ON usuario_player.id_player=player.id_player WHERE id_usuario = $1

    @Query("SELECT * from dayevent_table LEFT JOIN eventondays_table ON eventondays_table.id_event = dayevent_table.id LEFT JOIN day_table ON day_table.id = eventondays_table.id_day WHERE day_table.id = :idDay")
    fun getSessionUser(idDay: String?): DayEvent?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dayEvent: DayEvent)

    @Query("DELETE FROM dayevent_table")
    fun deleteAll()


}