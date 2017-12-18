package com.example.vijay.jagadeesh;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private EditText Name;
    private  EditText Id;
    private EditText Email;
    private EditText Number;
    private EditText Password;
    private  Button Submit;

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Name=(EditText)findViewById(R.id.editText3);
        Id=(EditText)findViewById(R.id.editText4);
        Email=(EditText)findViewById(R.id.editText5);
        Number=(EditText)findViewById(R.id.editText6);
        Password=(EditText)findViewById(R.id.editText7);
        Submit=(Button)findViewById(R.id.button3);
       // db=openOrCreateDatabase("USERDB", Context.MODE_PRIVATE,null);
        //db.execSQL("CREATE TABLE IF NOT EXISTS user(Username VARCHAR,Id VARCHAR,Email VARCHAR,Number VARCHAR,Password VARCHAR);");
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view==Submit)
                {
                    if(     Name.getText().toString().trim().length() == 0 ||
                            Id.getText().toString().trim().length()==0||
                            Email.getText().toString().trim().length()==0||
                            Number.getText().toString().trim().length()==0||
                            Password.getText().toString().trim().length()==0)
                    {
                        Toast.makeText(Main2Activity.this,"Enter Vaild Data",Toast.LENGTH_LONG).show();

                    }
                    else
                    {
                       // db.execSQL("INSERT INTO user VALUES("+Name.getText()+","+Id.getText()+","+Email.getText()+","+Number.getText()+","+Password.getText()+")");
                       Toast.makeText(Main2Activity.this,"Reg succes",Toast.LENGTH_LONG).show();
                        Intent i= new Intent(Main2Activity.this,MainActivity.class);
                        startActivity(i);
                    }


                }
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
