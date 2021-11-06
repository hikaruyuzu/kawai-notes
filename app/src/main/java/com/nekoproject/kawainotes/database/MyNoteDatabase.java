package com.nekoproject.kawainotes.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nekoproject.kawainotes.dao.MyNotesDao;
import com.nekoproject.kawainotes.entities.MyNoteEntities;

@Database(entities = MyNoteEntities.class, version = 1, exportSchema = false)
public abstract class MyNoteDatabase extends RoomDatabase {

    private static MyNoteDatabase myNoteDatabase;

    public  static synchronized MyNoteDatabase getMyNoteDatabase(Context context) {
        if (myNoteDatabase == null) {
            myNoteDatabase = Room.databaseBuilder(context,
                    MyNoteDatabase.class,
                    "note_db"
            ).build();
        }
        return myNoteDatabase;
    }

    public abstract MyNotesDao myNotesDao();

}
