package com.meeting.room.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class MeetingEntity implements Serializable {
    @Id
    @GeneratedValue
    private String id;             /* ID */
    @Column(nullable = false)
    private String Name;
    private String State;          /* 会议状态 */
    private String RequestPerson;  /* 预定人 */
    private String Contact;        /* 预定人联系方式 */
    private String Department;     /* 预定部门 */
    private String Room;           /* 预定会议室 */

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

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getRequestPerson() {
        return RequestPerson;
    }

    public void setRequestPerson(String requestPerson) {
        RequestPerson = requestPerson;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String room) {
        Room = room;
    }
}
