package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LibraryMessages {
    TITLE_AUTHOR_LOCATION_NULL_ERROR("Title, author or location must not be null!"),
    BOOK_ALREADY_EXISTS(" is already in the library!"),
    BOOK_NOT_FOUND(" was not found!"),
    BOOK_REMOVED_SUCCESS(" successfully removed!"),
    BOOK_ADDED_SUCCESS(" added at location ");

    private final String message;
}
