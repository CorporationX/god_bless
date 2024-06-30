package faang.school.godbless.BJS29796.repository;

import faang.school.godbless.BJS29796.entity.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepository {

    private static int generatorId;
    private static final CommentRepository INSTANCE = new CommentRepository();
    private List<Comment> comments = new ArrayList<>();

    private CommentRepository() {
    }

    public void add(Comment comment) {
        comment.setId(generatorId++);
        comments.add(comment);
    }

    public List<Comment> findAll() {
        return comments;
    }

    public static CommentRepository getInstance() {
        return INSTANCE;
    }

}
