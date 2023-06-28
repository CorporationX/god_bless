package faang.school.godbless.lambda_stream.spam_filter;

public interface MessageFilter {
    boolean filter(String message);
}