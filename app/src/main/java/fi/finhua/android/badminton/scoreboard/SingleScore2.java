package fi.finhua.android.badminton.scoreboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by xiao on 26/06/2015.
 */
public class SingleScore2 extends Activity {

    int scoreA = 0;
    int scoreB = 0;
    int maxScore = 30;
    int nomScore = 21;
    TextView playerAView;
    TextView playerBView;
    TextView set2AView;
    TextView set2BView;
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
    String playerAName;
    String playerBName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_score_2);
        /**
         * This method displays the fetched set value on the screen.
         */

        /**set2AView = (TextView) findViewById(R.id.playerA_set_text_view);
         set2BView = (TextView) findViewById(R.id.playerB_set_text_view);

         Intent singleNext = getIntent();
         int set2A = singleNext.getIntExtra("winA1", 0);
         int set2B = singleNext.getIntExtra("winB1",0);

         set2AView.setText(set2A);
         set2BView.setText(set2B);

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
     * This method is called when the score A button is clicked.
     */
    public void scoreA(View view) {
        scoreA = scoreA + 1;
        displayA(scoreA);
        // show winner name when score is 30
        if (scoreA == maxScore) {
            winnerATextView = (TextView) findViewById(R.id.winner_name_text_view);
            Intent startSingleGame = getIntent();
            String playerAName = startSingleGame.getStringExtra("playerA");
            winnerATextView.setText(playerAName + " wins this set");

            //stops score when reaches 30 by disable buttons
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


            //show winner name when score is 21 or higher but less than 30
        } else if (scoreA >= nomScore && scoreA - scoreB >= 2) {
            winnerATextView = (TextView) findViewById(R.id.winner_name_text_view);
            Intent startSingleGame = getIntent();
            String playerAName = startSingleGame.getStringExtra("playerA");
            winnerATextView.setText(playerAName + " wins this set");

            //stops score when reaches 21 but less than 30 by disable buttons
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

    }

    /**
     * This method is called when the score B button is clicked.
     */
    public void scoreB(View view) {
        scoreB = scoreB + 1;
        displayB(scoreB);
        // show winner name when score is 30
        if (scoreB == maxScore) {
            winnerBTextView = (TextView) findViewById(R.id.winner_name_text_view);
            Intent startSingleGame = getIntent();
            String playerBName = startSingleGame.getStringExtra("playerB");
            winnerBTextView.setText(playerBName + " wins this set");
            //stops score when reaches 30 by disable buttons
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
            //show winner name when score is 21 or higher but less than 30
        } else if (scoreB >= nomScore && scoreB - scoreA >= 2) {
            winnerBTextView = (TextView) findViewById(R.id.winner_name_text_view);
            Intent startSingleGame = getIntent();
            String playerBName = startSingleGame.getStringExtra("playerB");
            winnerBTextView.setText(playerBName + " wins this set");

            //stops score when reaches 21 but less than 30 by disable buttons
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
     * reset score,winner name, buttons .
     */
    public void reset(View view) {
        scoreA = 0;
        scoreB = 0;
        displayA(scoreA);
        displayB(scoreB);
        winnerATextView = (TextView) findViewById(R.id.winner_name_text_view);
        winnerATextView.setVisibility(View.GONE);
        winnerBTextView = (TextView) findViewById(R.id.winner_name_text_view);
        winnerBTextView.setVisibility(View.GONE);
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

    public void nextSet(View view) {
        Intent singleNext = new Intent(this, SingleScore3.class);
        singleNext.putExtra("playerA", playerAName);
        singleNext.putExtra("playerB", playerBName);
        startActivity(singleNext);
    }

    public void startOver(View view) {
        Intent startOver = new Intent(this, MainActivity.class);

        startActivity(startOver);
    }
}