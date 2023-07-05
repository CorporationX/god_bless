package faang.school.godbless.Sprint4.TakeComments;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class PostService {
    @Getter
    private volatile Set<Post> posts = new HashSet<>();
    public volatile Set<Post> removedComments = new HashSet<>();

    public boolean addPost(Post post) {
        if (posts.add(post)){
            System.out.println(post + " added");
            return true;
        } else {
            System.out.println(post + " failed to add");
            return false;
        }
    }

    public boolean removePost(Post post) {
        synchronized (post) {
            try {
                return posts.remove(post);
            } catch (Exception e) {
                System.out.println(post + " already removed");
            }
            return false;
        }
    }

    //нужна синхранизация по посту, вдруг он удалется
    public boolean addComment(Post post, Comment comment) {
        synchronized (post) {
            for (Post p : posts) {
                if (p == post) {
                    p.addComment(comment);
                    return true;
                }
            }
            System.out.println(post + " not exist");
            return false;
        }
    }

    public boolean removeComment(Post post, Comment comment) {
        synchronized (post) {
            for (Post p : posts) {
                if (p == post) {
                    p.removeComment(comment);
                    removedComments.add(post);
                    return true;
                }
            }
            System.out.println(comment + " not exist");
            return false;
        }
    }

    public boolean updateRemovedComments() {

        if (removedComments.size() == 0) {
            return true;
        } else {
            List<CompletableFuture> executors = new ArrayList<>();
            for (Post post : removedComments) {
                executors.add(CompletableFuture.supplyAsync(
                        () -> post.updateIdComments()
                ).thenAccept(p -> System.out.println(p + " was updated id")));
            }
            CompletableFuture.allOf(executors.toArray(new CompletableFuture[0])).join();

            removedComments.clear();
            System.out.println("updateIdComments has done");
            return true;
        }
    }
}
