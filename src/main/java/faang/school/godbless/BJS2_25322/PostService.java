package faang.school.godbless.BJS2_25322;

import java.util.HashMap;

public class PostService {
    private volatile HashMap<Long, Post> posts = new HashMap<>();

    public synchronized void addComment(long postId, Comment comment) {
        if (posts.containsKey(postId)) {
            Post post = posts.get(postId);
            post.getComments().add(comment);
            System.out.println(comment);
        } else {
            throw new IllegalArgumentException("the post does not exist");
        }
    }

    public synchronized void addPost(Post post) {
        long postId = post.getId();
        if (!posts.containsKey(postId)) {
            posts.put(postId, post);
            System.out.println(post);
        } else {
            throw new IllegalArgumentException("the post already exist");
        }
    }
}

