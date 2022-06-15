package com.example.wisielec;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Password {

    public Password(String content, String category){
        this.content = content;
        this.category = category;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "content")
    public String content;

    @ColumnInfo(name = "category")
    public String category;
}
