package com.dev.department.repository;


import com.dev.department.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository  extends JpaRepository<Event,Long> {


    Event findByEventId(Long eventid);
}
