package com.example.remusdobrican.turapp.challenge3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.remusdobrican.turapp.MapActivity_5;
import com.example.remusdobrican.turapp.R;

public class GoodAnswerActivity3 extends ActionBarActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_answer_challenge3);
        addListenerOnButton1(); // nextStop button
    }

    // nextStop -> MapActivity_5
    private void addListenerOnButton1() {
        final Context context = this;
        button = (Button)findViewById(R.id.buttonnextstop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MapActivity_5.class);
                int Stage = 3;
                intent.putExtra("stage",Stage);
                System.out.println("Stage value from good3 is = " + intent.getIntExtra("stage", 95));
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_good_answer_challenge3, menu);
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
