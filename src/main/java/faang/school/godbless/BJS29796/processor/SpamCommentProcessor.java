package faang.school.godbless.BJS29796.processor;

import faang.school.godbless.BJS29796.entity.Comment;
import faang.school.godbless.BJS29796.repository.CommentRepository;
import faang.school.godbless.BJS29796.validator.Error;
import faang.school.godbless.BJS29796.validator.ValidationResult;

public class SpamCommentProcessor extends CommentProcessor {

    private final CommentRepository commentRepository = CommentRepository.getInstance();

    public SpamCommentProcessor(ValidationResult validationResult) {
        super(validationResult);
    }

    @Override
    public void handle(Comment comment) {
        if (checkSpam(comment)) {
            addError(new Error(101, "Спам"));
        }
        super.handle(comment);
    }

    private boolean checkSpam(Comment request) {
        return commentRepository.findAll().stream()
                .map(Comment::getText)
                .anyMatch(request.getText()::equals);
    }

}
