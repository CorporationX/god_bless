package faang.school.godbless.colleagueHelp;

import lombok.NonNull;

public record Person(@NonNull String name,
                     @NonNull String surname,
                     @NonNull String workPlace,
                     int age) {
}
