package com.example.android.inclassassignment10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class ObjectActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference postRef;
    DatabaseReference postsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);

        database = FirebaseDatabase.getInstance();
        postRef = database.getReference("post");
        postsRef = database.getReference("posts");

    }

    public void save(View view){
        EditText titleField = (EditText)findViewById(R.id.titleEdit);
        EditText bodyField = (EditText)findViewById(R.id.body);
        long currentTime = Calendar.getInstance().getTimeInMillis();

        String title = titleField.getText().toString();
        String body = bodyField.getText().toString();
        String time = String.valueOf(currentTime);

        BlogPost post = new BlogPost(title, time, body);

//        postRef.setValue(post);
        postsRef.push().setValue(post);

        TextView statusView = (TextView)findViewById(R.id.displayView);
        statusView.setText(post.toString());

        statusView.setVisibility(View.VISIBLE);

        titleField.setText("");
        bodyField.setText("");
    }
}
