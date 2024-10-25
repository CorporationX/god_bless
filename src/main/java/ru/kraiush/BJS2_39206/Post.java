package ru.kraiush.BJS2_39206;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;

    @Override
    public String toString() {
        return "Post ID: " + id + "\n" +
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Content: " + content + "\n" +
                "Comments: " + "\n" + comments + "\n";
    }
}
