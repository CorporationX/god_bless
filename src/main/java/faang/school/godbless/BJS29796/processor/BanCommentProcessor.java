package faang.school.godbless.BJS29796.processor;

import faang.school.godbless.BJS29796.entity.Comment;
import faang.school.godbless.BJS29796.validator.Error;
import faang.school.godbless.BJS29796.validator.ValidationResult;

import java.util.stream.Collectors;

public class BanCommentProcessor extends CommentProcessor {

    public BanCommentProcessor(ValidationResult validationResult) {
        super(validationResult);
    }

    @Override
    public void handle(Comment comment) {
        if (validationResult.hasErrors()) {
            comment.getUser().changeState();
            throw new RuntimeException(validationResult.getErrors().stream()
                    .map(Error::toString)
                    .collect(Collectors.joining("\n", String.format("Нарушения: "), "Статус:" + comment.getUser().getState()))
            );
        }
    }
}
