package ru.kraiush.BJS2_39206;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PostService {
    private volatile List<Post> posts = new ArrayList<>();

    public synchronized void addPost(Post post) {
        posts.add(post);
        log.info("Your post with title '" + post.getTitle() + "' was created.");
    }

    public void addComment(int postId, Comment comment) {
        boolean isExist = false;
        for (Post post : posts) {
            if (post.getId() == postId) {
                post.getComments().add(comment);
                log.info("Your comment '"+ comment.getText() + "' to post with ID: " + postId + " was posted.");
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            log.info("The post with ID: " + postId + " doesn't exist.");
        }
    }

    public synchronized void viewPostsWithComments() {
        posts.forEach(System.out::println);
    }

    public synchronized void viewPostWithComments(int postId) {
        boolean isExist = false;
        for (Post post : posts) {
            if (post.getId() == postId) {
                System.out.println(post);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            log.info("The post with ID: " + postId + " doesn't exist.");
        }
    }

    public synchronized void removeComment(int postId, Comment comment) {
        boolean isExist = false;
        for (Post post : posts) {
            if (post.getId() == postId) {
                if (!post.getComments().contains(comment)) {
                    log.info("This comment doesn't exist.");
                    break;
                }
                post.getComments().remove(comment);
                log.info("Comment was deleted: " + comment.getText());
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            log.info("The post with ID: " + postId + " doesn't exist.");
        }
    }

    public synchronized void removePost(int postId) {
        boolean isExist = false;
        for (Post post : posts) {
            if (post.getId() == postId) {
                posts.remove(post);
                log.info("The post with ID: " + postId + " was deleted.");
                isExist = true;
            }
        }
        if (!isExist) {
            log.info("This post doesn't exist.");
        }
    }
}
