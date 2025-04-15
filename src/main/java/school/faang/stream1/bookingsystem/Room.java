package school.faang.stream1.bookingsystem;

import java.util.Set;

public class Room {
    // — уникальный номер комнаты;
    int roomNumber;

    // — тип комнаты (например, "конференц-зал", "переговорная");
    String type;

    // — набор удобств, доступных в комнате (например, "проектор", "видеоконференция").
    Set<String> amenities;
}
