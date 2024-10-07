package school.faang.BJS233254;

import java.util.List;

public interface StreamEventService {
    void addEvent(EventType eventType, String s);

    StreamEvent findEventById(int id);

    List<StreamEvent> findListByEventType(EventType type);

    void deleteEvent(int id);

    void printAll();
}
