package school.faang.catchingEvents;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StreamEventService {
  private final Map<Integer, StreamEvent> events = new HashMap<>();
  private final Map<String, List<StreamEvent>> groupEvents = new HashMap<>();

  public void addStreamEvent(StreamEvent streamEvent) {
    events.put(streamEvent.getId(), streamEvent);
    groupEvents.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
  }

  public StreamEvent findStreamEventById(int id) {
    return events.get(id);
  }

  public List<StreamEvent> findArraysStreamEventByEventType(String eventType) {
    return groupEvents.get(eventType);
  }

  public void deleteStreamEvent(int id) {
    StreamEvent streamEvent = findStreamEventById(id);

    if(streamEvent == null) return;

    groupEvents.get(streamEvent.getEventType()).remove(streamEvent);
    events.remove(id);
  }
}
