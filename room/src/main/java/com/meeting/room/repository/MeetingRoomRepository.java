package com.meeting.room.repository;

import com.meeting.room.entity.MeetingRoomEntity;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRoomRepository extends CrudRepository<MeetingRoomEntity, String> {
}
