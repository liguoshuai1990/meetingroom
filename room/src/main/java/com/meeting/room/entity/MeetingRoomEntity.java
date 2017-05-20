package com.meeting.room.entity;

import java.io.Serializable;

public class MeetingRoomEntity implements Serializable {
    /* 会议室ID */
    private String id;
    /* 会议室名称 */
    private String Name;
    /* 会议室地点 */
    private String Location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
