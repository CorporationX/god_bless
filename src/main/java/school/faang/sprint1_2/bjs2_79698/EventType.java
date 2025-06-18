package school.faang.sprint1_2.bjs2_79698;

import lombok.Getter;

@Getter
public enum EventType {
    ENCHANTMENT("Чар"),
    TRANSFIGURATION("Трансфигурация"),
    PROTECTION("Защита");

    private final String title;

    EventType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
