package ru.kraiush.threads.BJS2_25625;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Comment {

    private int id;
    private String text;
    private Date commentDate;
    private Author author;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + commentDate +
                ", author=" + author +
                '}';
    }
}
