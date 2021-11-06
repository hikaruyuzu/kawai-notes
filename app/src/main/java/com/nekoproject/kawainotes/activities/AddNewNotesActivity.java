package com.nekoproject.kawainotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.nekoproject.kawainotes.R;
import com.nekoproject.kawainotes.database.MyNoteDatabase;
import com.nekoproject.kawainotes.entities.MyNoteEntities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddNewNotesActivity extends AppCompatActivity {
    private EditText inputNoteTitle, inputNoteText;
    private TextView textDateTime, saveNote;
    private View indicator1, indicator2;
    String selectedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_notes2);

        selectedColor = "#FF937B";

        saveNote = findViewById(R.id.save_note);
        inputNoteTitle = findViewById(R.id.input_note_title);
        inputNoteText = findViewById(R.id.input_note_text);
        textDateTime = findViewById(R.id.textDateTime);
        indicator1 = findViewById(R.id.viewIndicator);
        indicator2 = findViewById(R.id.viewIndicator2);

        saveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNotes();
            }
        });
        textDateTime.setText(
                new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm a", Locale.getDefault()).format(new Date())
        );

        bottomSheet();
        setViewColor();

    }

    private void setViewColor() {
        GradientDrawable gradientDrawable = (GradientDrawable) indicator1.getBackground();
        gradientDrawable.setColor(Color.parseColor(selectedColor));

        GradientDrawable gradientDrawable2 = (GradientDrawable) indicator2.getBackground();
        gradientDrawable2.setColor(Color.parseColor(selectedColor));
    }

    private void saveNotes() {
        if(inputNoteTitle.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Note title can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }else if (inputNoteText.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Note text can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        final MyNoteEntities myNoteEntities = new MyNoteEntities();

        myNoteEntities.setTitle(inputNoteTitle.getText().toString());
        myNoteEntities.setNoteText(inputNoteText.getText().toString());
        myNoteEntities.setDate_time(textDateTime.getText().toString());
        myNoteEntities.setColor(selectedColor);

        class saveNotes extends AsyncTask<Void,Void,Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                MyNoteDatabase.getMyNoteDatabase(getApplicationContext())
                        .myNotesDao().insertNote(myNoteEntities);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        }
        new saveNotes().execute();
    }

    private void bottomSheet() {
        final LinearLayout linearLayout = findViewById(R.id.bottom_layout);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(linearLayout);
        linearLayout.findViewById(R.id.bottom_text).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }
        });

        final ImageView imgcolor1 = linearLayout.findViewById(R.id.imageColor1);
        final ImageView imgcolor2 = linearLayout.findViewById(R.id.imageColor2);
        final ImageView imgcolor3 = linearLayout.findViewById(R.id.imageColor3);
        final ImageView imgcolor4 = linearLayout.findViewById(R.id.imageColor4);
        final ImageView imgcolor5 = linearLayout.findViewById(R.id.imageColor5);
        final ImageView imgcolor6 = linearLayout.findViewById(R.id.imageColor6);

        linearLayout.findViewById(R.id.viewColor1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectedColor = "#FF937B";
                imgcolor1.setImageResource(R.drawable.ic_baseline_done_24);
                imgcolor2.setImageResource(0);
                imgcolor3.setImageResource(0);
                imgcolor4.setImageResource(0);
                imgcolor5.setImageResource(0);
                imgcolor6.setImageResource(0);
                setViewColor();
            }
        });

        linearLayout.findViewById(R.id.viewColor2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectedColor = "#FFFB7B";
                imgcolor1.setImageResource(0);
                imgcolor2.setImageResource(R.drawable.ic_baseline_done_24);
                imgcolor3.setImageResource(0);
                imgcolor4.setImageResource(0);
                imgcolor5.setImageResource(0);
                imgcolor6.setImageResource(0);
                setViewColor();
            }
        });


        linearLayout.findViewById(R.id.viewColor3).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectedColor = "#ADFF7B";
                imgcolor1.setImageResource(0);
                imgcolor2.setImageResource(0);
                imgcolor3.setImageResource(R.drawable.ic_baseline_done_24);
                imgcolor4.setImageResource(0);
                imgcolor5.setImageResource(0);
                imgcolor6.setImageResource(0);
                setViewColor();
            }
        });

        linearLayout.findViewById(R.id.viewColor4).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectedColor = "#96FFEA";
                imgcolor1.setImageResource(0);
                imgcolor2.setImageResource(0);
                imgcolor3.setImageResource(0);
                imgcolor4.setImageResource(R.drawable.ic_baseline_done_24);
                imgcolor5.setImageResource(0);
                imgcolor6.setImageResource(0);
                setViewColor();
            }
        });

        linearLayout.findViewById(R.id.viewColor5).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectedColor = "#969CFF";
                imgcolor1.setImageResource(0);
                imgcolor2.setImageResource(0);
                imgcolor3.setImageResource(0);
                imgcolor4.setImageResource(0);
                imgcolor5.setImageResource(R.drawable.ic_baseline_done_24);
                imgcolor6.setImageResource(0);
                setViewColor();
            }
        });

        linearLayout.findViewById(R.id.viewColor6).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectedColor = "#FF96F5";
                imgcolor1.setImageResource(0);
                imgcolor2.setImageResource(0);
                imgcolor3.setImageResource(0);
                imgcolor4.setImageResource(0);
                imgcolor5.setImageResource(0);
                imgcolor6.setImageResource(R.drawable.ic_baseline_done_24);
                setViewColor();
            }
        });
    }
}