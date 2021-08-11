package com.dev.department.service;


import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.dev.department.entity.Event;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.core.Path;

@Service
public class FirebaseServices {

    public String saveEventDetails(Event event) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> future = db.collection("Event").document(event.getEventId().toString()).set(event);


        return "Done";
    }

    public Event getEventDetails(String name) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("Event").document(name);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        Event event = null;
        if (document.exists()) {
            // convert document to POJO
            event = document.toObject(Event.class);
            System.out.println(event);
            return event;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }

    public String deleteEvent(String name) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection("Event").document(name).delete();
        return writeResult.get().getUpdateTime().toString();
    }
}