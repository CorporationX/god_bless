package faang.school.godbless.leaving_comments;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Getter
@ToString
public class PostService {
    private final List<Post> postList = new ArrayList<>();
    private final Lock postListModificationLock = new ReentrantLock();

    public void addComment(int postId, Comment comment) {
        postListModificationLock.lock();

        try {
            Post postToComment = postList.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Could not find post by this id"));

            postToComment.getCommentList().add(comment);
        } finally {
            postListModificationLock.unlock();
        }
    }

    public void addPost(Post postToAdd) {
        postListModificationLock.lock();

        try {
            postList.add(postToAdd);
        } finally {
            postListModificationLock.unlock();
        }
    }

    public void deletePost(String author, Post postToDelete) {
        if (!author.equals(postToDelete.getAuthor())) {
            throw new IllegalArgumentException("Author: " + author + " does not have rights to delete post with id:"
                    + postToDelete.getId());
        }

        postListModificationLock.lock();
        try {
            boolean isDeleteSuccessful = postList.remove(postToDelete);
            if (!isDeleteSuccessful) {
                log.warn("Could not find and delete post with id: " + postToDelete.getId());
            }
        } finally {
            postListModificationLock.unlock();
        }
    }

    public void showAllPosts() {
        postListModificationLock.lock();

        try {
            postList.forEach(System.out::println);
        } finally {
            postListModificationLock.unlock();
        }
    }
}
