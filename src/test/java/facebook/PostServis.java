package facebook;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostServis {
    private final CopyOnWriteArrayList<Post> posts;

    public PostServis() {
        this.posts =new CopyOnWriteArrayList<>();
    }

    public void addPost(Post post){
        posts.add(post);
    }

    public Optional<Post> findPost(int postId){
        return posts.stream()
                .filter(post -> post.getId()==postId)
                .findFirst();
    }

    public void addComment(int postId,Comment comment) {
        Optional<Post> postOpt = findPost(postId);
        postOpt.ifPresent(post -> post.addComment(comment));
    }

    public void removePost (int postID){
        boolean removed = posts.removeIf(post -> post.getId() == postID);
        if (removed) {
            System.out.println("Post with id " + postID + " was removed.");
        } else {
            System.out.println("Post with id " + postID + " not found.");
        }
    }

     public void remooveComment(int postID, String textComment) {
         Optional<Post> postOpt = findPost(postID);
        if(postOpt.isPresent()){
            Post post = postOpt.get();
            boolean removed = post.getComments().removeIf(comment->comment.getText().equals(textComment));
            if(removed){
                System.out.println("Comment with text " + textComment + " was removed");
            } else {
                System.out.println("Comment with text " + textComment + " not found");
            }
        }else {
            System.out.println("Post with id "+postID+ " not found");
        }
     }

    public void showPosts(){
        for(Post post : posts){
            System.out.println(post);
            for(Comment comment : post.getComments()){
                System.out.println(" - " + comment);
            }
        }
    }
}
