package com.example.android.badmintonscoreboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class SingleReg extends AppCompatActivity {
    //Single game player names
    EditText playerAName;
    EditText playerBName;
    //double game player names
    EditText playerA1Name;
    EditText playerA2Name;
    EditText playerB1Name;
    EditText playerB2Name;


    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_reg);

       mToolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        playerAName = (EditText) findViewById(R.id.nameA);
        playerBName = (EditText) findViewById(R.id.nameB);
        playerA1Name = (EditText) findViewById(R.id.nameA1);
        playerA2Name = (EditText) findViewById(R.id.nameA2);
        playerB1Name = (EditText) findViewById(R.id.nameB1);
        playerB2Name = (EditText) findViewById(R.id.nameB2);

    }
    // do this when single registration button is clicked.
    public void singleRegister (View view){
        //Hide double registration view
        LinearLayout doubleRegistration = (LinearLayout) findViewById(R.id.double_registration);
        doubleRegistration.setVisibility(LinearLayout.GONE);
        //Get single registration view back
        LinearLayout singleRegistration = (LinearLayout) findViewById(R.id.single_registration);
        singleRegistration.setVisibility(LinearLayout.VISIBLE);
        //Change double registration button text color & background color
        Button doubleRegButton = (Button) findViewById(R.id.button_double_game);
        doubleRegButton.setTextColor(getResources().getColor(R.color.grey));
        doubleRegButton.setBackgroundColor(getResources().getColor(R.color.black_dark));
        Button singleRegButton = (Button) findViewById(R.id.button_single_game);
        singleRegButton.setTextColor(getResources().getColor(R.color.white));
        singleRegButton.setBackgroundColor(getResources().getColor(R.color.black));
        //catch players' name
       //playerAName = (EditText) findViewById(R.id.nameA);
        //playerBName = (EditText) findViewById(R.id.nameB);
    }
    // do this when double registration button is clicked.
    public void doubleRegister(View view) {
        //Hide single registration view
        LinearLayout singleRegistration = (LinearLayout) findViewById(R.id.single_registration);
        singleRegistration.setVisibility(LinearLayout.GONE);
        //get double registration view back
        LinearLayout doubleRegistration = (LinearLayout) findViewById(R.id.double_registration);
        doubleRegistration.setVisibility(LinearLayout.VISIBLE);
        //Change double registration button text color
        Button singleRegButton = (Button) findViewById(R.id.button_single_game);
        singleRegButton.setTextColor(getResources().getColor(R.color.grey));
        singleRegButton.setBackgroundColor(getResources().getColor(R.color.black_dark));
        Button doubleRegButton = (Button) findViewById(R.id.button_double_game);
        doubleRegButton.setTextColor(getResources().getColor(R.color.white));
        doubleRegButton.setBackgroundColor(getResources().getColor(R.color.black));
        //catch players' name
        //playerA1Name = (EditText) findViewById(R.id.nameA1);
        //playerA2Name = (EditText) findViewById(R.id.nameA2);
        //playerB1Name = (EditText) findViewById(R.id.nameB1);
        //playerB2Name = (EditText) findViewById(R.id.nameB2);
    }
    //start single game, passing players' name to SingleScore class
    public void startSingle(View view) {
        Intent startSingleGame = new Intent(SingleReg.this, com.example.android.badmintonscoreboard.SingleScore.class);
        startSingleGame.putExtra("playerA", playerAName.getText().toString());
        startSingleGame.putExtra("playerB", playerBName.getText().toString());
        startActivity(startSingleGame);
    }
    //start double game, passing players' name to DoubleScore class
    public void startDouble(View view) {
        Intent startDoubleGame = new Intent(SingleReg.this, com.example.android.badmintonscoreboard.DoubleScore.class);
        startDoubleGame.putExtra("playerA1", playerA1Name.getText().toString());
        startDoubleGame.putExtra("playerB1", playerB1Name.getText().toString());
        startDoubleGame.putExtra("playerA2", playerA2Name.getText().toString());
        startDoubleGame.putExtra("playerB2", playerB2Name.getText().toString());
        startActivity(startDoubleGame);
    }
}



