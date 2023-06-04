package com.example.asmaapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final DrawerLayout drawerLayout= findViewById(R.id.drawerlayout);
       findViewById(R.id.image1).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               drawerLayout.openDrawer(GravityCompat.START);
           }
       });
        NavigationView navigationView= findViewById(R.id.nav);
        navigationView.setItemIconTintList(null);
        NavController navController= Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupWithNavController(navigationView,navController);
        final TextView Titel=findViewById(R.id.text);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                Titel.setText(navDestination.getLabel());
            }
        });
    }
}