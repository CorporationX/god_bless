package faang.school.godbless.BJS29796.processor;

import faang.school.godbless.BJS29796.entity.Comment;
import faang.school.godbless.BJS29796.validator.Error;
import faang.school.godbless.BJS29796.validator.ValidationResult;


public abstract class CommentProcessor implements Processor<Comment> {

    protected final ValidationResult validationResult;

    public CommentProcessor(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }

    public void addError(Error error) {
        validationResult.add(error);
    }

    private Processor next;

    @Override
    public void handle(Comment request) {
        if (next != null) {
            next.handle(request);
        }
    }

    @Override
    public Processor setNext(Processor next) {
        this.next = next;
        return next;
    }
}
