package school.faang.task57760.service;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
