package filterspam;
@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
