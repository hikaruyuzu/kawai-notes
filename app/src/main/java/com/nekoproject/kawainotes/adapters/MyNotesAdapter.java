package com.nekoproject.kawainotes.adapters;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.nekoproject.kawainotes.R;
import com.nekoproject.kawainotes.entities.MyNoteEntities;

import java.util.List;

public class MyNotesAdapter extends RecyclerView.Adapter<MyNotesAdapter.ViewHolder> {

    List<MyNoteEntities> myNoteEntitiesList;

    public MyNotesAdapter(List<MyNoteEntities> myNoteEntitiesList) {
        this.myNoteEntitiesList = myNoteEntitiesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setNote(myNoteEntitiesList.get(position));
    }

    @Override
    public int getItemCount() {
        return myNoteEntitiesList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView roundedImageView;
        private TextView title, textNote, dateTime;
        private LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            roundedImageView = itemView.findViewById(R.id.imageNote_item);
            title = itemView.findViewById(R.id.textTitle);
            textNote = itemView.findViewById(R.id.textNote);
            dateTime = itemView.findViewById(R.id.textDateTime);
            linearLayout = itemView.findViewById(R.id.layoutNote);
        }

        public void setNote(MyNoteEntities myNoteEntities) {
            title.setText(myNoteEntities.getTitle());
            textNote.setText(myNoteEntities.getNoteText());
            dateTime.setText(myNoteEntities.getDate_time());

            GradientDrawable gradientDrawable = (GradientDrawable) linearLayout.getBackground();
            if (myNoteEntities.getColor() != null) {
                gradientDrawable.setColor(Color.parseColor(myNoteEntities.getColor()));
            } else {
                gradientDrawable.setColor(Color.parseColor("#FF937B"));
            }
        }
    }
}
