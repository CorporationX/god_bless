package ru.kraiush.threads.BJS2_25625;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Post {

    private int id;
    private String headline;
    private String text;
    private Author author;
    private List<Comment> listComments;

    public Post(int id, String headline, String text, Author author) {
        this.id = id;
        this.headline = headline;
        this.text = text;
        this.author = author;
        this.listComments = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", head='" + headline + '\'' +
                ", text='" + text + '\'' +
                ", author=" + author +
                ", comments=" + listComments +
                '}';
    }
}
