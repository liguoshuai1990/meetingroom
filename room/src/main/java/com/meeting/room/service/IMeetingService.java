package com.meeting.room.service;

import com.meeting.room.entity.MeetingEntity;
import com.meeting.room.entity.MeetingRoomEntity;

import java.util.List;

public interface IMeetingService {
    List<MeetingRoomEntity> ListMeetingRoom();
    List<MeetingEntity> ListMeetingInfo(String meetingRoomId);
}
