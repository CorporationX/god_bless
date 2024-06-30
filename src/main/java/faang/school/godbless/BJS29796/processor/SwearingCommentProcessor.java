package faang.school.godbless.BJS29796.processor;

import faang.school.godbless.BJS29796.entity.Comment;
import faang.school.godbless.BJS29796.validator.Error;
import faang.school.godbless.BJS29796.validator.ValidationResult;

public class SwearingCommentProcessor extends CommentProcessor {

    public SwearingCommentProcessor(ValidationResult validationResult) {
        super(validationResult);
    }

    @Override
    public void handle(Comment comment) {
        if (checkForSwearing(comment)) {
            addError(new Error(99, "Наличие матерщины"));
        }
        super.handle(comment);
    }

    private boolean checkForSwearing(Comment request) {
        return request.getText().contains("Матерщина");
    }
}
