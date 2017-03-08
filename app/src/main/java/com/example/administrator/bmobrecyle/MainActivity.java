package com.example.administrator.bmobrecyle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity implements OnDeiListener{
    private RecyclerView mrecyleview;
    private Button btn1;
    private Button btn2;

    private Person person;
    private List<Person> perlist=new ArrayList<>();
    private Myadapter madapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "b8e2bad46c30cd6c0293392219c4d372");
        mrecyleview= (RecyclerView) findViewById(R.id.recyclerview);
        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        add();
        query();
        madapter=new Myadapter(perlist,MainActivity.this);
        LinearLayoutManager manager=new  LinearLayoutManager(MainActivity.this);
        mrecyleview.setLayoutManager(manager);


        mrecyleview.setAdapter(madapter);



        onResume();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,AddActivity.class));
                Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_LONG).show();

            }




        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,AddActivity.class));
                Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_LONG).show();

            }




        });

    }

    private void add() {
        Person p1 = new Person();
        p1.setName("桃平");

        p1.setAddress("天源路789");

        p1.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {

            }
        });
    }


    private void query() {
        BmobQuery<Person> query=new BmobQuery<Person>();
        query.findObjects(new FindListener<Person>() {
            @Override
            public void done(List<Person> list, BmobException e) {
                perlist.clear();
                perlist.addAll(list);
                perlist=list;
                madapter.changData(perlist);
            }
        });

    }

    @Override
    public void del() {
        query();
    }
}
