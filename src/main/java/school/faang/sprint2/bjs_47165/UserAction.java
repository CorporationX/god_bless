package school.faang.sprint2.bjs_47165;

import lombok.NonNull;

import java.time.LocalDate;

public record UserAction(int id, @NonNull String name, @NonNull String actionType,
                         @NonNull LocalDate actionDate, String content) {
}
