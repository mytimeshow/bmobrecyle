package com.example.administrator.bmobrecyle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class AddActivity extends AppCompatActivity {
    private EditText edt_name;
    private EditText edt_age;
    private Button edt_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edt_age= (EditText) findViewById(R.id.edt_age);
        edt_name= (EditText) findViewById(R.id.edt_name);
        edt_save= (Button) findViewById(R.id.btn);



        edt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edt_name.getText().toString();
                String address=edt_age.getText().toString();
                Person p=new Person();
                p.setName("name");
                p.setAddress(address);
                p.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {

                    }

                });
            }

        });
        finish();
    }
}
