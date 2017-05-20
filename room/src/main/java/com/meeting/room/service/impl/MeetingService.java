package com.meeting.room.service.impl;

import com.meeting.room.entity.MeetingEntity;
import com.meeting.room.entity.MeetingRoomEntity;
import com.meeting.room.service.IMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService implements IMeetingService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<MeetingRoomEntity> ListMeetingRoom() {
        String sql = "select ID from Structures(nolock)";
        return jdbcTemplate.queryForList(sql, MeetingRoomEntity.class);
    }

    @Override
    public List<MeetingEntity> ListMeetingInfo(String meetingRoomId) {
        String sql = "select ID from Structures(nolock) where id=?";
        return jdbcTemplate.queryForList(sql, MeetingEntity.class, meetingRoomId);
    }
}