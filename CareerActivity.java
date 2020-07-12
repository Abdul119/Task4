package com.example.abdulali.careerkey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CareerActivity extends AppCompatActivity {

    private Questionare instanceQ=new Questionare();
    private Social instanceS=new Social();
    private Artistic instanceA=new Artistic();
    private Investigative instanceI=new Investigative();
    private Conventional instanceC=new Conventional();
    private Realistic instanceR=new Realistic();
    private Enterprising instanceE=new Enterprising();

    private TextView myQuestionNumber;
    private TextView myQuestions;
    private Button   Like;
    private Button   Dislike;
    private Button   Next;
    private Button   Result;

    private int questionNumber=0;
    private int mQuestion=0;
    private static int num=0;
    private String myString;
   public static int int_realistic,int_Entreprising,int_investigative,int_social,int_conventional,int_artistic =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career);
        myQuestionNumber=(TextView)findViewById(R.id.QuestionNumber);
        myQuestions=(TextView)findViewById(R.id.Question_text);
        Result=(Button)findViewById(R.id.choice4);
        Result.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(i);
            }
        });
        likeButtonClickListener();
        dislikeButtonClickListener();
        nextButtonClickListener();
        resultButtonClickListener();


    }

        public void likeButtonClickListener() {
            Like = (Button) findViewById(R.id.choice1);

            Like.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (questionNumber <= 7)
                                int_realistic = int_realistic + 1;
                            if (questionNumber > 7 && questionNumber <=15)
                                int_artistic = int_artistic + 1;
                            if (questionNumber > 15 && questionNumber <= 23)
                                int_Entreprising = int_Entreprising + 1;
                            if (questionNumber > 23 && questionNumber <= 31)
                                int_investigative = int_investigative + 1;
                            if (questionNumber > 31 && questionNumber <=39)
                                int_conventional=int_conventional+1;
                            if (questionNumber > 39 && questionNumber <=47)
                                int_social = int_social + 1;
try {
    updateQuestion();
    questionNumber = questionNumber + 1;

    updatequestionNumber(questionNumber);

    Toast.makeText(CareerActivity.this, "like", Toast.LENGTH_SHORT).show();
}catch (Exception e){

}



                    }

            });
        }


    public void dislikeButtonClickListener() {
        Dislike = (Button) findViewById(R.id.choice2);

        Dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    questionNumber = questionNumber + 1;
                    updatequestionNumber(questionNumber);
                    updateQuestion();
                    //this line of code is optional
                    Toast.makeText(CareerActivity.this, "Dislike", Toast.LENGTH_SHORT).show();
                }catch (Exception e){

                }

            }
        });
    }
    public void nextButtonClickListener() {
        Next = (Button) findViewById(R.id.choice3);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
try {
    questionNumber = questionNumber + 1;
    updatequestionNumber(questionNumber);
    updateQuestion();

    //this line of code is optional
    Toast.makeText(CareerActivity.this, "Next", Toast.LENGTH_SHORT).show();
}catch (Exception e){

}
            }
        });
    }
          private void updatequestionNumber(int x)
          {
              myQuestionNumber.setText(""+questionNumber);
          }
          private void updateQuestion(){
              try {
                  myQuestions.setText(instanceQ.getQuestion(mQuestion));
                  mQuestion++;
                  if (mQuestion > 47)
                      Toast.makeText(getApplicationContext(), "finished", Toast.LENGTH_SHORT).show();
              }catch (Exception e){

              }
          }

      private void updateString(int y){

      }
    public void resultButtonClickListener(){
        Intent intent=new Intent(this,ResultActivity.class);
        startActivity(intent);
    }
}
