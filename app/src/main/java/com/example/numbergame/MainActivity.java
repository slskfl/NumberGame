package com.example.numbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edNum;
    Button btnStart, btnResult;
    TextView tvHint;
    ImageView ivGame;
    int count=0;
    int myNum, comNum;
    Random random=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNum=findViewById(R.id.edNum);
        btnStart=findViewById(R.id.btnStart);
        btnResult=findViewById(R.id.btnResult);
        tvHint=findViewById(R.id.tvHint);
        ivGame=findViewById(R.id.ivGame);
        tvHint.setText("게임을 시작하려면\n게임시작'을 눌러주세요.");

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
//                comNum=(int)Math.random()+100;
                comNum=random.nextInt(100)+1;
                ivGame.setImageResource(R.drawable.updown);
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myNum=Integer.parseInt(edNum.getText().toString());
                count++;
                if(myNum > comNum){
                    tvHint.setText("당신의 숫자가 큽니다.\n더 작은 수를 넣어주세요.");
                }else if(myNum < comNum){
                    tvHint.setText("당신의 숫자가 작습니다.\n큰 수를 넣어주세요.");
                }else if(myNum==comNum){
                    tvHint.setText("맞추셨습니다!  >> "+count+"회");
                    ivGame.setImageResource(R.drawable.conc);
                }
            }
        });
    }
}