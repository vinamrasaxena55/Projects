//There are many general entries for users
//so make sure each user has an entry to itself we create UserEntity

package com.SpringBootProgram.Important.Entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
public class User {

    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String password;
    //now we need to make connection b/w journal entries and user
    @DBRef//creating refrence inside users of journal entry
    private List<JournalEntry> journalEntries=new ArrayList<>();//it keeps refrence of entries of journalEntries
    //jaise hi user initalize hogi empty list hogi(null nhi)
    //@DBRef act as foreign key

    private List<String> roles;//for telling to which role to grant which access

    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public String getUserName() {
        return userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



}
//har ek user ki ek se jyada journal entry hongi
