package com.example.nodo.data;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.nodo.model.NoDo;

import java.util.List;

@Dao
public interface NoDoDao {


     @Insert
    void insert(NoDo nodo);

     @Query("DELETE FROM nodo_table")
    void deleteAll();



      @Query("DELETE FROM NODO_TABLE WHERE id= :id")
     int deleteANoDo(int id);

      @Query("UPDATE nodo_table SET nodo_col= :nodoText WHERE id = :id")
      int updateNoDoItem(int id,String nodoText);



      @Query("SELECT * FROM nodo_table ORDER BY nodo_col DESC")
      LiveData<List<NoDo>> getAllNoDos();


}
