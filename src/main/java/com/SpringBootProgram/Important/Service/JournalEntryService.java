package com.SpringBootProgram.Important.Service;

import com.SpringBootProgram.Important.Entity.JournalEntry;
import com.SpringBootProgram.Important.Entity.User;
import com.SpringBootProgram.Important.Repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JournalEntryService {


    @Autowired
    private JournalEntryRepository journalEntryRepository;//field of type JournalEntryRepository
    //injecting JournalEntryRepository in JournalEntryService class

    @Autowired
    private UserEntryService userEntryService;



    @Transactional//transaction make sure that if entry saved in journalEntry then also get saved in user
    //else if only in journalEntry then roll back and remove it, if saved then in both else not saved in any
    public void saveEntry(JournalEntry journalEntry, String userName){
        try {
            User user = userEntryService.findByUserName(userName);//finding user
            journalEntryRepository.save(journalEntry);
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            //saving the journalEntry from database into local variable
            user.getJournalEntries().add(saved);//journal entries mein save kra diya user ke journal entry mein//,matlab jo user upar find kiya hai uska journal entry
            userEntryService.SaveNewUser(user);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An exception occured while saving the entry ",e);
        }

    }

  //override method for putmapping
    public void saveEntry(JournalEntry journalEntry){
      journalEntryRepository.save(journalEntry);

    }
    public List<JournalEntry>getAll(){
        return journalEntryRepository.findAll();
        //we havent written anything inside repo but mongoRepo has them by default
    }
    public Optional<JournalEntry> findById(ObjectId Id){
        return journalEntryRepository.findById(Id);//retrurns optional
    }
    @Transactional
    public boolean deleteById(ObjectId Id,String userName){
        boolean removed=false;
        try {


            User user = userEntryService.findByUserName(userName);//finding user
             removed = user.getJournalEntries().removeIf(x -> x.getId().equals(Id));
            //deleting from journal entry of user if our id is equal to given id
            //we do this to immediately remove if not done this it still get removed when next request made
            if (removed) {
                userEntryService.SaveUser(user);//saving updated one  (not using encoded one)
                journalEntryRepository.deleteById(Id);//no need to return
            }

        } catch (Exception e) {

            throw new RuntimeException("An error occured.",e);
        }
        return  removed;
    }

}

//controller-->
