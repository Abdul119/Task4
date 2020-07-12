package com.example.abdulali.careerkey;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class BlindActivity extends ListeningActivity {
TextToSpeech t1;
    int int_realistic,int_Entreprising,int_investigative,int_social,int_conventional,int_artistic =0;
    int count =0;
    int num=0;
    public String myQuestion[] = {
            "Planting and growing crops",
            "Working on cars or lawnmowers",
            "Carpentry",
            "Setting type for a printing job",
            "Driving a truck",
            "Fixing electrical appliances",
            "Building things",
            "Wildlife biology",
            "Drawing or painting",
            " Being in a play",
            "Foreign language",
            "Reading fiction or plays",
            "Playing a musical instrument",
            "Writing stories or poetry",
            " Fashion design",
            "Going to concerts or the theater",
            "Talking to people at a party",
            "Working on a sales campaign",
            "Buying clothes for a store",
            "Selling life insurance",
            "Leading a group",
            "Making your opinions heard",
            "Giving talks or speeches",
            "Sales people",
            "Solving math problems",
            "Astronomy",
            "Physics",
            "Using a chemistry set",
            "Working in a lab",
            "Building rocket models",
            "Doing puzzles",
            "Using science to get answers",
            "Working with computers",
            "Using a cash register",
            "Working from nine to five",
            "Typing reports",
            "Following a budget",
            "Using business machines",
            "Keeping detailed records",
            "Filing letters and reports",
            "Studying other cultures",
            "Going to church",
            "Working with youth",
            "Helping people with problems",
            "Making new friends",
            "Attending sports events",
            "Belonging to a club",
            "Working with the elderly"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blind);

        context = getApplicationContext(); // Needs to be set
        VoiceRecognitionListener.getInstance().setListener(BlindActivity.this); // Here we set the current listener
        startListening(); // starts listening


            speakMsg("Welcome To Blind Console career key If you want to know your personality and educational field. yes");

    }

    public void speakMsg(final String s) {
t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
    @Override
    public void onInit(int status) {

        if(status!=TextToSpeech.ERROR){
            t1.setLanguage(Locale.US);
          t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
        }
    }
});
    }

    @Override
    public void processVoiceCommands(String... voiceCommands) {
        String command= voiceCommands[0];
        TextView v = new TextView(getApplicationContext());
        v.setText(command);
        if(command.contains("hello")){
            Toast.makeText(getApplicationContext(),"hello how are ",Toast.LENGTH_SHORT).show();
        }
        if(command.contains("yes")){
            speakMsg("The app will Ask you some questions you have to Answer with like or dislike . And To listen next question just say Next.  Question Number 0. "+myQuestion[0]);


        }
        if(command.contains("like")||command.contains("Like")){
            count++;
            if(count>47) {
                Toast.makeText(getApplicationContext(), "finished", Toast.LENGTH_SHORT).show();
                if (int_artistic > int_social && int_artistic > int_investigative && int_artistic > int_Entreprising
                        && int_artistic > int_conventional && int_artistic > int_realistic) {
                    speakMsg("You are Artistic");
                    speakMsg("Your educational fields are Actor,Designer,Drama,Poetry etc");
                }
                if (int_social > int_investigative && int_social > int_Entreprising && int_social > int_conventional
                        && int_social > int_realistic) {
                    speakMsg("you are Social");
                    speakMsg("your educational fields are Manager,Administrator,Teacher,trainer etc ");
                }
                if (int_investigative > int_Entreprising && int_investigative > int_conventional && int_investigative > int_realistic) {
                    speakMsg("you are investigative");
                    speakMsg("Your educational fields are Engineering,Medical,and pure Sciences");
                }
                if (int_Entreprising > int_conventional && int_Entreprising > int_realistic) {
                    speakMsg("you are Enterprising");
                    speakMsg("your educational fields are Entrepreneur,lawyer,Business,leadership,political science etc");
                }
                if (int_conventional > int_realistic) {
                    speakMsg("you are conventional");
                    speakMsg("your educational fields are IT,Business,manager,computer etc ");
                } else {
                    speakMsg("you are realistic");
                    speakMsg("your educational fields are Technician,Manager,Arts,Desinger and teacher etc");
                }
            }
            else {

                if (count <= 7)
                    int_realistic = int_realistic + 1;
                if (count > 7 && count <=15)
                    int_artistic = int_artistic + 1;
                if (count > 15 && count < 24)
                    int_Entreprising = int_Entreprising + 1;
                if (count > 23 && count < 32)
                    int_investigative = int_investigative + 1;
                if (count > 31 && count < 40)
                    int_conventional=int_conventional+1;
                if (count > 39 && count < 48)
                    int_social = int_social + 1;

            }
        }





        if(command.contains("Next")||command.contains("next")){
                num++;
              speakMsg("Question Number " + num + ": " + myQuestion[num]);





        }

        if(command.contains("Result")||command.contains("result"))
        {
            if (int_artistic > int_social && int_artistic > int_investigative && int_artistic > int_Entreprising
                    && int_artistic > int_conventional && int_artistic > int_realistic) {
                speakMsg("You are Artistic");
                speakMsg("Your educational fields are Actor,Designer,Drama,Poetry etc");
            }
            if (int_social > int_investigative && int_social > int_Entreprising && int_social > int_conventional
                    && int_social > int_realistic) {
                speakMsg("you are Social");
                speakMsg("your educational fields are Manager,Administrator,Teacher,trainer etc ");
            }
            if (int_investigative > int_Entreprising && int_investigative > int_conventional && int_investigative > int_realistic) {
                speakMsg("you are investigative");
                speakMsg("Your educational fields are Engineering,Medical,and pure Sciences");
            }
            if (int_Entreprising > int_conventional && int_Entreprising > int_realistic) {
                speakMsg("you are Enterprising");
                speakMsg("your educational fields are Entrepreneur,lawyer,Business,leadership,political science etc");
            }
            if (int_conventional > int_realistic) {
                speakMsg("you are conventional");
                speakMsg("your educational fields are IT,Business,manager,computer etc ");
            } else {
                speakMsg("you are realistic");
                speakMsg("your educational fields are Technician,Manager,Arts,Desinger and teacher etc");
            }

        }



        restartListeningService();
    }
}
