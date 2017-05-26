package com.example.raj.rpsgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock, b_paper, b_scissors, b_reset;
    ImageView iv_cpu, iv_my;
    String myChoice, CpuChoice, result;
    Random r;
    TextView cmpResult, youResult;
    int cpucount = 0;
    int youcount = 0;
    TextView user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_my = (ImageView) findViewById(R.id.iv_me);

        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);
        b_reset = (Button) findViewById(R.id.b_reset);

        cmpResult = (TextView) findViewById(R.id.cmpResult);
        youResult = (TextView) findViewById(R.id.youResult);

        user = (TextView) findViewById(R.id.you);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("Name");
        user.setText("Hi "+name);
        r = new Random();

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "rock";
                iv_my.setImageResource(R.drawable.rock);
                calculate();
            }
        });

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "paper";
                iv_my.setImageResource(R.drawable.paper);
                calculate();
            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "scissors";
                iv_my.setImageResource(R.drawable.scissors);
                calculate();
            }
        });

        b_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "";
                youcount = 0;
                cpucount = 0;
                youResult.setText(String.valueOf(youcount));
                cmpResult.setText(String.valueOf(cpucount));
            }
        });

    }
    public void calculate()
    {
        int cpu = r.nextInt(3);

        if(cpu == 0)
        {
            CpuChoice = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        }
        else if(cpu ==1)
        {
            CpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }
        else if(cpu == 2)
        {
            CpuChoice = "scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }


        if(myChoice.equals("rock") && CpuChoice.equals("paper"))
        {
            result = "you lose";
            cpucount++;
            cmpResult.setText(String.valueOf(cpucount));

        }

        else if(myChoice.equals("rock") && CpuChoice.equals("scissors"))
        {
            result = "You win";
            youcount++;
            youResult.setText(String.valueOf(youcount));
        }

        else if(myChoice.equals("paper") && CpuChoice.equals("rock"))
        {
            result = "You win";
            youcount++;
            youResult.setText(String.valueOf(youcount));
        }

        else if(myChoice.equals("paper") && CpuChoice.equals("scissors"))
        {
            result = "You lose";
            cpucount++;
            cmpResult.setText(String.valueOf(cpucount));
        }

        else if(myChoice.equals("scissors") && CpuChoice.equals("rock"))
        {
            result = "You lose";
            cpucount++;
            cmpResult.setText(String.valueOf(cpucount));
        }

        else if(myChoice.equals("scissors") && CpuChoice.equals("paper"))
        {
            result = "You win";
            youcount++;
            youResult.setText(String.valueOf(youcount));
        }

        else if(myChoice.equals("rock") && CpuChoice.equals("rock"))
        {
            result = "Draw";
        }

        else if(myChoice.equals("paper") && CpuChoice.equals("paper"))
        {
            result = "Draw";
        }

        else if(myChoice.equals("scissors") && CpuChoice.equals("scissors"))
        {
            result = "Draw";
        }

        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
    }

}
