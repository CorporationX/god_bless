package faang.school.godbless.comment;

import lombok.NonNull;

public record Author(@NonNull String name, @NonNull String surname) {
    public Author {
        if (name.isBlank() || surname.isBlank()) {
            throw new IllegalArgumentException("Name and Surname couldn't be empty");
        }
    }
}
