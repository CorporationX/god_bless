package school.faang.bjs2_70830;

import java.util.NoSuchElementException;

public class SubjectNotFoundException extends NoSuchElementException {
    public SubjectNotFoundException() {
        super("Subject not found");
    }
}
