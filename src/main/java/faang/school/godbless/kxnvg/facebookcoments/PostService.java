package faang.school.godbless.kxnvg.facebookcoments;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {

    private volatile List<Post> posts;
    private final Lock commentLock = new ReentrantLock();
    private final Lock postLock = new ReentrantLock();

    public PostService() {
        posts = new ArrayList<>();
    }

    public void addComment(int id, String text, User author) {
        Comment comment = new Comment(text, author);
        commentLock.lock();
        try {
            posts.get(id).getComments().add(comment);
        } finally {
            commentLock.unlock();
        }
    }

    public void addPost(String header, String text, User postAuthor) {
        Post post = new Post(header, text, postAuthor);
        postLock.lock();
        try {
            posts.add(post);
        } finally {
            postLock.unlock();
        }
    }

    public String getPost(int id) {
        Post post = posts.get(id);
        return post.getHeader() + " : " + post.getPostText() + "\nАвтор поста: " + post.getPostAuthor().getName();
    }

    public List<Comment> getAllCommentsFromPost(int id) {
        return posts.get(id).getComments();
    }

    public String getAllTextOfCommentsFromPost(int id) {
        Post post = posts.get(id);
        StringBuilder builder = new StringBuilder();

        post.getComments().forEach((comment) -> {
            builder.append(comment.getAuthor().getName() + "("
                    + comment.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                    ") : " + comment.getText() + "\n");
        });
        return builder.toString();
    }
}
