package school.faang.bjs2_70830;

import java.util.NoSuchElementException;

public class StudentNotFoundException extends NoSuchElementException {
    public StudentNotFoundException(String msg) {
        super(msg);
    }
}
