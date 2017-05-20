package com.meeting.room.service.impl;

import com.meeting.room.entity.MeetingEntity;
import com.meeting.room.entity.MeetingRoomEntity;
import com.meeting.room.repository.MeetingRepository;
import com.meeting.room.repository.MeetingRoomRepository;
import com.meeting.room.service.IMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingService implements IMeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private MeetingRoomRepository meetingRoomRepository;

    @Override
    public List<MeetingRoomEntity> ListMeetingRoom() {
        return (List<MeetingRoomEntity>) meetingRoomRepository.findAll();
    }

    @Override
    public List<MeetingEntity> ListMeetingInfo(String meetingRoomId) {
        List<String> ids = new ArrayList<>();
        ids.add(meetingRoomId);
        return (List<MeetingEntity>) meetingRepository.findAllById(ids);
    }
}