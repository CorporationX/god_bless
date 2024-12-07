package school.faang.bjs244733;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Room {
    // — уникальный идентификатор комнаты;
    private int roomId;
    // — тип комнаты (например, "конференц-зал", "переговорная");
    private String type;
    // — набор удобств, доступных в комнате (например, "проектор", "видеоконференция").
    private Set<String> amenities;
}
