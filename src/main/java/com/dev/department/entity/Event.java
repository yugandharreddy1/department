package com.dev.department.entity;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long eventId;
    @Column(name="activityName")
    private String activityName;
    @Column(name="activityDate")
    private String activityDate;
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

    public Event(Long eventId, String activityName, String activityDate, String activityTime,String activityAllUsers, boolean activityBooked, String activityBookedUser) {
        this.eventId = eventId;
        this.activityName = activityName;
        this.activityDate = activityDate;
        this.activityTime = activityTime;
        this.activityAllUsers=activityAllUsers;
        this.activityBookedUser = activityBookedUser;
    }

    public String getActivityAllUsers() {
        return activityAllUsers;
    }

    public void setActivityAllUsers(String activityAllUsers) {
        this.activityAllUsers = activityAllUsers;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
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
}
