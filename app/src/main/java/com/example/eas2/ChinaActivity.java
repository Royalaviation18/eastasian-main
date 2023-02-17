package com.example.eas2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class ChinaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china);

        //Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigationDrawerOpen, R.string.navigationDrawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();


            navigationView.bringToFront();
            navigationView.setNavigationItemSelectedListener(this);

            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
                break;
            case R.id.nav_education:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new EducationFragment()).commit();
                break;

            case R.id.nav_fellowship:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FellowShipFragment()).commit();
                break;
            case R.id.nav_scholarship:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ScholarshipFragment()).commit();
                break;
            case R.id.nav_exchanges:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ExchangesFragment()).commit();
                break;
            case R.id.nav_conferences:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ConferencesFragment()).commit();
                break;
            case R.id.nav_finAid:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new FinancialAidFragment()).commit();
                break;
            case R.id.nav_internships:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new InternshipsFragment()).commit();
                break;
            case R.id.nav_univ_college:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new UniversityCollegeFragment()).commit();
                break;
            case R.id.nav_fundAgencies:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new FundAgenciesFragment()).commit();
                break;

        }

        //closes the drawer, when an item is selected
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}