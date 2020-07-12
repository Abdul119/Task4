  package com.example.abdulali.careerkey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListeningActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         Button carrier = (Button) findViewById(R.id.carrier1);
        carrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CareerActivity.class));
            }
        });


        context = getApplicationContext(); // Needs to be set
        VoiceRecognitionListener.getInstance().setListener(MainActivity.this); // Here we set the current listener
        startListening(); // starts listening


    }

    @Override
    public void processVoiceCommands(String... voiceCommands) {
        String command= voiceCommands[0];
        TextView v = new TextView(getApplicationContext());
        v.setText(command); Toast.makeText(getApplicationContext(),command,Toast.LENGTH_SHORT).show();
        if(command.contains("I am blind")||command.contains("i am blind")){
            Toast.makeText(getApplicationContext(),command,Toast.LENGTH_SHORT).show();
          startActivity(new Intent(getApplicationContext(),BlindActivity.class));
        }else if(command.contains("I'm a blind")){
          startActivity(new Intent(getApplicationContext(),CareerActivity.class));
        }
        else {

        }
        restartListeningService();
    }
}
