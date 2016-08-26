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

/**
 * Created by xiao on 24/06/2015.
 */
public class SingleScorePro extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    int maxScore = 30;
    int nomScore = 21;
    TextView playerAView;
    TextView playerBView;
    TextView winnerATextView;
    TextView winnerBTextView;
    Button smashA;
    Button netA;
    Button clearA;
    Button oppoA;
    Button smashB;
    Button netB;
    Button clearB;
    Button oppoB;
    int winnerB = 0;
    int winnerA = 0; // player A's winning sets
    String playerAName;
    String playerBName;
    Button next;
    Chronometer chronometer;
    int smashWinA = 0;
    int smashWinB = 0;
    int smashSetWinA1 = 0;
    int smashSetWinA2 = 0;
    int smashSetWinA3 = 0;
    int smashSetWinB1 = 0;
    int smashSetWinB2 = 0;
    int smashSetWinB3 = 0;
    int netWinA = 0;
    int netWinB = 0;
    int netSetWinA1 = 0;
    int netSetWinA2 = 0;
    int netSetWinA3 = 0;
    int netSetWinB1 = 0;
    int netSetWinB2 = 0;
    int netSetWinB3 = 0;
    int clearWinA = 0;
    int clearWinB = 0;
    int clearSetWinA1 = 0;
    int clearSetWinA2 = 0;
    int clearSetWinA3 = 0;
    int clearSetWinB1 = 0;
    int clearSetWinB2 = 0;
    int clearSetWinB3 = 0;
    int oppoWinA = 0;
    int oppoWinB = 0;
    int oppoSetWinA1 = 0;
    int oppoSetWinA2 = 0;
    int oppoSetWinA3 = 0;
    int oppoSetWinB1 = 0;
    int oppoSetWinB2 = 0;
    int oppoSetWinB3 = 0;
    int gameSet = 0;

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

        //next = (Button) findViewById(R.id.single_next_button);
        //next.setEnabled(false);
    }


    /**
     * This method stores smash statistics value for both players.
     */
    public void smashA(View view) {
        gameSet = winnerA + winnerB;
        scoreA();
        switch (gameSet) {
            case 0:
                smashSetWinA1 = smashSetWinA1 + 1;
                break;
            case 1:
                smashSetWinA2 = smashSetWinA2 + 1;
                break;
            case 2:
                smashSetWinA3 = smashSetWinA3 + 1;
                break;
            default:
        }
    }

    public void smashB(View view) {
        gameSet = winnerA + winnerB;
        scoreB();

        switch (gameSet) {
            case 0:
                smashSetWinB1 = smashSetWinB1 + 1;
                break;
            case 1:
                smashSetWinB2 = smashSetWinB2 + 1;
                break;
            case 2:
                smashSetWinB3 = smashSetWinB3 + 1;
                break;
            default:
        }
    }

    /**
     * This method stores net statistics value for both players.
     */
    public void netA(View view) {
        gameSet = winnerA + winnerB;
        scoreA();
        switch (gameSet) {
            case 0:
                netSetWinA1 = netSetWinA1 + 1;
                break;
            case 1:
                netSetWinA2 = netSetWinA2 + 1;
                break;
            case 2:
                netSetWinA3 = netSetWinA3 + 1;
                break;
            default:
        }
    }

    public void netB(View view) {
        gameSet = winnerA + winnerB;
        scoreB();
        switch (gameSet) {
            case 0:
                netSetWinB1 = netSetWinB1 + 1;
                break;
            case 1:
                netSetWinB2 = netSetWinB2 + 1;
                break;
            case 2:
                netSetWinB3 = netSetWinB3 + 1;
                break;
            default:
        }
    }

    /**
     * This method stores Clear statistics value for both players.
     */
    public void clearA(View view) {
        gameSet = winnerA + winnerB;
        scoreA();
        switch (gameSet) {
            case 0:
                clearSetWinA1 = clearSetWinA1 + 1;
                break;
            case 1:
                clearSetWinA2 = clearSetWinA2 + 1;
                break;
            case 2:
                clearSetWinA3 = clearSetWinA3 + 1;
                break;
            default:
        }
    }

    public void clearB(View view) {
        gameSet = winnerA + winnerB;
        scoreB();
        switch (gameSet) {
            case 0:
                clearSetWinB1 = clearSetWinB1 + 1;
                break;
            case 1:
                clearSetWinB2 = clearSetWinB2 + 1;
                break;
            case 2:
                clearSetWinB3 = clearSetWinB3 + 1;
                break;
            default:
        }
    }

    /**
     * This method stores opponets' unforced error statistics value for both players.
     */
    public void oppoA(View view) {
        gameSet = winnerA + winnerB;
        scoreA();
        switch (gameSet) {
            case 0:
                oppoSetWinA1 = oppoSetWinA1 + 1;
                break;
            case 1:
                oppoSetWinA2 = oppoSetWinA2 + 1;
                break;
            case 2:
                oppoSetWinA3 = oppoSetWinA3 + 1;
                break;
            default:
        }
    }

    public void oppoB(View view) {
        gameSet = winnerA + winnerB;
        scoreB();
        switch (gameSet) {
            case 0:
                oppoSetWinB1 = oppoSetWinB1 + 1;
                break;
            case 1:
                oppoSetWinB2 = oppoSetWinB2 + 1;
                break;
            case 2:
                oppoSetWinB3 = oppoSetWinB3 + 1;
                break;
            default:
        }
    }

    /**
     * This method calculates player A's score..
     */
    public void scoreA() {
        scoreA = scoreA + 1;
        displayA(scoreA);
        // show winner name when score is 30
        if (scoreA == maxScore) {
            winnerA = winnerA + 1;
            displaySetA(winnerA);
            if (winnerA == 2) {
                gameWinnerA();
                disButton();
                chronometer.stop();

            } else {
                //stops score when reaches 30 by disable buttons
                disButton();
                //show winner name when score is 21 or higher but less than 30
            }
        } else if (scoreA >= nomScore && scoreA - scoreB >= 2) {
            winnerA = winnerA + 1;
            displaySetA(winnerA);
            if (winnerA == 2) {
                gameWinnerA();
                disButtonGame();
                chronometer.stop();
            } else {
                disButton();
            }

        }

    }

    /**
     * This method calculates player B's score.
     */
    public void scoreB() {
        scoreB = scoreB + 1;
        displayB(scoreB);
        // show winner name when score is 30
        if (scoreB == maxScore) {
            winnerB = winnerB + 1;
            displaySetB(winnerB);
            if (winnerB == 2) {
                gameWinnerB();
                disButton();
                chronometer.stop();
            } else {
                disButton();
            }
            //stops score when reaches 30 by disable buttons
            disButton();
            //show winner name when score is 21 or higher but less than 30
        } else if (scoreB >= nomScore && scoreB - scoreA >= 2) {
            winnerB = winnerB + 1;
            displaySetB(winnerB);
            if (winnerB == 2) {
                gameWinnerB();
                disButtonGame();
                chronometer.stop();
            } else {
                disButton();
            }
        }

    }

    /**
     * This method displays game winner A name and set score value on the screen.
     */
    private void gameWinnerA() {
        winnerATextView = (TextView) findViewById(R.id.winner_name_text_view);
        Intent startSingleGame = getIntent();
        playerAName = startSingleGame.getStringExtra("playerA");
        winnerATextView.setText(winnerA + " : " + winnerB + "   " + playerAName + " wins this game");
        next = (Button) findViewById(R.id.single_next_button);
        next.setEnabled(false);
    }

    /**
     * This method displays game winner B name and set score value on the screen.
     */
    private void gameWinnerB() {
        winnerBTextView = (TextView) findViewById(R.id.winner_name_text_view);
        Intent startSingleGame = getIntent();
        playerBName = startSingleGame.getStringExtra("playerB");
        winnerBTextView.setText(winnerB + " : " + winnerA + "   " + playerBName + " wins this game");
        next = (Button) findViewById(R.id.single_next_button);
        next.setEnabled(false);
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
     */
    public void reset(View view) {
        scoreA = 0;
        scoreB = 0;
        displayA(scoreA);
        displayB(scoreB);
        enButton();
    }

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
     * start over from beginning
     */
    public void startOver(View view) {
        chronometer.stop();
        Intent startOver = new Intent(this, MainActivity.class);

        startActivity(startOver);
    }

    /**
     * Veiw game statistics
     */
    public void statistics(View view) {
        Intent statistics = new Intent(this, Statistics.class);
        statistics.putExtra("playerA", playerAName);
        statistics.putExtra("playerB", playerBName);

        statistics.putExtra("smashSetA1", smashSetWinA1);
        statistics.putExtra("smashSetA2", smashSetWinA2);
        statistics.putExtra("smashSetA3", smashSetWinA3);
        statistics.putExtra("smashSetB1", smashSetWinB1);
        statistics.putExtra("smashSetB2", smashSetWinB2);
        statistics.putExtra("smashSetB3", smashSetWinB3);

        statistics.putExtra("netSetA1", netSetWinA1);
        statistics.putExtra("netSetA2", netSetWinA2);
        statistics.putExtra("netSetA3", netSetWinA3);
        statistics.putExtra("netSetB1", netSetWinB1);
        statistics.putExtra("netSetB2", netSetWinB2);
        statistics.putExtra("netSetB3", netSetWinB3);

        statistics.putExtra("clearSetA1", clearSetWinA1);
        statistics.putExtra("clearSetA2", clearSetWinA2);
        statistics.putExtra("clearSetA3", clearSetWinA3);
        statistics.putExtra("clearSetB1", clearSetWinB1);
        statistics.putExtra("clearSetB2", clearSetWinB2);
        statistics.putExtra("clearSetB3", clearSetWinB3);

        statistics.putExtra("oppoSetA1", oppoSetWinA1);
        statistics.putExtra("oppoSetA2", oppoSetWinA2);
        statistics.putExtra("oppoSetA3", oppoSetWinA3);
        statistics.putExtra("oppoSetB1", oppoSetWinB1);
        statistics.putExtra("oppoSetB2", oppoSetWinB2);
        statistics.putExtra("oppoSetB3", oppoSetWinB3);

        startActivity(statistics);
    }

    /**
     * This method disables score buttons. When set is finished, no additional score can be added.
     */
    private void disButton() {
        smashA = (Button) findViewById(R.id.button_smash_A);
        smashA.setEnabled(false);
        smashB = (Button) findViewById(R.id.button_smash_B);
        smashB.setEnabled(false);
        netA = (Button) findViewById(R.id.button_net_A);
        netA.setEnabled(false);
        netB = (Button) findViewById(R.id.button_net_B);
        netB.setEnabled(false);
        clearA = (Button) findViewById(R.id.button_clear_A);
        clearA.setEnabled(false);
        clearB = (Button) findViewById(R.id.button_clear_B);
        clearB.setEnabled(false);
        oppoA = (Button) findViewById(R.id.button_opponent_A);
        oppoA.setEnabled(false);
        oppoB = (Button) findViewById(R.id.button_opponent_B);
        oppoB.setEnabled(false);
    }

    /**
     * This method disables score buttons and next button. When game is finished, no additional score can be added.
     */
    private void disButtonGame() {
        smashA = (Button) findViewById(R.id.button_smash_A);
        smashA.setEnabled(false);
        smashB = (Button) findViewById(R.id.button_smash_B);
        smashB.setEnabled(false);
        netA = (Button) findViewById(R.id.button_net_A);
        netA.setEnabled(false);
        netB = (Button) findViewById(R.id.button_net_B);
        netB.setEnabled(false);
        clearA = (Button) findViewById(R.id.button_clear_A);
        clearA.setEnabled(false);
        clearB = (Button) findViewById(R.id.button_clear_B);
        clearB.setEnabled(false);
        oppoA = (Button) findViewById(R.id.button_opponent_A);
        oppoA.setEnabled(false);
        oppoB = (Button) findViewById(R.id.button_opponent_B);
        oppoB.setEnabled(false);
        next = (Button) findViewById(R.id.single_next_button);
        next.setEnabled(false);
    }

    /**
     * This method enables score buttons back. When new set starts
     */
    private void enButton() {
        smashA = (Button) findViewById(R.id.button_smash_A);
        smashA.setEnabled(true);
        smashB = (Button) findViewById(R.id.button_smash_B);
        smashB.setEnabled(true);
        netA = (Button) findViewById(R.id.button_net_A);
        netA.setEnabled(true);
        netB = (Button) findViewById(R.id.button_net_B);
        netB.setEnabled(true);
        clearA = (Button) findViewById(R.id.button_clear_A);
        clearA.setEnabled(true);
        clearB = (Button) findViewById(R.id.button_clear_B);
        clearB.setEnabled(true);
        oppoA = (Button) findViewById(R.id.button_opponent_A);
        oppoA.setEnabled(true);
        oppoB = (Button) findViewById(R.id.button_opponent_B);
        oppoB.setEnabled(true);
    }
}

