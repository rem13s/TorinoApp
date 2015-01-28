package com.example.remusdobrican.turapp.challenge1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.remusdobrican.turapp.R;
import com.example.remusdobrican.turapp.MapActivity_5;
import com.example.remusdobrican.turapp.challenge2.Challenge2Activity;

public class GoodAnswerActivity extends ActionBarActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_answer_challenge1);

        textView = (TextView)findViewById(R.id.textViewLetter);
        char getResult = getIntent().getCharExtra("letter", 'a');
        textView.setText("You won letter: " + getResult);

        addListenerOnButton1(); // nextChallenge button
        addListenerOnButton2(); // returnToMap button
    }

    // nextChallenge listener
    private void addListenerOnButton1() {
        final Context context = this;
        button = (Button)findViewById(R.id.buttonretmap);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Challenge2Activity.class);
                startActivity(intent);
            }
        });
    }

    // returnToMap listener
    private void addListenerOnButton2() {
        final Context context = this;
        button = (Button)findViewById(R.id.buttonnextchallenge);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MapActivity_5.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_good_answer_challenge1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
