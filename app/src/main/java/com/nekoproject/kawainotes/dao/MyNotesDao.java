package com.nekoproject.kawainotes.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.nekoproject.kawainotes.entities.MyNoteEntities;

import java.util.List;

@Dao
public interface MyNotesDao {
    @Query("SELECT * FROM note ORDER BY id DESC")
    List<MyNoteEntities> getAllNotes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(MyNoteEntities notesEntities);

    @Delete
    void deleteNotes(MyNoteEntities notesEntities);
}

