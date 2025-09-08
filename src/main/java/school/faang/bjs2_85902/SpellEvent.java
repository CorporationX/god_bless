package school.faang.bjs2_85902;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@EqualsAndHashCode
@ToString
public class SpellEvent {

    private int id;
    @ToString.Exclude private Set<String> evenType = Set.of("Чар", "Трансфигурация", "Защита");
    @ToString.Exclude private Set<String> action = Set.of("Защита от атак", "Преобразует предмет");
    private String event;
    private String description;

    public SpellEvent() {
        this.event = evenType.iterator().next();
        this.description = evenType.iterator().next();
    }

    public SpellEvent(String event, String description, int id) {
        this.event = event;
        this.description = description;
    }
}
