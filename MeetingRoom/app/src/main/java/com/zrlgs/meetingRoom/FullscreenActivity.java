package com.zrlgs.meetingRoom;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class FullScreenActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    Fragment mCurrentMeetingRoom;
    Fragment mOtherFreeMeetingRoom;
    Button leftButton;
    Button rightButton;
    MeetingService meetingService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                                  WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fullscreen);

        leftButton = (Button) findViewById(R.id.btn_left);
        rightButton = (Button) findViewById(R.id.btn_right);


//        //绑定Service
        Intent intent = new Intent(FullScreenActivity.this, MeetingService.class);
        bindService(intent, conn, Context.BIND_AUTO_CREATE);


//        ArrayList<MeetingDataEntity> meetingData = meetingService.getdata();

        // Use FragmentManager to control fragments.
        fragmentManager = getFragmentManager();
        mCurrentMeetingRoom = new CurrentMeetingFragment();
        mOtherFreeMeetingRoom = new FreeMeetingRoomFragment();

        fragmentManager.beginTransaction().
                add(R.id.layout_main_frame, mCurrentMeetingRoom, "CURRENT_ROOM").commit();
        fragmentManager.beginTransaction().
                add(R.id.layout_main_frame, mOtherFreeMeetingRoom, "OTHER_FREE_ROOM").commit();
        fragmentManager.beginTransaction().
                hide(mOtherFreeMeetingRoom).show(mCurrentMeetingRoom).commit();

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().
                        hide(mOtherFreeMeetingRoom).show(mCurrentMeetingRoom).commit();
                leftButton.setBackground(
                        ContextCompat.getDrawable(getBaseContext(), R.drawable.left_button_click_shape));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    leftButton.setTextColor(getColor(R.color.white));
                } else {
                    leftButton.setTextColor(getResources().getColor(R.color.white));
                }
                rightButton.setBackground(
                        ContextCompat.getDrawable(getBaseContext(), R.drawable.button_null_shape));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    leftButton.setTextColor(getColor(R.color.blue));
                } else {
                    leftButton.setTextColor(getResources().getColor(R.color.blue));
                }
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().
                        hide(mCurrentMeetingRoom).show(mOtherFreeMeetingRoom).commit();
                leftButton.setBackground(
                        ContextCompat.getDrawable(getBaseContext(), R.drawable.left_button_null_shape));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    leftButton.setTextColor(getColor(R.color.blue));
                } else {
                    leftButton.setTextColor(getResources().getColor(R.color.blue));
                }
                rightButton.setBackground(
                        ContextCompat.getDrawable(getBaseContext(), R.drawable.button_click_shape));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    leftButton.setTextColor(getColor(R.color.white));
                } else {
                    leftButton.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            meetingService = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            meetingService = ((MeetingService.MeetingBinder)service).getService();
        }
    };
}
