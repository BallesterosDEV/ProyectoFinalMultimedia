package com.example.ballesteroslaraev2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * The HomeFragment class represents a Fragment responsible for displaying a list of characters.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private CharacterAdapter adapter;
    private List<Character> characterList;

    /**
     * Called to have the fragment instantiate its user interface view.
     * @param inflater The LayoutInflater object that can be used to inflate views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
     * @return Return the View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        characterList = new ArrayList<>();
        adapter = new CharacterAdapter(characterList);
        recyclerView.setAdapter(adapter);

        loadCharactersFromDatabase();

        return rootView;
    }

    /**
     * Loads characters from the database and populates the RecyclerView with the data.
     */
    private void loadCharactersFromDatabase() {
        AdminSQliteOpenHelper dbHelper = new AdminSQliteOpenHelper(requireContext(), "charactersDB", null, 1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM characters", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    int idColumnIndex = cursor.getColumnIndex("id");
                    int nameColumnIndex = cursor.getColumnIndex("name");
                    int raceColumnIndex = cursor.getColumnIndex("race");
                    int heightColumnIndex = cursor.getColumnIndex("height");
                    int weightColumnIndex = cursor.getColumnIndex("weight");

                    String id = cursor.getString(idColumnIndex);
                    String name = cursor.getString(nameColumnIndex);
                    String race = cursor.getString(raceColumnIndex);
                    float height = cursor.getFloat(heightColumnIndex);
                    float weight = cursor.getFloat(weightColumnIndex);

                    Character character = new Character(id, name, race, height, weight);
                    characterList.add(character);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        db.close();

        adapter.notifyDataSetChanged();
    }
}