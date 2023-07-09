package faang.school.godbless.comment;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {
    private static int counter;
    private int id = counter;
    private String username;
    private int age;
    private List<Comment> comments = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    public User(String username, int age) {
        this.username = username;
        this.age = age;
        counter++;
    }
}
