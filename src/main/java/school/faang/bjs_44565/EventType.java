package school.faang.bjs_44565;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum EventType {
    ENCHANTMENT("Чар"), TRANSFIGURATION("Трансфигурация"), PROTECTION("Защита");

    private final String name;

    EventType(String name) {
        this.name = name;
    }

    public static EventType valueOfName(String eventName) {
        return Arrays.stream(EventType.values())
                .filter(eventType -> eventType.getName().equalsIgnoreCase(eventName))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
