package school.faang.collectordersamazonbjs50169;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    NEW("New"),
    PROCESSED("Processed");

    private final String displayName;
}
