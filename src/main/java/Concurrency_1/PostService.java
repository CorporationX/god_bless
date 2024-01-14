package Concurrency_1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostService {

    private static int idPost = 1;

    private static Map<Integer, Post> posts = new ConcurrentHashMap<>();

    public static void addComment(int id, String author) {
        synchronized (posts) {
            posts.get(id).addComment(new Comment("comment from post id " + id + " from " + author, author));
        }
    }

    public static void deleteComment(int id, String author) {
        synchronized (posts) {
            Post post = posts.get(id);
            for (Comment comment : post.getComments())
                if (comment.getAuthor().equals(author))
                    post.deleteComment(comment, author);
        }
    }

    public static void addPost(String author) {
        synchronized (posts) {
            posts.put(idPost, new Post("id" + idPost + ":", "demo " + idPost, author));
            idPost++;
        }
    }

    public static int getIdPost() {
        return idPost;
    }

    public static Map<Integer, Post> getPosts() {
        return posts;
    }
}
