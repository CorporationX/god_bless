package school.faang.java_collection_1_3.bjs2_68730;

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
