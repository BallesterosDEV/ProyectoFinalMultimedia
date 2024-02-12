package com.example.ballesteroslaraev2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
/**
 * The CharacterAdapter class is responsible for adapting a list of Character objects
 * to be displayed in a RecyclerView.
 */
public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    private List<Character> characterList;
    /**
     * Constructs a CharacterAdapter with the given list of characters.
     * @param characterList The list of characters to adapt.
     */
    public CharacterAdapter(List<Character> characterList) {
        this.characterList = characterList;
    }
    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new CharacterViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(view);
    }
    /**
     * Called by RecyclerView to display the data at the specified position.
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characterList.get(position);
        holder.bind(character);
    }
    /**
     * Returns the total number of items in the data set held by the adapter.
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return characterList.size();
    }
    /**
     * The CharacterViewHolder class represents a ViewHolder for a Character item in the RecyclerView.
     */
    static class CharacterViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView raceTextView;
        private TextView heightTextView;
        private TextView weightTextView;
        /**
         * Constructs a CharacterViewHolder.
         * @param itemView The view associated with the ViewHolder.
         */
        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            raceTextView = itemView.findViewById(R.id.raceTextView);
            heightTextView = itemView.findViewById(R.id.heightTextView);
            weightTextView = itemView.findViewById(R.id.weightTextView);
        }
        /**
         * Binds data from a Character object to the views in the ViewHolder.
         * @param character The Character object to bind.
         */
        public void bind(Character character) {
            nameTextView.setText( "Name: " + character.getName());
            raceTextView.setText("Race: " + character.getRace());
            heightTextView.setText("Height: " + String.valueOf(character.getHeight()));
            weightTextView.setText("Weight: " + String.valueOf(character.getWeight()));
        }
    }
}
