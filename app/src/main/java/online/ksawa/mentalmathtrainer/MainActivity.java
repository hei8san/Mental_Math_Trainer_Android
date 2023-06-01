package online.ksawa.mentalmathtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView questionTextView;
    TextView timerTextView;
    TextView scoreTextView;
    CountDownTimer countDownTimer;
    int answer;
    int time;
    int scoreCount;
    int numberOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        timerTextView = findViewById(R.id.timeTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        numberOfQuestions = 0;
        startGame();
    }


    public void generateQuestion() {
        int firstNumber = (int) (Math.random() * 100);
        int secondNumber = (int) (Math.random() * 100);
        Log.i("firstNumber", Integer.toString(firstNumber));
        Log.i("secondNumber", Integer.toString(secondNumber));

        answer = 0;
        boolean adding = true;
        StringBuilder questionStringBuilder = new StringBuilder();
        if ((int) Math.random() * 100 % 2 == 0) {
            adding = false;
        }
        if (adding) {
            questionStringBuilder = new StringBuilder(firstNumber + " + " + secondNumber);
            answer = firstNumber + secondNumber;
        } else {
            questionStringBuilder = new StringBuilder(firstNumber + " - " + secondNumber);
            answer = firstNumber - secondNumber;
        }
        questionTextView.setText(questionStringBuilder.toString());
        Button btn1 = findViewById(R.id.answerBTN1);
        Button btn2 = findViewById(R.id.answerBTN2);
        Button btn3 = findViewById(R.id.answerBTN3);
        Button btn4 = findViewById(R.id.answerBTN4);
        // 0 - 3 random
        int randomBTNTag = (int) (Math.random() * 4);
        //tag would be easier
        Log.i("randomNum", Integer.toString(randomBTNTag));
        switch (randomBTNTag) {
            case 0:
                btn1.setText(Integer.toString(answer));
                break;
            case 1:
                btn2.setText(Integer.toString(answer));
                break;
            case 2:
                btn3.setText(Integer.toString(answer));
                break;
            case 3:
                btn4.setText(Integer.toString(answer));
                break;
            default:
                break;
        }
        if (!(btn1.getTag().toString().equals(Integer.toString(randomBTNTag)))) {
            int r = (int) (Math.random() * 100);
            btn1.setText(Integer.toString(r));
        }
        if (!(btn2.getTag().toString().equals(Integer.toString(randomBTNTag)))) {
            int r = (int) (Math.random() * 100);
            btn2.setText(Integer.toString(r));

        }
        if (!(btn3.getTag().toString().equals(Integer.toString(randomBTNTag)))) {
            int r = (int) (Math.random() * 100);
            btn3.setText(Integer.toString(r));

        }
        if (!(btn4.getTag().toString().equals(Integer.toString(randomBTNTag)))) {
            int r = (int) (Math.random() * 100);
            btn4.setText(Integer.toString(r));

        }
    }


    public void startGame() {
        time = 30;
        scoreCount = 0;
        numberOfQuestions++;
        Log.i("timerTextView", Integer.toString(time) + "s");
        timerTextView.setText(Integer.toString(time) + "s");
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {

                time--;
                timerTextView.setText(Integer.toString(time) + "s");
            }

            @Override
            public void onFinish() {

            }
        }.start();
        if (time == 0) {


        }
    }

    public void btnClicked(View view) {
//        Button clickedBTN = findViewById(view.getId());
//        int selectedAnswer = Integer.parseInt(clickedBTN.getText().toString());
//        if (selectedAnswer == answer) {
//            scoreCount++;
//            scoreTextView.setText(Integer.toString(scoreCount) + "/" + numberOfQuestions);
//        }

        generateQuestion();


    }


}