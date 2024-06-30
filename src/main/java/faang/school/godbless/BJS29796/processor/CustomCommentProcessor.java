package faang.school.godbless.BJS29796.processor;

import faang.school.godbless.BJS29796.entity.Comment;
import faang.school.godbless.BJS29796.validator.ValidationResult;

public class CustomCommentProcessor extends CommentProcessor {

    public CustomCommentProcessor(ValidationResult validationResult) {
        super(validationResult);
        setNext(new SwearingCommentProcessor(validationResult))
                .setNext(new URLCommentProcessor(validationResult))
                .setNext(new SpamCommentProcessor(validationResult))
                .setNext(new BanCommentProcessor(validationResult));
    }

    @Override
    public void handle(Comment request) {
        super.handle(request);
    }
}
