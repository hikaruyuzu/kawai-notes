package com.nekoproject.kawainotes.fragments;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nekoproject.kawainotes.R;
import com.nekoproject.kawainotes.activities.AddNewNotesActivity;
import com.nekoproject.kawainotes.activities.AddNewReminderActivity;
import com.nekoproject.kawainotes.adapters.MyNotesAdapter;
import com.nekoproject.kawainotes.database.MyNoteDatabase;
import com.nekoproject.kawainotes.entities.MyNoteEntities;

import java.util.ArrayList;
import java.util.List;


public class MyNotesFragment extends Fragment {

    ImageView addMyNotes;
    public static final int REQUEST_CODE_ADD_NOTE = 1;

    private RecyclerView noteRec;
    private List<MyNoteEntities> myNoteEntitiesList;
    private MyNotesAdapter myNotesAdapter;

    public MyNotesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_notes, container, false);
        addMyNotes = view.findViewById(R.id.add_notes_list);
        addMyNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getContext(), AddNewNotesActivity.class), REQUEST_CODE_ADD_NOTE);
            }
        });

        noteRec = view.findViewById(R.id.note_rec);
        noteRec.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        myNoteEntitiesList = new ArrayList<>();
        myNotesAdapter = new MyNotesAdapter(myNoteEntitiesList);
        noteRec.setAdapter(myNotesAdapter);

        getAllNotes();

        return view;
    }

    private void getAllNotes() {

        @SuppressLint("StaticFieldLeak")
        class GetNoteTask extends AsyncTask<Void,Void,List<MyNoteEntities>>{

            @Override
            protected List<MyNoteEntities> doInBackground(Void... voids) {
                return MyNoteDatabase
                        .getMyNoteDatabase(getActivity().getApplicationContext())
                        .myNotesDao()
                        .getAllNotes();
            }

            @Override
            protected void onPostExecute(List<MyNoteEntities> myNoteEntities) {
                super.onPostExecute(myNoteEntities);
                if(myNoteEntitiesList.size() == 0) {
                    myNoteEntitiesList.addAll(myNoteEntities);
                    myNotesAdapter.notifyDataSetChanged();
                } else {
                    myNoteEntitiesList.add(0, myNoteEntities.get(0));
                    myNotesAdapter.notifyItemInserted(0);
                }
                noteRec.smoothScrollToPosition(0);
            }
        }
        new GetNoteTask().execute();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if (requestCode == REQUEST_CODE_ADD_NOTE && resultCode == RESULT_OK) {
            getAllNotes();
        }
    }
}