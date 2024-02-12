package com.example.ballesteroslaraev2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class CreateFragment extends Fragment {

    private AdminSQliteOpenHelper dbHelper;
    private TextInputLayout idInputLayout;
    private TextInputLayout nameInputLayout;
    private TextInputLayout raceInputLayout;
    private TextInputLayout heightInputLayout;
    private TextInputLayout weightInputLayout;
    private Button submitButton;

    /**
     * Called to have the fragment instantiate its user interface view.
     * @param inflater The LayoutInflater object that can be used to inflate views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create, container, false);

        dbHelper = new AdminSQliteOpenHelper(requireContext(), "charactersDB", null, 1);

        idInputLayout = rootView.findViewById(R.id.id);
        nameInputLayout = rootView.findViewById(R.id.name);
        raceInputLayout = rootView.findViewById(R.id.race);
        heightInputLayout = rootView.findViewById(R.id.height);
        weightInputLayout = rootView.findViewById(R.id.weight);
        submitButton = rootView.findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCharacter();
            }
        });

        return rootView;
    }

    /**
     * Validates user input and creates a new character if input is valid.
     */
    private void createCharacter() {
        String id = idInputLayout.getEditText().getText().toString();
        String name = nameInputLayout.getEditText().getText().toString();
        String race = raceInputLayout.getEditText().getText().toString();
        String height = heightInputLayout.getEditText().getText().toString();
        String weight = weightInputLayout.getEditText().getText().toString();


        if (id.isEmpty() || name.isEmpty() || race.isEmpty() || height.isEmpty() || weight.isEmpty()) {
            Toast.makeText(requireContext(), "Please, fill all the fields.", Toast.LENGTH_SHORT).show();
            return;
        }


        if (!id.matches("\\d+")) {
            Toast.makeText(requireContext(), "ID must contain only numbers.", Toast.LENGTH_SHORT).show();
            return;
        }


        if (!height.matches("\\d+(\\.\\d+)?") || !weight.matches("\\d+(\\.\\d+)?")) {
            Toast.makeText(requireContext(), "Height and weight must contain only numbers.", Toast.LENGTH_SHORT).show();
            return;
        }


        if (name.length() < 3) {
            Toast.makeText(requireContext(), "Name must have at least 3 characters.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (race.length() < 3) {
            Toast.makeText(requireContext(), "Race must have at least 3 characters.", Toast.LENGTH_SHORT).show();
            return;
        }



        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("race", race);
        values.put("height", height);
        values.put("weight", weight);

        long newRowId = db.insert("characters", null, values);
        db.close();

        if (newRowId != -1) {
            Toast.makeText(requireContext(), "Character created successfully.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(requireContext(), "Error creating the character.", Toast.LENGTH_SHORT).show();
        }
    }
}