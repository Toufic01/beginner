package com.app.getdata;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView display1,display2;
    EditText Firstname,Secondname;
    Button click,reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display1=(TextView)findViewById(R.id.showindex1);
        display2=(TextView)findViewById(R.id.showindex2);
        Firstname=(EditText)findViewById(R.id.firstnameindex);
        Secondname=(EditText)findViewById(R.id.secondnameindex);
        click=(Button) findViewById(R.id.enter);
        reset=(Button)findViewById(R.id.set);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                display1.setText("Please enter data");

                display2.setText("Please enter data");
                Firstname.setText("");
                Secondname.setText("");
            }
        });



        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String First = Firstname.getText().toString().trim();
                String Second= Secondname.getText().toString().trim();

                if(!TextUtils.isEmpty(First) && !TextUtils.isEmpty(Second))
                {
                    display1.setText(First);
                    display2.setText(Second);
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();


            }
        });


        TextWatcher x=null;
        Firstname.addTextChangedListener(x);
        Secondname.addTextChangedListener(x);


        x = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String w = Firstname.getText().toString().trim();
                String q = Secondname.getText().toString().trim();

                if(!TextUtils.isEmpty(w) || !TextUtils.isEmpty(q))
                {
                    reset.setEnabled(true);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };





    }
}