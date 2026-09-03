package com.SpringBootProgram.Important.Entity;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entry") //mapping fields to database
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
//@Builder
@Data// instead of all above just use this
@NoArgsConstructor
public class JournalEntry {

    @Id//  making it unique
    private ObjectId id;
    @NonNull
    private String title;
    private LocalDateTime date;


    private String content;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public ObjectId getId() {
        return id;
    }

}
