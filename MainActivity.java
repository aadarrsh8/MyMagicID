package com.example.mymagicid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);
        tv.setVisibility(View.GONE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String idNum = etID.getText().toString().trim();
               String dob = idNum.substring(0,6);
               int gen = Integer.parseInt(Character.toString(idNum.charAt(6)));
               String gender;

                if(gen < 5)
                    gender = "female";

                else
                    gender = "male";

                int nat = Integer.parseInt(Character.toString(idNum.charAt(10)));
                String nationality;

                if(nat == 0)
                    nationality = "SA Citizen";

                else
                    nationality = "Permanent Resident";

                String ans = getString(R.string.dob) + dob + "\n" + getString(R.string.gen) + gender + "\n"  +
                        getString(R.string.nat) + nationality;

                tv.setText(ans);

                tv.setVisibility(View.VISIBLE);
            }
        });
    }
}