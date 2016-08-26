package fi.finhua.android.badminton.scoreboard;

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
 * Created by xiao on 24/06/2015.
 */
public class SingleScore extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    int maxScore = 15;
    int nomScore = 21;
    TextView playerAView;
    TextView playerBView;
    TextView winnerATextView;
    TextView winnerBTextView;
    Button addA;
    Button addB;
    Button deductA;
    Button deductB;
    Button  matchSummary;

    int winnerB = 0;
    int winnerA = 0; // player A's winning sets
    String playerAName;
    String playerBName;
    Button next;
    Chronometer chronometer;

    private ArrayList<String> result = new ArrayList<String>();
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_score);

        mToolbar = (Toolbar) findViewById(R.id.match_header);
        setSupportActionBar(mToolbar);


        /**
         * This method starts clock when the activity starts.
         */
        chronometer = (Chronometer) findViewById(R.id.clock);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();


        /**
         * This method displays the fetched player A name value on the screen.
         */

        playerAView = (TextView) findViewById(R.id.playerA_name_text_view);
        playerBView = (TextView) findViewById(R.id.playerB_name_text_view);

        Intent startSingleGame = getIntent();
        playerAName = startSingleGame.getStringExtra("playerA");
        playerBName = startSingleGame.getStringExtra("playerB");

        playerAView.setText(playerAName);
        playerBView.setText(playerBName);


    }


    /**
     * This method calculates player A's score..
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
     * This method calculates player B's score.
     */
    public void scoreB(View view) {
        scoreB = scoreB + 1;
        displayB(scoreB);
        // show winner name when score is 15
        if (scoreB == maxScore) {
            winnerB = winnerB + 1;
            displaySetB(winnerB);
            disButton();
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
        if (scoreA<0){
           Toast.makeText(SingleScore.this,"Score can't be less than zero",Toast.LENGTH_LONG).show();
            scoreA=0;
        }
        displayA(scoreA);
    }
    /**
     * This method deduct player B's score in case of wrong input.
     */
    public void deductB(View view) {
        scoreB = scoreB - 1;
        if (scoreB < 0) {
            Toast.makeText(SingleScore.this, "Score can't be less than zero", Toast.LENGTH_LONG).show();
            scoreB = 0;
        }
        displayB(scoreB);
    }
    /**
     * This method displays game winner A name and set score value on the screen.
     */
    private void gameWinnerA() {
        winnerATextView = (TextView) findViewById(R.id.winner_name_text_view);
        Intent startSingleGame = getIntent();
        playerAName = startSingleGame.getStringExtra("playerA");
        winnerATextView.setText(winnerA + " : " + winnerB + "   " + playerAName + " wins this game");

    }
    /**
     * This method displays game winner B name and set score value on the screen.
     */
    private void showMatchSummary (){
        next =(Button)findViewById(R.id.next_button);
        next.setVisibility(Button.GONE);
        matchSummary = (Button)findViewById(R.id.single_match_summary_button);
        matchSummary.setVisibility(Button.VISIBLE);
    }
    /**
     * This method displays game winner B name and set score value on the screen.
     */
    private void gameWinnerB() {
        winnerBTextView = (TextView) findViewById(R.id.winner_name_text_view);
        Intent startSingleGame = getIntent();
        playerBName = startSingleGame.getStringExtra("playerB");
        winnerBTextView.setText(winnerB + " : " + winnerA + "   " + playerBName + " wins this game");
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

        Intent matchSummary = new Intent(this, SingleMatchSummary.class);
        matchSummary.putExtra("result_list",result);
        matchSummary.putExtra("playerA", playerAName);
        matchSummary.putExtra("playerB", playerBName);
        startActivity(matchSummary);
    }
    /**
     * start over from beginning
     */
    public void startOver(View view) {
        chronometer.stop();
        Intent startOver = new Intent(this, MainActivity.class);

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
        deductA= (Button) findViewById(R.id.button_deduct_A);
        deductA.setEnabled(true);
        deductB = (Button) findViewById(R.id.button_deduct_B);
        deductB.setEnabled(true);
    }
}



