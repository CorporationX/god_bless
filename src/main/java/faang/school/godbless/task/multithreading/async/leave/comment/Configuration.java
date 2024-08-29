package faang.school.godbless.task.multithreading.async.leave.comment;

import lombok.Getter;

import java.util.List;
import java.util.stream.IntStream;

@Getter
public class Configuration {
    private static final int NUMBER_OF_USERS = 10;
    private static final int DEFAULT_POST_INDEX = 0;

    private final List<User> users = createUsers();
    private final List<Post> posts = createPosts();
    private final List<Comment> comments = createComments();

    private List<User> createUsers() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_USERS)
                .mapToObj(i -> new User(i, "User " + i))
                .toList();
    }

    private List<Post> createPosts() {
        return users
                .stream()
                .map(user -> new Post(user, "Header", "Content"))
                .toList();
    }

    private List<Comment> createComments() {
        return users
                .stream()
                .map(user -> new Comment(user, "Content"))
                .toList();
    }

    public Post getDefaultPost() {
        return posts.get(DEFAULT_POST_INDEX);
    }
}
