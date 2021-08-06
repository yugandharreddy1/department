package com.dev.department.controller;


import com.dev.department.entity.Event;
import com.dev.department.service.EventService;
import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/events")
public class EventController {


    @Autowired
    EventService eventService;




    @PostMapping(path="/setEvent")
    @CrossOrigin(originPatterns = "*")
    public Event saveEvent(@RequestBody Event event) {
        String str = event.getActivityAllUsers().replaceAll("title","").replaceAll("[^a-zA-Z0-9@_.,]", "");
        System.out.println(str);
        event.setActivityAllUsers(str.trim());
        return eventService.saveEvent(event);
    }
    @GetMapping("/{id}")
    public Event findEventById(@PathVariable("id") Long eventId) {
        return eventService.findEventById(eventId);
    }

    @GetMapping("/update/{id}/{emailid}")
    public ResponseEntity<Event> updateEvent(@PathVariable("id") Long eventId,@PathVariable("emailid") String emailid) {

        Event eventData = eventService.findEventById(eventId);

        if (eventData.getEventId()!=null&& eventData.getActivityBookedUser()==null) {
            eventData.setActivityBooked(true);
            eventData.setActivityBookedUser(emailid);
            return new ResponseEntity(eventService.updateEvent(eventData), HttpStatus.OK);
        } else {
            return new ResponseEntity("Already booked", HttpStatus.OK);
        }
    }

    @GetMapping("/")
    @CrossOrigin(originPatterns = "*")
    public  List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
}