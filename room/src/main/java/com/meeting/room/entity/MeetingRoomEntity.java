package com.meeting.room.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class MeetingRoomEntity implements Serializable {
    /* 会议室ID */
    @Id
    @GeneratedValue
    private String id;
    /* 会议室名称 */
    @Column(nullable = false)
    private String Name;
    /* 会议室地点 */
    @Column(nullable = false)
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
