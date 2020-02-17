package com.example.nodo.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nodo_table")

public class NoDo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo( name = "nodo_col")
    private String  nodo;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNodo(String nodo) {
        this.nodo = nodo;
    }
    public String getNodo() {
        return nodo;
    }

    public NoDo(@NonNull String nodo) {
        this.nodo = nodo;
    }
}
