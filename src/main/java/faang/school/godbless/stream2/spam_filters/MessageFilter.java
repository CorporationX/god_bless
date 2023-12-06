package faang.school.godbless.stream2.spam_filters;

    @FunctionalInterface
    public interface MessageFilter {
        boolean filter(String message);
    }

