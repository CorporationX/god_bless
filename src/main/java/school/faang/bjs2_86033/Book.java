package school.faang.bjs2_86033;

import java.util.Objects;

public record Book(String title, String author, int year) {

    @Override
    public String toString() {
        return title + " -- " + author + " -- " + year;
    }
}