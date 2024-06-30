package faang.school.godbless.BJS29796.processor;

import faang.school.godbless.BJS29796.validator.ValidationResult;

public class CommentProcessorFactory {

    private static final CommentProcessorFactory INSTANCE = new CommentProcessorFactory();

    private CommentProcessorFactory() {
    }

    public CommentProcessor createProcessor() {
        return new CustomCommentProcessor(new ValidationResult());
    }

    public static CommentProcessorFactory getInstance() {
        return INSTANCE;
    }
}
