//package com.SpringBootProgram.Important.journalApp;
//
//import com.SpringBootProgram.Important.Entity.JournalEntry;
//import org.bson.types.ObjectId;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryController {
//
//    public Map<ObjectId,JournalEntry> journalEntries=new HashMap<>();
//    //like a table where we add journal entry
//
//
//    @GetMapping("/abc")//actual path journal//abc
//    public  List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//    @PostMapping
//    public void createEntry(@RequestBody JournalEntry myEntry){
//        //we put body in postman
//        journalEntries.put(myEntry.getId(), myEntry);
//        //in request bode  myentry we are getting everything
//    }
//
//    @GetMapping("id/{myId}")
//    public JournalEntry getJoiurnalEntryById(@PathVariable String myId){
//        //we get only id as we used in path variable
//       return  journalEntries.get(myId);//only getting id
//    }
//    @DeleteMapping("id/{myId}")
//    public JournalEntry deleteEntrybyId(@PathVariable String myId){
//        return  journalEntries.remove(myId);
//    }
//    @PutMapping("/id/{Id}")
//    public JournalEntry updateJournalEntry(@PathVariable ObjectId Id,@RequestBody JournalEntry myEntry){
//        //what path is and what need to be updated
//       return journalEntries.put(Id,myEntry);
//
//    }
//}
