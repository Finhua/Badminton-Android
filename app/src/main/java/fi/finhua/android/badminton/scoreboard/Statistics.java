package fi.finhua.android.badminton.scoreboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



/**
 * Created by xiao on 06/07/2015.
 */
public class Statistics extends Activity {
    TextView smashSetA1View;
    TextView smashSetA2View;
    TextView smashSetA3View;
    TextView smashSetB1View;
    TextView smashSetB2View;
    TextView smashSetB3View;
    TextView netSetA1View;
    TextView netSetA2View;
    TextView netSetA3View;
    TextView netSetB1View;
    TextView netSetB2View;
    TextView netSetB3View;
    TextView clearSetA1View;
    TextView clearSetA2View;
    TextView clearSetA3View;
    TextView clearSetB1View;
    TextView clearSetB2View;
    TextView clearSetB3View;
    TextView oppoSetA1View;
    TextView oppoSetA2View;
    TextView oppoSetA3View;
    TextView oppoSetB1View;
    TextView oppoSetB2View;
    TextView oppoSetB3View;
    TextView playerAView;
    TextView playerBView;
    String playerAName;
    String playerBName;
    int setSmashA1;
    int setSmashA2;
    int setSmashA3;
    int setSmashB1;
    int setSmashB2;
    int setSmashB3;
    int setNetA1;
    int setNetA2;
    int setNetA3;
    int setNetB1;
    int setNetB2;
    int setNetB3;
    int setClearA1;
    int setClearA2;
    int setClearA3;
    int setClearB1;
    int setClearB2;
    int setClearB3;
    int setOppoA1;
    int setOppoA2;
    int setOppoA3;
    int setOppoB1;
    int setOppoB2;
    int setOppoB3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);

        /**
         * This method displays the fetched player A name value on the screen.
         */

        playerAView = (TextView) findViewById(R.id.playerA_name_text_view);
        playerBView = (TextView) findViewById(R.id.playerB_name_text_view);

        Intent pNames = getIntent();
        playerAName = pNames.getStringExtra("playerA");
        playerBName = pNames.getStringExtra("playerB");

        playerAView.setText(playerAName);
        playerBView.setText(playerBName);


        smashSetA1View = (TextView) findViewById(R.id.stat_setA1_smash);
        smashSetA2View = (TextView) findViewById(R.id.stat_setA2_smash);
        smashSetA3View = (TextView) findViewById(R.id.stat_setA3_smash);
        smashSetB1View = (TextView) findViewById(R.id.stat_setB1_smash);
        smashSetB2View = (TextView) findViewById(R.id.stat_setB2_smash);
        smashSetB3View = (TextView) findViewById(R.id.stat_setB3_smash);

        netSetA1View = (TextView) findViewById(R.id.stat_setA1_net);
        netSetA2View = (TextView) findViewById(R.id.stat_setA2_net);
        netSetA3View = (TextView) findViewById(R.id.stat_setA3_net);
        netSetB1View = (TextView) findViewById(R.id.stat_setB1_net);
        netSetB2View = (TextView) findViewById(R.id.stat_setB2_net);
        netSetB3View = (TextView) findViewById(R.id.stat_setB3_net);

        clearSetA1View = (TextView) findViewById(R.id.stat_setA1_clear);
        clearSetA2View = (TextView) findViewById(R.id.stat_setA2_clear);
        clearSetA3View = (TextView) findViewById(R.id.stat_setA3_clear);
        clearSetB1View = (TextView) findViewById(R.id.stat_setB1_clear);
        clearSetB2View = (TextView) findViewById(R.id.stat_setB2_clear);
        clearSetB3View = (TextView) findViewById(R.id.stat_setB3_clear);

        oppoSetA1View = (TextView) findViewById(R.id.stat_setA1_oppo);
        oppoSetA2View = (TextView) findViewById(R.id.stat_setA2_oppo);
        oppoSetA3View = (TextView) findViewById(R.id.stat_setA3_oppo);
        oppoSetB1View = (TextView) findViewById(R.id.stat_setB1_oppo);
        oppoSetB2View = (TextView) findViewById(R.id.stat_setB2_oppo);
        oppoSetB3View = (TextView) findViewById(R.id.stat_setB3_oppo);

        Intent statSets = getIntent();
        /**
         * This method fetches player A win by smash statistics.
         */
        setSmashA1 = statSets.getIntExtra("smashSetA1", 0);
        setSmashA2 = statSets.getIntExtra("smashSetA2", 0);
        setSmashA3 = statSets.getIntExtra("smashSetA3", 0);
        smashSetA1View.setText("" + setSmashA1);
        smashSetA2View.setText("" + setSmashA2);
        smashSetA3View.setText("" + setSmashA3);
        setSmashB1 = statSets.getIntExtra("smashSetB1", 0);
        setSmashB2 = statSets.getIntExtra("smashSetB2", 0);
        setSmashB3 = statSets.getIntExtra("smashSetB3", 0);
        smashSetB1View.setText("" + setSmashB1);
        smashSetB2View.setText("" + setSmashB2);
        smashSetB3View.setText("" + setSmashB3);
        /**
         * This method fetches player A win by net statistics.
         */

        setNetA1 = statSets.getIntExtra("netSetA1", 0);
        setNetA2 = statSets.getIntExtra("netSetA2", 0);
        setNetA3 = statSets.getIntExtra("netSetA3", 0);
        netSetA1View.setText("" + setNetA1);
        netSetA2View.setText("" + setNetA2);
        netSetA3View.setText("" + setNetA3);

        setNetB1 = statSets.getIntExtra("netSetB1", 0);
        setNetB2 = statSets.getIntExtra("netSetB2", 0);
        setNetB3 = statSets.getIntExtra("netSetB3", 0);
        netSetB1View.setText("" + setNetB1);
        netSetB2View.setText("" + setNetB2);
        netSetB3View.setText("" + setNetB3);
        /**
         * This method fetches player A win by clear statistics.
         */

        setClearA1 = statSets.getIntExtra("clearSetA1", 0);
        setClearA2 = statSets.getIntExtra("clearSetA2", 0);
        setClearA3 = statSets.getIntExtra("clearSetA3", 0);
        clearSetA1View.setText("" + setClearA1);
        clearSetA2View.setText("" + setClearA2);
        clearSetA3View.setText("" + setClearA3);

        setClearB1 = statSets.getIntExtra("clearSetB1", 0);
        setClearB2 = statSets.getIntExtra("clearSetB2", 0);
        setClearB3 = statSets.getIntExtra("clearSetB3", 0);
        clearSetB1View.setText("" + setClearB1);
        clearSetB2View.setText("" + setClearB2);
        clearSetB3View.setText("" + setClearB3);

        /**
         * This method fetches player A win by clear statistics.
         */

        setOppoA1 = statSets.getIntExtra("oppoSetA1", 0);
        setOppoA2 = statSets.getIntExtra("oppoSetA2", 0);
        setOppoA3 = statSets.getIntExtra("oppoSetA3", 0);
        oppoSetA1View.setText("" + setOppoA1);
        oppoSetA2View.setText("" + setOppoA2);
        oppoSetA3View.setText("" + setOppoA3);

        setOppoB1 = statSets.getIntExtra("oppoSetB1", 0);
        setOppoB2 = statSets.getIntExtra("oppoSetB2", 0);
        setOppoB3 = statSets.getIntExtra("oppoSetB3", 0);
        oppoSetB1View.setText("" + setOppoB1);
        oppoSetB2View.setText("" + setOppoB2);
        oppoSetB3View.setText("" + setOppoB3);
    }

    /**
     * start over from beginning
     */
    public void startOver(View view) {

        Intent startOver = new Intent(this, MainActivity.class);

        startActivity(startOver);
    }
}
