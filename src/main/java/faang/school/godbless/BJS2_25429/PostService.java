package faang.school.godbless.BJS2_25429;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class PostService {
    private final Map<Integer, Post> ids = new ConcurrentHashMap<>();

    public void addComment(Integer id, Comment comment) {
        ids.get(id).addComment(comment);
    }

    public void addPost(Integer id, Post post) {
        ids.put(id, post);
    }

    public void dump() {
        ids.forEach((k, v) -> System.out.println("Ключ: " + k + " , Значение: " + v));
    }
}
