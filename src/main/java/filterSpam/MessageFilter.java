package filterSpam;

@FunctionalInterface
public interface MessageFilter<T, U> {
    public Boolean filter(String s);
}
