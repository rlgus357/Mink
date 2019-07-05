package com.hanbada.mink.util;

import android.app.Activity;
import android.widget.Toast;

public class BackPressCloseHandler {

    private long backKeyPressdTime = 0;
    private long backKeyIntervalTime = 2000; // ms
    private String backKeyPressedMessage = "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.";

    private Toast toast;

    private Activity activity;

    public BackPressCloseHandler(Activity context){
        this.activity = context;
    }

    public void onBackPressed(){
        if(System.currentTimeMillis() > backKeyPressdTime + backKeyIntervalTime){
            backKeyPressdTime = System.currentTimeMillis();
            this.showGuid();
            return;
        }

        if(System.currentTimeMillis() <= backKeyPressdTime + backKeyIntervalTime){
            activity.finish();
            toast.cancel();
        }
    }

    private void showGuid() {
        toast = Toast.makeText(activity, backKeyPressedMessage,Toast.LENGTH_SHORT);
        toast.show();
    }


}
