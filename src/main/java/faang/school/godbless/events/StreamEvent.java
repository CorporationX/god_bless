package faang.school.godbless.events;

import lombok.NonNull;

public record StreamEvent(@NonNull Integer id, @NonNull String type, @NonNull String data) {
}
