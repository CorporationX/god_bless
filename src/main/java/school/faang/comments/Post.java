package school.faang.comments;

import java.util.ArrayList;
import java.util.List;

public record Post(int id,
                   String header,
                   String text,
                   String author,
                   List<Comment> listComments) {

    public Post updateComment(Comment comment) {
        List<Comment> updatedComments = new ArrayList<>(this.listComments);
        updatedComments.add(comment);
        return new Post(this.id, this.header, this.text, this.author, updatedComments);
    }

    public Post deleteComment(Comment comment) {
        List<Comment> updatedComments = new ArrayList<>(this.listComments);
        updatedComments.remove(comment);
        return new Post(this.id, this.header, this.text, this.author, updatedComments);
    }
}