package com.dev.department.entity;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long eventId;
    @Column(name="eventName")
    private String eventName;
    @Column(name="activityName")
    private String activityName;
    @Column(name="noOfPeople")
    private String noOfPeople;
    @Column(name="eventStartDate")
    private String eventStartDate;
    @Column(name="eventEndDate")
    private String eventEndDate;
    @Column(name="activityTime")
    private String activityTime;
    @Column(name="activityAllUsers")
    private String activityAllUsers;

    @Column(name="activityBooked")
    private boolean activityBooked;

    @Column(name="activityBookedUser")
    private String activityBookedUser;

    public Event() {
    }

    public Event(Long eventId, String eventName, String activityName, String noOfPeople, String eventStartDate, String eventEndDate, String activityTime, String activityAllUsers, boolean activityBooked, String activityBookedUser) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.activityName = activityName;
        this.noOfPeople = noOfPeople;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.activityTime = activityTime;
        this.activityAllUsers = activityAllUsers;
        this.activityBooked = activityBooked;
        this.activityBookedUser = activityBookedUser;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }


    public String getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(String noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    public String getActivityAllUsers() {
        return activityAllUsers;
    }

    public void setActivityAllUsers(String activityAllUsers) {
        this.activityAllUsers = activityAllUsers;
    }

    public boolean isActivityBooked() {
        return activityBooked;
    }

    public void setActivityBooked(boolean activityBooked) {
        this.activityBooked = activityBooked;
    }

    public String getActivityBookedUser() {
        return activityBookedUser;
    }

    public void setActivityBookedUser(String activityBookedUser) {
        this.activityBookedUser = activityBookedUser;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", activityName='" + activityName + '\'' +
                ", noOfPeople=" + noOfPeople +
                ", eventStartDate='" + eventStartDate + '\'' +
                ", eventEndDate='" + eventEndDate + '\'' +
                ", activityTime='" + activityTime + '\'' +
                ", activityAllUsers='" + activityAllUsers + '\'' +
                ", activityBooked=" + activityBooked +
                ", activityBookedUser='" + activityBookedUser + '\'' +
                '}';
    }
}
