package com.zrlgs.meetingRoom;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ZhangRong on 2017/2/23.
 *
 */

class MeetingListAdapter extends BaseAdapter{
    private ArrayList<MeetingData> mMeetingDataList = null;
    private Context mContext = null;
    private Point windowsSize = null;

    MeetingListAdapter(ArrayList<MeetingData> meetingData, Context context, Point size){
        mMeetingDataList = meetingData;
        mContext = context;
        windowsSize = size;
    }

    @Override
    public int getCount() {
        return mMeetingDataList == null ? 0: mMeetingDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMeetingDataList == null ? null: mMeetingDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
            view = layoutInflater.inflate(R.layout.fragment_meeting_information, null);
        }

//        TextView meetingTitle = (TextView) view.findViewById(R.id.meeting_title);
        TextView projectName = (TextView) view.findViewById(R.id.project_name);
        TextView meetingState = (TextView) view.findViewById(R.id.meeting_state);
        TextView deportment = (TextView) view.findViewById(R.id.department);
        TextView resevedPerion = (TextView) view.findViewById(R.id.reserved_person);
        TextView contact_type = (TextView) view.findViewById(R.id.contact_type);
        TextView sheduledTime = (TextView) view.findViewById(R.id.scheduled_time);

        MeetingData meetingData = (MeetingData) getItem(position);
        if (meetingData != null){
//            meetingTitle.setText(meetingData.getMeetingTitle());
//            meetingTitle.setTextSize(adjustFontSize(meetingTitle.getTextSize()));
            projectName.setText(meetingData.getProjectName());
            meetingState.setText(meetingData.getmMeetingState());
            deportment.setText(meetingData.getDeportment());
            resevedPerion.setText(meetingData.getReservedPerson());
            contact_type.setText(meetingData.getContact_type());
            sheduledTime.setText(meetingData.getSheduledTime());
        }
        int size = windowsSize.x;
        view.setLayoutParams(new ViewGroup.LayoutParams(size, size - 200));

        return view;
    }

    //获取字体大小
    private float adjustFontSize(float fontSize) {
        int screenWidth = windowsSize.x > windowsSize.y ? windowsSize.x:windowsSize.y;
        float rate = (float) screenWidth/320;
        return rate * fontSize;
    }
}
