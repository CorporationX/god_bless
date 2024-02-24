package faang.school.godbless.search_engine;
public class PageNotFoundException extends Exception {
    public PageNotFoundException() {
        super("Page not found.");
    }
    public PageNotFoundException(String message) {
        super(message);
    }
}
