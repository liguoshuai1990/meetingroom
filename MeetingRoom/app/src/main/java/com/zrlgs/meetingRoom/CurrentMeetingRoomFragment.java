package com.zrlgs.meetingRoom;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ZhangRong on 2017/2/22.
 *
 */

public class CurrentMeetingRoomFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_mettingroom, container, false);
        ArrayList<MeetingData> meetingDataList = new ArrayList<>();
        MeetingData md1 = new MeetingData();
        md1.setMeetingTitle("02-1会议室");
        md1.setProjectName("项目1");
        md1.setmMeetingState("进行中");
        md1.setDeportment("市场部");
        md1.setReservedPerson("李XX");
        md1.setContact_type("15010446529");
        md1.setSheduledTime("8:00-10:00");

        MeetingData md2 = new MeetingData();
        md2.setMeetingTitle("02-1会议室");
        md1.setmMeetingState("未开始");
        md2.setProjectName("项目2");
        md2.setDeportment("市场部");
        md2.setReservedPerson("李XX");
        md1.setContact_type("15010446529");
        md2.setSheduledTime("10:00-12:00");


        MeetingData md3 = new MeetingData();
        md3.setMeetingTitle("02-1会议室");
        md1.setmMeetingState("未开始");
        md3.setProjectName("项目3");
        md3.setDeportment("后勤部");
        md3.setReservedPerson("张三");
        md1.setContact_type("15010446529");
        md3.setSheduledTime("14:00-16:00");

        meetingDataList.add(md1);
        meetingDataList.add(md2);
        meetingDataList.add(md3);
        meetingDataList.add(md1);
        meetingDataList.add(md2);
        meetingDataList.add(md3);

        WindowManager wm = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        } else {
            wm = this.getActivity().getWindowManager();
        }
        Point size = new Point();
        wm.getDefaultDisplay().getSize(size);

        MeetingListAdapter meetingAdapter = new MeetingListAdapter(meetingDataList,
                this.getActivity().getApplicationContext(), size);
        ListView listView = (ListView) view.findViewById(R.id.meeting_information_list);
        listView.setAdapter(meetingAdapter);

        return view;
    }
}
