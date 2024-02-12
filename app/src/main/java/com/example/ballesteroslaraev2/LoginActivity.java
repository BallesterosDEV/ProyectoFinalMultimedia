package com.example.ballesteroslaraev2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.textfield.TextInputLayout;

/**
 * The LoginActivity class represents the login screen of the application.
 * Users enter their username and password to access the application.
 */
public class LoginActivity extends AppCompatActivity {
    private TextInputLayout inputUser;
    private TextInputLayout inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        inputUser = findViewById(R.id.user);
        inputPassword = findViewById(R.id.password);

        Button loginButton = findViewById(R.id.submit);

        inputUser.setTypeface(ResourcesCompat.getFont(this, R.font.press_start_2p));
        inputPassword.setTypeface(ResourcesCompat.getFont(this, R.font.press_start_2p));

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    /**
     * Method to log in to the application.
     * Checks if the provided username and password are valid.
     * If valid, redirects the user to the main activity.
     */
    public void login(){
        String user = inputUser.getEditText().getText().toString();
        String password = inputPassword.getEditText().getText().toString();

        if(user.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "You cannot leave fields empty", Toast.LENGTH_SHORT).show();
            return;
        }

        // Access the database to verify user credentials
        AdminSQliteOpenHelper dbHelper = new AdminSQliteOpenHelper(this, "myDB", null, 1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {"usuario", "contraseña"};
        String selection = "usuario = ? AND contraseña = ?";
        String[] selectionArgs = {user, password};

        Cursor cursor = db.query("usuarios", projection, selection, selectionArgs, null, null, null);

        // Check if a user with the provided credentials was found
        if (cursor.moveToFirst()) {
            // If credentials are valid, start the main activity
            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            // If credentials are incorrect, display an error message
            Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
        }

        // Close the cursor and database to release resources
        cursor.close();
        db.close();
    }
}