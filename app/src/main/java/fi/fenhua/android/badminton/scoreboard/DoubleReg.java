package fi.fenhua.android.badminton.scoreboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


/**
 * Created by xiao on 26/06/2015.
 */
public class DoubleReg extends AppCompatActivity {

    EditText playerA1Name;
    EditText playerA2Name;
    EditText playerB1Name;
    EditText playerB2Name;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.double_reg);
        playerA1Name = (EditText) findViewById(R.id.nameA1);
        playerA2Name = (EditText) findViewById(R.id.nameA2);
        playerB1Name = (EditText) findViewById(R.id.nameB1);
        playerB2Name = (EditText) findViewById(R.id.nameB2);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    public void singleRegister(View view) {
        Intent singleRegisterForm = new Intent(this, SingleReg.class);

        startActivity(singleRegisterForm);
    }

    public void startDouble(View view) {
        Intent startDoubleGame = new Intent(this, DoubleScore.class);
        startDoubleGame.putExtra("playerA1", playerA1Name.getText().toString());
        startDoubleGame.putExtra("playerB1", playerB1Name.getText().toString());
        startDoubleGame.putExtra("playerA2", playerA2Name.getText().toString());
        startDoubleGame.putExtra("playerB2", playerB2Name.getText().toString());
        startActivity(startDoubleGame);
    }
}
