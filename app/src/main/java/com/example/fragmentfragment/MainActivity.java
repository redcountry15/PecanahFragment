package com.example.fragmentfragment;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment (new home());

        BottomNavigationView navigation = findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
        Fragment fragment =null;

        switch (Item.getItemId()){
            case R.id.navigation_home:
                fragment = new home();
            break;
            case R.id.navigation_dashboard:
                fragment = new dashboard();
            break;
            case R.id.navigation_notifications:
                fragment = new notifications();
            break;
            case R.id.navigation_profile:
                fragment = new profile();
            break;
        }
        return loadFragment(fragment);
    }
}
