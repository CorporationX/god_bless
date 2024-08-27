package faang.school.godbless.BJS2_25530;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class PostService {
    private Map<Integer, Post> idByPost = new ConcurrentHashMap<>();

    public void addComment(Integer id, Comment comment) {
        System.out.println("Adding comment: " + comment);
        idByPost.get(id).addComment(comment);
    }

    public void addPost(Integer id, Post post) {
        System.out.println("Adding post: " + post);
        idByPost.put(id, post);
    }

    public void printMap() {
        idByPost.forEach((k, v) ->
                System.out.println("Key: " + k + " \nValue: " + v));
    }
}
