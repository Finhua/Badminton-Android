package com.example.android.badmintonscoreboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private List<Game> games;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Context mContext = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initializeData();
        initGameList();
        initCollapsingToolbarLayout();
        initToolbar();
        initNavDrawer();
    }

    private void initCollapsingToolbarLayout() {

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(getString(R.string.app_name));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.white));

    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(getString(R.string.app_name));
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
    }

    public void singleReg(View view) {
        Intent singleRegisterForm = new Intent(this, com.example.android.badmintonscoreboard.SingleReg.class);

        startActivity(singleRegisterForm);
    }

    private void initGameList() {
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);


        com.example.android.badmintonscoreboard.GameAdapter adapter = new com.example.android.badmintonscoreboard.GameAdapter(games);
        rv.setAdapter(adapter);
    }

    private void initNavDrawer() {
        if (mToolbar != null) {
            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToolbar.setNavigationIcon(R.drawable.ic_dehaze_white_24dp);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            });
        }

        mNavigationView = (NavigationView) findViewById(R.id.nav_drawer);
        mNavigationView.getMenu().getItem(0).setChecked(true);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_settings: {
                       /* Intent i = new Intent(mContext, Log.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        startActivity(i);*/
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                    case R.id.action_profile: {
                        /*Intent i = new Intent(mContext, Setup.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        startActivity(i);*/
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                    default:
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                }
            }
        });
/*        if (!mUserLearnedDrawer) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            mUserLearnedDrawer = true;
            saveSharedSetting(this, PREF_USED_DRAWER, "true");
        }*/
    }



    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData(){
        games = new ArrayList<>();
        games.add(new Game("Game one"));
        games.add(new Game("Game two"));
        games.add(new Game("Game three"));
        games.add(new Game("Game four"));
        games.add(new Game("Game five"));
        games.add(new Game("Game six"));
        games.add(new Game("Game seven"));
        games.add(new Game("Game eight"));
        games.add(new Game("Game one"));
        games.add(new Game("Game two"));
        games.add(new Game("Game three"));
        games.add(new Game("Game four"));
        games.add(new Game("Game five"));
        games.add(new Game("Game six"));
        games.add(new Game("Game seven"));
        games.add(new Game("Game eight"));
        games.add(new Game("Game one"));
        games.add(new Game("Game two"));
        games.add(new Game("Game three"));
        games.add(new Game("Game four"));
        games.add(new Game("Game five"));
        games.add(new Game("Game six"));
        games.add(new Game("Game seven"));
        games.add(new Game("Game eight"));

    }




}