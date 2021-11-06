package com.nekoproject.kawainotes.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nekoproject.kawainotes.R;
import com.nekoproject.kawainotes.activities.AddNewShoppingListActivity;

public class ShoppingListFragment extends Fragment {

    ImageView addShoppingList;
    public static final int REQUEST_CODE_ADD_NOTE = 1;

    public ShoppingListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_shopping_list, container, false);
        addShoppingList = view.findViewById(R.id.add_shopping_list);
        addShoppingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getContext(), AddNewShoppingListActivity.class), REQUEST_CODE_ADD_NOTE);
            }
        });

        return view;
    }
}