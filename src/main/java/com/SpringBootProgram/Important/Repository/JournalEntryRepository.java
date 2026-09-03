package com.SpringBootProgram.Important.Repository;

import com.SpringBootProgram.Important.Entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {
    //we put JournalEntry and string in our generic as Journal Entry has our field and of string type
}
