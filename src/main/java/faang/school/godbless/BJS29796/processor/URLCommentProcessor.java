package faang.school.godbless.BJS29796.processor;

import faang.school.godbless.BJS29796.entity.Comment;
import faang.school.godbless.BJS29796.validator.Error;
import faang.school.godbless.BJS29796.validator.ValidationResult;

public class URLCommentProcessor extends CommentProcessor {

    public URLCommentProcessor(ValidationResult validationResult) {
        super(validationResult);
    }

    @Override
    public void handle(Comment comment) {
        if (checkForURL(comment)) {
            addError(new Error(100, "Наличие url адресов"));
        }
        super.handle(comment);
    }

    private boolean checkForURL(Comment request) {
        return request.getText().contains("http://") || request.getText().contains("https://");
    }
}
