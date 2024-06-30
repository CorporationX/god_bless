package faang.school.godbless.BJS29796.service;

import faang.school.godbless.BJS29796.entity.Comment;
import faang.school.godbless.BJS29796.processor.CommentProcessor;
import faang.school.godbless.BJS29796.processor.CommentProcessorFactory;
import faang.school.godbless.BJS29796.repository.CommentRepository;

public class CommentService {

    private final CommentRepository commentRepository = CommentRepository.getInstance();
    private final CommentProcessorFactory processorFactory = CommentProcessorFactory.getInstance();

    public void addComment(Comment comment) {
        CommentProcessor commentProcessor = processorFactory.createProcessor();
        commentProcessor.handle(comment);
        commentRepository.add(comment);
        System.out.println("Sending comment: " + comment);
    }


    public void updateComment(Comment comment) {
        System.out.println("Updating comment: " + comment);
    }

    public void deleteComment(Comment comment) {
        System.out.println("Deleting comment: " + comment);
    }


}
