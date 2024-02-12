package com.example.ballesteroslaraev2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;


/**
 * The DeleteFragment class represents a Fragment responsible for deleting a character.
 */
public class DeleteFragment extends Fragment {

    private TextInputLayout idInputLayout;
    private Button submitButton;

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
        View rootView = inflater.inflate(R.layout.fragment_delete, container, false);

        idInputLayout = rootView.findViewById(R.id.id);
        submitButton = rootView.findViewById(R.id.submit);

        submitButton.setOnClickListener(view -> {
            String id = idInputLayout.getEditText().getText().toString().trim();
            if (!id.isEmpty()) {
                deleteCharacter(id);
            } else {
                Toast.makeText(requireContext(), "Type a valid ID", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    /**
     * Deletes a character from the database based on the provided ID.
     * @param id The ID of the character to delete.
     */
    private void deleteCharacter(String id) {
        AdminSQliteOpenHelper dbHelper = new AdminSQliteOpenHelper(requireContext(), "charactersDB", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        int deletedRows = db.delete("characters", "id = ?", new String[]{id});

        if (deletedRows > 0) {
            Toast.makeText(requireContext(), "Character deleted successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(requireContext(), "Cannot delete the character. Check the ID", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }
}