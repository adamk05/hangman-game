package com.example.wisielec;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Password.class}, version = 2)
public abstract class PasswordDatabase extends RoomDatabase {
    public abstract PasswordDao passwordDao();
}
