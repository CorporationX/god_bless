package school.faang.bjs244733;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class Room {

    private int roomId;// — уникальный идентификатор комнаты;

    private String type;// — тип комнаты (например, "конференц-зал", "переговорная");

    private Set<String> amenities;// — набор удобств, доступных в комнате (например, "проектор", "видеоконференция").
}
