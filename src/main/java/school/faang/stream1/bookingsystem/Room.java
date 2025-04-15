package school.faang.stream1.bookingsystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Room {
    // — уникальный номер комнаты;
    int roomNumber;

    // — тип комнаты (например, "конференц-зал", "переговорная");
    String type;

    // — набор удобств, доступных в комнате (например, "проектор", "видеоконференция").
    Set<String> amenities;
}
