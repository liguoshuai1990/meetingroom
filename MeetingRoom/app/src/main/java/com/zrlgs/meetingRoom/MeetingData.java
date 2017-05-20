package com.zrlgs.meetingRoom;

/**
 * Created by ZhangRong on 2017/2/23.
 *
 */

class MeetingData {
    private String mMeetingTitle;
    private String mProjectName;
    private String mMeetingState;
    private String mDeportment;
    private String mReservedPerson;
    private String contact_type;
    private String mSheduledTime;


    String getProjectName() {
        return mProjectName;
    }

    void setProjectName(String mProjectName) {
        this.mProjectName = mProjectName;
    }

    String getDeportment() {
        return mDeportment;
    }

    void setDeportment(String mDeportment) {
        this.mDeportment = mDeportment;
    }

    String getReservedPerson() {
        return mReservedPerson;
    }

    void setReservedPerson(String mReservedPerson) {
        this.mReservedPerson = mReservedPerson;
    }

    String getSheduledTime() {
        return mSheduledTime;
    }

    void setSheduledTime(String mSheduledTime) {
        this.mSheduledTime = mSheduledTime;
    }

    String getMeetingTitle() {
        return mMeetingTitle;
    }

    void setMeetingTitle(String mMeetingTitle) {
        this.mMeetingTitle = mMeetingTitle;
    }

    public String getmMeetingState() {
        return mMeetingState;
    }

    public void setmMeetingState(String mMeetingState) {
        this.mMeetingState = mMeetingState;
    }

    public String getContact_type() {
        return contact_type;
    }

    public void setContact_type(String contact_type) {
        this.contact_type = contact_type;
    }
}
