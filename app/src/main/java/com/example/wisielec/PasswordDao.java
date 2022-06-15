package com.example.wisielec;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PasswordDao {

    @Query("SELECT content FROM password")
    List<String> getAll();

    @Query("SELECT content FROM password WHERE category LIKE :cat")
    List<String> findInSpecificCategory(String cat);

    @Insert
    public void insertAll(Password... passwords);

    @Delete
    void delete(Password password);
}
