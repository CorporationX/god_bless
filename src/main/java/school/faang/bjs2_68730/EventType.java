package school.faang.bjs2_68730;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EventType {
    CHAR("Чар"),
    TRANSFIGURATION("Трансфигурация"),
    PROTECTION("Защита");

    private final String spell;
}
