package com.example.abdulali.careerkey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.abdulali.careerkey.CareerActivity.int_Entreprising;
import static com.example.abdulali.careerkey.CareerActivity.int_artistic;
import static com.example.abdulali.careerkey.CareerActivity.int_investigative;
import static com.example.abdulali.careerkey.CareerActivity.int_realistic;
import static com.example.abdulali.careerkey.CareerActivity.int_social;
import static com.example.abdulali.careerkey.CareerActivity.int_conventional;

public class ResultActivity extends AppCompatActivity {

    private Social instanceS = new Social();
    private Artistic instanceA = new Artistic();
    private Investigative instanceI = new Investigative();
    private Conventional instanceC = new Conventional();
    private Realistic instanceR = new Realistic();
    private Enterprising instanceE = new Enterprising();



    private Button checkPersonality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        checkPersonalityClicklistener();


    }

    public void checkPersonalityClicklistener() {
        checkPersonality = (Button) findViewById(R.id.choice5);




        checkPersonality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // String  name  = instanceE.varEnterprising;
                findPersonality();
            }
        });
    }

    private void findPersonality() {
        if (int_artistic > int_conventional && int_artistic > int_investigative && int_artistic > int_realistic
                && int_artistic > int_Entreprising && int_artistic > int_social) {
            Toast.makeText(ResultActivity.this, "You are Artistic.Your educational fields are Actor,Designer,Drama,Poetry etc", Toast.LENGTH_SHORT).show();

        }
        if (int_conventional > int_investigative && int_conventional > int_realistic
                && int_conventional > int_Entreprising && int_conventional > int_social) {
            Toast.makeText(ResultActivity.this, "You are Conventional.Your educational fields are IT,Business,manager,computer etc", Toast.LENGTH_SHORT).show();
        }
        if (int_investigative > int_realistic
                && int_investigative > int_Entreprising && int_investigative > int_social) {
            Toast.makeText(ResultActivity.this, "You are Investigative.Your educational fields are Engineering,Medical,and pure Sciences", Toast.LENGTH_SHORT).show();


        }
        if (int_realistic > int_Entreprising && int_realistic > int_social) {
            Toast.makeText(ResultActivity.this, "You are Realistic.your educational fields are Technician,Manager,Arts,Desinger and teacher etc", Toast.LENGTH_SHORT).show();
        }
        if (int_Entreprising > int_social) {
            Toast.makeText(ResultActivity.this, "You are Enterprising.Your educational fields are Entrepreneur,lawyer,Business,leadership,political science etc", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ResultActivity.this, "You are Socail.Your educational fields are Manager,Administrator,Teacher,trainer etc", Toast.LENGTH_SHORT).show();
        }
    }
}