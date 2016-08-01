package in.app.myandroid.mygatepassmanagement.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import in.app.myandroid.mygatepassmanagement.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GatePassManagement extends AppCompatActivity {

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        context = this;

        Thread backgroundThread = new Thread() {
            public void run() {
                try {
                    sleep(0 * 1000);
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {

                }
            }

        };

        backgroundThread.start();

    }
}
