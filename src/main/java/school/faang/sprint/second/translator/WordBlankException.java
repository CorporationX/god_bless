package school.faang.sprint.second.translator;

public class WordBlankException extends RuntimeException {
    public WordBlankException() {
        super("Some word is blank");
    }
}
