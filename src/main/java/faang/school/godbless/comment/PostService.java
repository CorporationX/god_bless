package faang.school.godbless.comment;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PostService {

    private volatile List<Post> posts = new ArrayList<>();

    public void addComment(@NonNull Post post, @NonNull Comment comment) {
        synchronized (post) {
            post.getComments().add(comment);
        }
    }

    public void addPost(@NonNull Post post) {
        synchronized (posts) {
            posts.add(post);
        }
    }

    public void printAllPosts() {
        synchronized (posts) {
            posts.forEach(System.out::println);
        }
    }

    public void removePost(@NonNull Post post, @NonNull String author) {
        synchronized (posts) {
            if (posts.get(post.getId()).getAuthor().equals(author)) {
                log.info("Удаляем пост - {}", post);
                posts.remove(post);
            } else {
                System.out.println("Этот автор не может удалить пост");
            }
        }
    }
}
