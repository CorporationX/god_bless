package filterSpam_806;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}