package com.example.ballesteroslaraev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * The MainActivity class represents the main activity of the application.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is starting.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down, then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            // Verifies the ID of the selected item and navigates to the corresponding screen using NavController
            if (item.getItemId() == R.id.navigation_home) {
                navController.navigate(R.id.homeFragment);
            } else if (item.getItemId() == R.id.navigation_create) {
                navController.navigate(R.id.createFragment);
            } else if (item.getItemId() == R.id.navigation_edit) {
                navController.navigate(R.id.editFragment);
            } else if (item.getItemId() == R.id.navigation_delete) {
                navController.navigate(R.id.deleteFragment);
            } else if (item.getItemId() == R.id.navigation_login) {
                Intent intent =  new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

            // Returns true to indicate that the selection event has been handled correctly
            return true;
        });
    }
}