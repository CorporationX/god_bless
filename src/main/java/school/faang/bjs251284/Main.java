package school.faang.bjs251284;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        Post post1 = new Post(1, "First Post",
                "This is the content of the first post", "Author1");
        Post post2 = new Post(2, "Second Post",
                "This is the content of the second post", "Author2");
        Post post3 = new Post(3, "Third Post",
                "This is the content of the third post", "Author3");
        Post post4 = new Post(4, "Fourth Post",
                "This is the content of the fourth post", "Author4");

        postService.addPost(post1);
        postService.addPost(post2);
        postService.addPost(post3);
        postService.addPost(post4);

        Comment comment1 = new Comment("This is a comment on the first post", "Commenter1");
        Comment comment2 = new Comment("This is another comment on the first post", "Commenter2");
        Comment comment3 = new Comment("This is a comment on the second post", "Commenter3");
        Comment comment4 = new Comment("This is a comment on the third post", "Commenter4");
        Comment comment5 = new Comment("This is another comment on the third post", "Commenter5");
        Comment comment6 = new Comment("This is a comment on the fourth post", "Commenter6");

        postService.addComment(1, comment1);
        postService.addComment(1, comment2);
        postService.addComment(2, comment3);
        postService.addComment(3, comment4);
        postService.addComment(3, comment5);
        postService.addComment(4, comment6);

        postService.deleteComment(4, "Commenter6");

        postService.deletePost(3);

        List<Post> remainingPosts = postService.getPosts();
        for (Post post : remainingPosts) {
            System.out.println("Post ID: " + post.getId() + ", Title: " + post.getTitle()
                    + ", Author: " + post.getAuthor());
            for (Comment comment : post.getComments()) {
                System.out.println("  Comment by " + comment.getAuthor() + ": " + comment.getText());
            }
        }
    }
}