package school.faang.bjs2_75843;

import java.util.NoSuchElementException;

public class DocumentNotFoundException extends NoSuchElementException {
    public DocumentNotFoundException(String id) {
        super(String.format("Document with id %s not found", id));
    }
}
