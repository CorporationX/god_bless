package faang.school.godbless.multithreading.leavecomments;

import java.util.List;

public record PostService(List<Post> postList) {
    public void addComment(int postId, Comment comment) {
        var post = postList.get(postId);
        post.comments().add(comment);
        System.out.printf("%s added comment.\n", comment.author());
    }

    public void addPost(Post post) {
        postList.add(post);
    }
}
