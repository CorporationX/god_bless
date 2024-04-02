package faang.school.godbless.BJS2_4122.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Job {
    GOOGLE("Google"),
    UBER("Uber"),
    AMAZON("Amazon"),
    LYFT("Lyft");

    private final String companyName;
}
