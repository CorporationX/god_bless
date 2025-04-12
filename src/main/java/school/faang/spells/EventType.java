package school.faang.spells;

import lombok.Getter;

@Getter
public enum EventType {
    CHARMS("Чары"),
    DEFENCE("Защита"),
    TRANSFIGURATION("Трансфигурация"),
    ATTACK("Атакующие Чары");

    private final String typeName;

    private EventType(String name) {
        this.typeName = name;
    }

    @Override
    public String toString() {
        return this.typeName;
    }
}
