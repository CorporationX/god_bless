package school.faang.bjs2_75935;

import java.util.NoSuchElementException;

public record Author(String name) {
    public Author {
        if (name.isBlank()) {
            throw new NoSuchElementException("Author name is empty");
        }
    }
}
