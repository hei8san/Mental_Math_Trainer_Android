package online.ksawa.mentalmathtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView questionTextView;
    TextView timerTextView;
    CountDownTimer countDownTimer;
    int time;
    int scoreCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         questionTextView = findViewById(R.id.questionTextView);
        timerTextView = findViewById(R.id.timeTextView);
         startGame();
    }

    public void generateQuestion(){
        int firstNumber = (int)(Math.random()*100);
        int secondNumber = (int) (Math.random()*100);
        Log.i("firstNumber",Integer.toString(firstNumber));
        Log.i("secondNumber",Integer.toString(secondNumber));

        int answer = 0;
        boolean adding = true;
        StringBuilder questionStringBuilder = new StringBuilder();
        if((int) Math.random()*100%2==0){
            adding = false;
        }
        if(adding){
             questionStringBuilder = new StringBuilder(firstNumber + " + "+secondNumber);
            answer = firstNumber+secondNumber;
        }else{
             questionStringBuilder = new StringBuilder(firstNumber + " - "+secondNumber);
            answer = firstNumber-secondNumber;
        }
        questionTextView.setText(questionStringBuilder.toString());
    }

    public void startGame(){
        time = 30;
//        scoreCount = 0;
        Log.i("timerTextView",Integer.toString(time)+"s");
        timerTextView.setText(Integer.toString(time)+"s");
         countDownTimer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {

                time--;
                timerTextView.setText(Integer.toString(time)+"s");
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void btnClicked(View view){
        generateQuestion();
    }
    public void startBTNClicked(View view){

    }



}