package school.faang.libraryofwesteros;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Related to JIRA ticket: BJS2-68651
 */
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
