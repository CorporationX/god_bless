package faang.school.godbless.BJS2_25347;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class PostService {
    private volatile List<Post> posts = new ArrayList<>();
    private volatile List<Comment> comments = new ArrayList<>();

    ReentrantLock lockComment = new ReentrantLock();
    ReentrantLock lockPost = new ReentrantLock();

    public void addComment(Comment comment) {
        lockComment.lock();
        Post post = comment.getPost();
        post.addComment(comment);
        posts.set(post.getId(), post);
        comments.add(comment);
        lockComment.unlock();
    }

    public Comment getComment(int id) {
        lockComment.lock();
        Comment comment = comments.get(id);
        lockComment.unlock();
        return comment;
    }

    public void removeComment(int id, Author author) {
        lockComment.lock();
        if (comments.get(id).getAuthor().equals(author)) {
            comments.remove(id);
            System.out.println("Comment with id " + id + " removed");
        } else {
            System.out.println("This comment does not belong to author " + author);
        }
    }

    public void addPost(Post post) {
        lockPost.lock();
        posts.add(post);
        lockPost.unlock();
    }

    public Post getPost(int id) {
        lockPost.lock();
        Post post = posts.get(id);
        lockPost.unlock();
        return post;
    }

    public void removePost(int id, Author author) {
        lockPost.lock();
        if (posts.get(id).getAuthor().equals(author)) {
            posts.remove(id);
            System.out.println("Post with id " + id + " removed");
        } else {
            System.out.println("This post does not belong to author " + author);
        }
        lockPost.unlock();
    }
}
