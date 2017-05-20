package com.meeting.room.repository;

import com.meeting.room.entity.MeetingEntity;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<MeetingEntity, String> {
}
