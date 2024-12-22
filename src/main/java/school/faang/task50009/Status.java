package school.faang.task50009;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Status {
    NEW("новый"),
    PROCESSED("обработан");

    private final String status;
}
