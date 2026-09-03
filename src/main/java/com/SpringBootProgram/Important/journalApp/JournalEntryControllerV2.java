package com.SpringBootProgram.Important.journalApp;

import com.SpringBootProgram.Important.Entity.JournalEntry;
import com.SpringBootProgram.Important.Entity.User;
import com.SpringBootProgram.Important.Service.JournalEntryService;
import com.SpringBootProgram.Important.Service.UserEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

     @Autowired
     private JournalEntryService journalEntryService;//creating instance injecting

    @Autowired
    private UserEntryService userEntryService;

        @GetMapping//path removed authentication added
        public ResponseEntity<?>getAllJournalEntriesOfUser(){
            Authentication authentication= SecurityContextHolder.getContext().getAuthentication();//yahan tabhi aa payenge jab sahi username aur password
            //postman ke auth mein daalna hai
            //the above statement runs only if it got authenticated
            String userName=authentication.getName();
          User user=  userEntryService.findByUserName(userName);
            List<JournalEntry> all=user.getJournalEntries();//now enties in journal entry refrenced in users
            if(all !=null && !all.isEmpty()){
                return new ResponseEntity<>(HttpStatus.OK);
            }
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        @PostMapping
        public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){//path variable if path we give
            try {
                Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
                String userName=authentication.getName();

                journalEntryService.saveEntry(myEntry,userName);//user find from db
                return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
            }
            catch (Exception e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        }

        @GetMapping("id/{myId}")
        public ResponseEntity<?> getJoiurnalEntryById(@PathVariable ObjectId myId){
            Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
            String userName=authentication.getName();
         User user=   userEntryService.findByUserName(userName);//we find username from userentryservice

            List<JournalEntry> collection = user.getJournalEntries() // get all journal entries of the user
                    .stream() // convert the list into a stream for processing
                    .filter(x -> x.getId().equals(myId)) // keep only those entries whose id matches myId
                    .collect(Collectors.toList()); // convert the filtered stream back into a List
               if(!collection.isEmpty()){
                   Optional<JournalEntry> journalEntry=journalEntryService.findById(myId);  //same thing // collection.get(0).getId();
                   if (journalEntry.isPresent()){
                       return new ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
                       //bcz the field findById  has optional return type
                   }
               }


            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        @DeleteMapping("id/{myId}")
        public ResponseEntity<?> deleteEntrybyId(@PathVariable ObjectId myId){
            Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
            String userName=authentication.getName();
         boolean removed=   journalEntryService.deleteById(myId,userName);
         if(removed) {
             return new ResponseEntity<>(HttpStatus.OK);
         }
         else{
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }

        }
        @PutMapping("/id/{Id}")
        public ResponseEntity<?> updateJournalEntry(@PathVariable ObjectId Id,@RequestBody JournalEntry newEntry){
            //here Id is which we need to update and
            //newEntry is the updated Entry
            Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
            String userName=authentication.getName();
            User user=   userEntryService.findByUserName(userName);//we find username from userentryservice

            List<JournalEntry> collection = user.getJournalEntries() // get all journal entries of the user
                    .stream() // convert the list into a stream for processing
                    .filter(x -> x.getId().equals(Id)) // keep only those entries whose id matches myId
                    .collect(Collectors.toList()); // convert the filtered stream back into a List
            if(!collection.isEmpty()) {
                Optional<JournalEntry> journalEntry = journalEntryService.findById(Id);  //same thing // collection.get(0).getId();
                if (journalEntry.isPresent()) {
                    //in post we return here but in put we update here
                    JournalEntry old = journalEntry.get();
                    old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
                    //agar new title empty hai to purana hi rehne do
                    old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
                    journalEntryService.saveEntry(old);
                    return new ResponseEntity<>(old, HttpStatus.OK);

                }
            }


            //jo update ho baki sab same return
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    //we have to call journalEntry Service through it