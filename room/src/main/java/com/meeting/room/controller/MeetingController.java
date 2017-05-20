package com.meeting.room.controller;


import com.meeting.room.service.IMeetingService;
import com.meeting.room.entity.MeetingEntity;
import com.meeting.room.entity.MeetingRoomEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MeetingController {

    @Resource
    private IMeetingService meetingService;

    @RequestMapping(value="/meeting/{meetingRoomId}", method=RequestMethod.GET)
    List<MeetingEntity> listMeetingInfo(@PathVariable String meetingRoomId) {
        return meetingService.ListMeetingInfo(meetingRoomId);
    }

    @RequestMapping(value="/meetingroom", method=RequestMethod.GET)
    List<MeetingRoomEntity> listMeetingRoom() {
        return meetingService.ListMeetingRoom();
    }
}
