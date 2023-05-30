package online.ksawa.mentalmathtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView questionTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         questionTextView = findViewById(R.id.questionTextView);
         generateQuestion();
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



}