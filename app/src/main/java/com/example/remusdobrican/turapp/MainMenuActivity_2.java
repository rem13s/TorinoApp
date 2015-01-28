package com.example.remusdobrican.turapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainMenuActivity_2 extends ActionBarActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_activity_2);
        addListenerOnButton1();
        addListenerOnButton2();
        addListenerOnButton3();
        addListenerOnButton4();

    }

    private void addListenerOnButton1() {
        final Context context = this;
        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WarningStartActivity_3.class);
                startActivity(intent);
            }
        });
    }

    private void addListenerOnButton2() {
        final Context context = this;
        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // the wiki app will open only if it is installed
                // otherwise it will take the user to the play store to download it from there
                try {
                    Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.duxgames.snake");
                    startActivity(LaunchIntent);
                }
                catch (NullPointerException e){

                    // 1. Instantiate an AlertDialog.Builder with its constructor
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainMenuActivity_2.this);

                    // 2. Chain together various setter methods to set the dialog characteristics
                    builder.setMessage(R.string.game_dialog_box)
                            .setTitle(R.string.game_missing_app);

                    // Add the buttons
                    // this button sends you to download the wiki app in case you don't have it
                    builder.setPositiveButton(R.string.ok_wiki_button, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked OK button
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.duxgames.snake")));
                        }
                    });

                    // this button cancels the request to download the wiki app
                    builder.setNegativeButton(R.string.cancel_wiki_button, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });


                    // 3. Get the AlertDialog from create()
                    AlertDialog dialog = builder.create();

                    dialog.show();
                }
            }
        });
    }

    private void addListenerOnButton3() {
        final Context context = this;
        button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri webpage = Uri.parse("http://en.wikipedia.org/wiki/Turin");
                intent.setData(webpage);
                intent.setPackage("org.wikipedia");

                // the wiki app will open only if it is installed
                // otherwise it will take the user to the play store to download it from there
                try {
                    startActivity(intent);
                }
                catch (android.content.ActivityNotFoundException e){

                    Log.d("exception", "i am in catch 1" + MainMenuActivity_2.this);

                    // 1. Instantiate an AlertDialog.Builder with its constructor
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainMenuActivity_2.this);

                    // 2. Chain together various setter methods to set the dialog characteristics
                    builder.setMessage(R.string.dialog_fire_missiles)
                            .setTitle(R.string.wiki_missing_app);

                    // Add the buttons
                    // this button sends you to download the wiki app in case you don't have it
                    builder.setPositiveButton(R.string.ok_wiki_button, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked OK button
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=org.wikipedia")));
                        }
                    });

                    // this button cancels the request to download the wiki app
                    builder.setNegativeButton(R.string.cancel_wiki_button, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });


                    // 3. Get the AlertDialog from create()
                    AlertDialog dialog = builder.create();

                    dialog.show();

                    Log.d("exception","i am in catch 2");
                }

            }
        });
    }

    private void addListenerOnButton4() {
        final Context context = this;
        button = (Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AboutAppActivity_4.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu_activity_2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
