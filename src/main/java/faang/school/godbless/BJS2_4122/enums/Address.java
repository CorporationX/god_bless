package faang.school.godbless.BJS2_4122.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Address {
    LONDON("London"),
    NEW_YORK("New York"),
    AMSTERDAM("Amsterdam");

    private final String address;
}
