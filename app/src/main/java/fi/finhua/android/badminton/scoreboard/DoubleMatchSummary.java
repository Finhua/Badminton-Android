package fi.finhua.android.badminton.scoreboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by xiao on 17/11/2015.
 */
public class DoubleMatchSummary extends AppCompatActivity {
    String playerA1Name;
    String playerA2Name;
    String playerB1Name;
    String playerB2Name;
    TextView playerA1View;
    TextView playerA2View;
    TextView playerB1View;
    TextView playerB2View;

    private Toolbar mToolbar;
    private ArrayList<String> result = new ArrayList<String>();

    private ArrayAdapter<String> resultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.double_match_summary);

        mToolbar = (Toolbar) findViewById(R.id.match_header);
        setSupportActionBar(mToolbar);

        /**
         * This method displays the fetched player A name value on the screen.
         */

        playerA1View = (TextView) findViewById(R.id.playerA1_name_text_view);
        playerB1View = (TextView) findViewById(R.id.playerB1_name_text_view);
        playerA2View = (TextView) findViewById(R.id.playerA2_name_text_view);
        playerB2View = (TextView) findViewById(R.id.playerB2_name_text_view);

        Intent matchSummary = getIntent();
        playerA1Name = matchSummary.getStringExtra("playerA1");
        playerB1Name = matchSummary.getStringExtra("playerB1");
        playerA2Name = matchSummary.getStringExtra("playerA2");
        playerB2Name = matchSummary.getStringExtra("playerB2");

        playerA1View.setText(playerA1Name);
        playerB1View.setText(playerB1Name);
        playerA2View.setText(playerA2Name);
        playerB2View.setText(playerB2Name);

        result = matchSummary.getStringArrayListExtra("result_list");
        resultAdapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_summary,
                R.id.result_item_list_textview,
                result);
        ListView resultListView = (ListView) findViewById(R.id.result_item_list);
        resultListView.setAdapter(resultAdapter);

    }
    /**
     * start over from beginning when Ok button is clicked
     */
    public void startOver(View view) {

        Intent startOver = new Intent(this, MainActivity.class);

        startActivity(startOver);
    }
}
