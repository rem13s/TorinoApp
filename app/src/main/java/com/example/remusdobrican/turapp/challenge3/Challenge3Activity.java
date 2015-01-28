package com.example.remusdobrican.turapp.challenge3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.remusdobrican.turapp.R;
import com.example.remusdobrican.turapp.Singleton;


public class Challenge3Activity extends ActionBarActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge3);

        addListenerOnButton1();
        addListenerOnButton2();
        addListenerOnButton3();
        addListenerOnButton4();
    }

    private void addListenerOnButton1() {
        final Context context = this;
        button = (Button)findViewById(R.id.answerA);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BadAnswerActivity3.class);
                startActivity(intent);
            }
        });
    }

    private void addListenerOnButton2() {
        final Context context = this;
        button = (Button)findViewById(R.id.answerB);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char winning = Singleton.INSTANCE.getRandomLetter();
                Intent intent;
                intent = new Intent(context, GoodAnswerActivity3.class);
                intent.putExtra("letter", winning);
                startActivity(intent);
            }
        });
    }

    private void addListenerOnButton3() {
        final Context context = this;
        button = (Button)findViewById(R.id.answerC);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BadAnswerActivity3.class);
                startActivity(intent);
            }
        });
    }

    private void addListenerOnButton4() {

        final Context context = this;
        button = (Button)findViewById(R.id.answerD);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BadAnswerActivity3.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_challenge3, menu);
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
