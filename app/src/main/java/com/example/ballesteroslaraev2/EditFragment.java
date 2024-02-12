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

/**
 * The EditFragment class represents a Fragment responsible for editing a character.
 */
public class EditFragment extends Fragment {

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
        View rootView = inflater.inflate(R.layout.fragment_edit, container, false);

        idInputLayout = rootView.findViewById(R.id.id);
        nameInputLayout = rootView.findViewById(R.id.name);
        raceInputLayout = rootView.findViewById(R.id.race);
        heightInputLayout = rootView.findViewById(R.id.height);
        weightInputLayout = rootView.findViewById(R.id.weight);
        submitButton = rootView.findViewById(R.id.submit);

        submitButton.setOnClickListener(v -> updateCharacter());

        return rootView;
    }

    /**
     * Updates a character in the database based on the provided information.
     */
    private void updateCharacter() {
        String id = idInputLayout.getEditText().getText().toString();
        String name = nameInputLayout.getEditText().getText().toString();
        String race = raceInputLayout.getEditText().getText().toString();
        String heightStr = heightInputLayout.getEditText().getText().toString();
        String weightStr = weightInputLayout.getEditText().getText().toString();

        if (id.isEmpty() || name.isEmpty() || race.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill in all fields.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!heightStr.matches("\\d+(\\.\\d+)?") || !weightStr.matches("\\d+(\\.\\d+)?")) {
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

        float height = Float.parseFloat(heightStr);
        float weight = Float.parseFloat(weightStr);

        AdminSQliteOpenHelper dbHelper = new AdminSQliteOpenHelper(requireContext(), "charactersDB", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("race", race);
        values.put("height", height);
        values.put("weight", weight);

        int rowsAffected = db.update("characters", values, "id = ?", new String[]{id});
        db.close();

        if (rowsAffected > 0) {
            Toast.makeText(requireContext(), "Character updated successfully.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(requireContext(), "Failed to update character. Please check the ID.", Toast.LENGTH_SHORT).show();
        }
    }
}