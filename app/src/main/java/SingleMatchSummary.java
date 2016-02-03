package com.example.android.badmintonscoreboard;

/**
 * Created by xiao on 16/11/2015.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by xiao on 16/11/2015.
 */
public class SingleMatchSummary extends AppCompatActivity {
    String playerAName;
    String playerBName;
    TextView playerAView;
    TextView playerBView;
    private Toolbar mToolbar;
    private ArrayList<String> result = new ArrayList<String>();

    private ArrayAdapter<String> resultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_match_summary);

        mToolbar = (Toolbar) findViewById(R.id.match_header);
        setSupportActionBar(mToolbar);

        /**
         * This method displays the fetched player A name value on the screen.
         */

        playerAView = (TextView) findViewById(R.id.playerA_name_text_view);
        playerBView = (TextView) findViewById(R.id.playerB_name_text_view);


        Intent matchSummary = getIntent();
        playerAName = matchSummary.getStringExtra("playerA");
        playerBName = matchSummary.getStringExtra("playerB");

        playerAView.setText(playerAName);
        playerBView.setText(playerBName);


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

        Intent startOver = new Intent(this, com.example.android.badmintonscoreboard.MainActivity.class);

        startActivity(startOver);
    }
}
