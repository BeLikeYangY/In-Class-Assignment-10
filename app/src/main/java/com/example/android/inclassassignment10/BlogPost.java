package com.example.android.inclassassignment10;

import java.util.Calendar;

/**
 * Created by Yang on 2017/4/5.
 */

public class BlogPost {
    String title;
    String time;
    private String body;


    public BlogPost(String title, String time, String body) {
        this.title = title;
        this.time = time;
        this.body = body;
    }

    public BlogPost(){

    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getTime() {
        return time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String toReadableTime(){
        long postTime = Long.valueOf(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(postTime);
        return calendar.getTime().toString();

    }

    @Override
    public String toString() {
        return "Title: " + title
                + '\n' + "Time: " + toReadableTime()
                + '\n' + "Body: " + body
                + '\n';
    }
}
