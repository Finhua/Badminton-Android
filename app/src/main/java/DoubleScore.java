package com.example.android.badmintonscoreboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by xiao on 26/06/2015.
 */
public class DoubleScore extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    int maxScore = 15;
    int nomScore = 21;
    TextView playerA1View;
    TextView playerA2View;
    TextView playerB1View;
    TextView playerB2View;
    TextView winnerATextView;
    TextView winnerBTextView;
    Button addA;
    Button addB;
    Button deductA;
    Button deductB;
    Button matchSummary;


    int winnerB = 0;
    int winnerA = 0;
    String playerA1Name;
    String playerA2Name;
    String playerB1Name;
    String playerB2Name;
    Button next;
    Chronometer chronometer;

    private ArrayList<String> result = new ArrayList<String>();
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.double_score);

        mToolbar = (Toolbar) findViewById(R.id.match_header);
        setSupportActionBar(mToolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        /**
         * This method starts clock when the activity starts.
         */
        chronometer = (Chronometer) findViewById(R.id.clock);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
        /**
         * This method displays the fetched team A& B palyers' name value on the screen.
         */

        playerA1View = (TextView) findViewById(R.id.playerA1_name_text_view);
        playerB1View = (TextView) findViewById(R.id.playerB1_name_text_view);
        playerA2View = (TextView) findViewById(R.id.playerA2_name_text_view);
        playerB2View = (TextView) findViewById(R.id.playerB2_name_text_view);

        Intent startDoubleGame = getIntent();
        playerA1Name = startDoubleGame.getStringExtra("playerA1");
        playerB1Name = startDoubleGame.getStringExtra("playerB1");
        playerA2Name = startDoubleGame.getStringExtra("playerA2");
        playerB2Name = startDoubleGame.getStringExtra("playerB2");

        playerA1View.setText(playerA1Name);
        playerB1View.setText(playerB1Name);
        playerA2View.setText(playerA2Name);
        playerB2View.setText(playerB2Name);
    }

    /**
     * This method calculates player A's score.
     */
    public void scoreA(View view) {
        scoreA = scoreA + 1;
        displayA(scoreA);
        // show winner name when score is 15
        if (scoreA == maxScore) {
            winnerA = winnerA + 1;
            displaySetA(winnerA);
            disButton();
            // record set score to memory
            String res = scoreA + "           :            " + scoreB;
            result.add(res);
            if (winnerA == 2) {
                gameWinnerA();
                disButtonGame();
                chronometer.stop();
                showMatchSummary();
            }
        }
    }

    /**
     * This method is called when the score B button is clicked.
     */
    public void scoreB(View view) {
        scoreB = scoreB + 1;
        displayB(scoreB);
        // show winner name when score is 15
        if (scoreB == maxScore) {
            winnerB = winnerB + 1;
            displaySetB(winnerB);
            disButton();
            // record set score to memory
            String res = scoreA + "           :            " + scoreB;
            result.add(res);
            if (winnerB == 2) {
                gameWinnerB();
                disButtonGame();
                chronometer.stop();
                showMatchSummary();
            }
        }
    }
    /**
     * This method deduct player A's score in case of wrong input.
     */
    public void deductA(View view) {
        scoreA = scoreA - 1;
        displayA(scoreA);
        if (scoreA<0){
            Toast.makeText(com.example.android.badmintonscoreboard.DoubleScore.this,"Score can't be less than zero",Toast.LENGTH_LONG).show();
            scoreA=0;
        }
        displayA(scoreA);
    }
    /**
     * This method deduct player B's score in case of wrong input.
     */
    public void deductB(View view) {
        scoreB = scoreB - 1;
        displayB(scoreB);
        if (scoreB < 0) {
            Toast.makeText(com.example.android.badmintonscoreboard.DoubleScore.this, "Score can't be less than zero", Toast.LENGTH_LONG).show();
            scoreB = 0;
        }
        displayB(scoreB);
    }
    /**
     * This method displays game winner B name and set score value on the screen.
     */
    private void showMatchSummary (){
        next =(Button)findViewById(R.id.next_button);
        next.setVisibility(Button.GONE);
        matchSummary = (Button)findViewById(R.id.double_match_summary_button);
        matchSummary.setVisibility(Button.VISIBLE);
    }
    /**
     * This method displays game winner A name and set score value on the screen.
     */
    private void gameWinnerA() {
        winnerATextView = (TextView) findViewById(R.id.winner_name_text_view);
        Intent startSingleGame = getIntent();
        playerA1Name = startSingleGame.getStringExtra("playerA1");
        playerA2Name = startSingleGame.getStringExtra("playerA2");
        winnerATextView.setText(winnerA + " : " + winnerB + "   " + playerA1Name + " & " + playerA2Name + " win this game");

    }

    /**
     * This method displays game winner B name and set score value on the screen.
     */
    private void gameWinnerB() {
        winnerBTextView = (TextView) findViewById(R.id.winner_name_text_view);
        Intent startSingleGame = getIntent();
        playerB1Name = startSingleGame.getStringExtra("playerB1");
        playerB2Name = startSingleGame.getStringExtra("playerB1");
        winnerBTextView.setText(winnerB + " : " + winnerA + "   " + playerB1Name + " & " + playerB2Name + " win this game");

    }

    /**
     * This method displays the given player A score value on the screen.
     */
    private void displayA(int number) {
        TextView playerATextView = (TextView) findViewById(
                R.id.playerA_score_text_view);
        playerATextView.setText("" + number);
    }


    /**
     * This method displays the given player B score value on the screen.
     */
    private void displayB(int number) {
        TextView playerBTextView = (TextView) findViewById(
                R.id.playerB_score_text_view);
        playerBTextView.setText("" + number);
    }

    /**
     * This method displays the given player A set value on the screen.
     */
    private void displaySetA(int number) {
        TextView setATextView = (TextView) findViewById(
                R.id.playerA_set_text_view);
        setATextView.setText("" + number);
    }

    /**
     * This method displays the given player B set value on the screen.
     */
    private void displaySetB(int number) {
        TextView setBTextView = (TextView) findViewById(
                R.id.playerB_set_text_view);
        setBTextView.setText("" + number);
    }

    /**
     * reset score,winner name, buttons .

    public void reset(View view) {
        scoreA = 0;
        scoreB = 0;
        displayA(scoreA);
        displayB(scoreB);
        enButton();
    }
    */
    /**
     * start next set
     */
    public void nextSet(View view) {
        scoreA = 0;
        scoreB = 0;
        displayA(scoreA);
        displayB(scoreB);
        enButton();
    }

    /**
     * start match summary
     */
    public void matchSummary(View view) {

        Intent matchSummary = new Intent(this, com.example.android.badmintonscoreboard.DoubleMatchSummary.class);
        matchSummary.putExtra("result_list",result);
        matchSummary.putExtra("playerA1", playerA1Name);
        matchSummary.putExtra("playerB1", playerB1Name);
        matchSummary.putExtra("playerA2", playerA2Name);
        matchSummary.putExtra("playerB2", playerB2Name);
        startActivity(matchSummary);
    }
    /**
    * start over from beginning
     */
    public void startOver(View view) {
        chronometer.stop();
        Intent startOver = new Intent(this, com.example.android.badmintonscoreboard.MainActivity.class);

        startActivity(startOver);
    }

    /**
     * This method disables score buttons. When set is finished, no additional score can be added.
     */
    private void disButton() {
        addA = (Button) findViewById(R.id.button_add_A);
        addA.setEnabled(false);
        addB = (Button) findViewById(R.id.button_add_B);
        addB.setEnabled(false);
        deductA= (Button) findViewById(R.id.button_deduct_A);
        deductA.setEnabled(false);
        deductB = (Button) findViewById(R.id.button_deduct_B);
        deductB.setEnabled(false);
    }


    /**
     * This method disables score buttons and next button. When game is finished, no additional score can be added.
     */
    private void disButtonGame() {
        addA = (Button) findViewById(R.id.button_add_A);
        addA.setEnabled(false);
        addB = (Button) findViewById(R.id.button_add_B);
        addB.setEnabled(false);
        next = (Button) findViewById(R.id.next_button);
        next.setEnabled(false);
        deductA= (Button) findViewById(R.id.button_deduct_A);
        deductA.setEnabled(false);
        deductB = (Button) findViewById(R.id.button_deduct_B);
        deductB.setEnabled(false);
    }

    /**
     * This method enables score buttons back. When new set starts
     */
    private void enButton() {
        addA = (Button) findViewById(R.id.button_add_A);
        addA.setEnabled(true);
        addB = (Button) findViewById(R.id.button_add_B);
        addB.setEnabled(true);
        deductA =(Button) findViewById(R.id.button_deduct_A);
        deductA.setEnabled(true);
        deductB = (Button) findViewById(R.id.button_deduct_B);
        deductB.setEnabled(true);
    }
}







