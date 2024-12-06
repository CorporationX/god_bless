package school.faang.task_45141;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
    ELECTRONICS("Electronics"),
    CLOTHES("Clothes"),
    BOOKS("Books"),
    SPORTS("Sports");

    private final String title;
}
