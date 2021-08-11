package com.dev.department.service;


import com.dev.department.entity.Event;
import com.dev.department.entity.Mail;
import com.dev.department.repository.EventRepository;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.List;
import java.util.logging.Logger;

@Service
public class EventService {


    @Autowired
    EventRepository eventRepository;

    @Autowired
    MailService mailService;

@Autowired
    FirebaseServices firebaseServices;



    public Event saveEvent(Event event) throws Exception{
       Event eventResponse=eventRepository.save(event);
        sendNotification(eventResponse);
        //firebaseServices.saveEventDetails(event);
        return eventResponse;
    }

    public Event updateEvent(Event event){
        Event eventResponse=eventRepository.save(event);
        return eventResponse;
    }
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event findEventById(Long eventId) {
        return eventRepository.findByEventId(eventId);
    }

    public void sendNotification(Event e){

        String emailids=e.getActivityAllUsers();
        String[] emails=emailids.split(",");
        for(int i=0;i<emails.length;i++){
            Mail mail = new Mail();
            mail.setMailFrom("informationtechnologyhyderabad@gmail.com");
            mail.setMailTo(emails[i]);
            mail.setMailSubject("Please accept the Event Invite from Helpers Desk");
            mail.setMailContent("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<style>\n" +
                    ".button {\n" +
                    "  background-color: #4CAF50;\n" +
                    "  border: none;\n" +
                    "  color: white;\n" +
                    "  padding: 15px 32px;\n" +
                    "  text-align: center;\n" +
                    "  text-decoration: none;\n" +
                    "  display: inline-block;\n" +
                    "  font-size: 16px;\n" +
                    "  margin: 4px 2px;\n" +
                    "  cursor: pointer;\n" +
                    "}\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\n" +
                    "<h4>Dear user</h4>\n" +
                    "\n" +
                    "<table style=\"width:50%\">\n" +
                    "  <tr>\n" +
                    "    <th>Please click on below button for Accepting the Activity Event Timings</th>\n" +
                    "    <th>"+"<a href=http://localhost:9001/events/update/"+e.getEventId()+"/"+emails[i]+" >"
                    +" <button class=\"button\">"+e.getActivityDate()+ " " +e.getActivityTime()+"</button> </a>");
            mailService.sendEmail(mail);
            System.out.println("sentMail to :"+emails[i]);
        }

    }
}
