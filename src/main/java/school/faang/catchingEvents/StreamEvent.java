package school.faang.catchingEvents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StreamEvent {
  private int id;
  private String eventType;
  private String data;

  public static void addStreamEvent(StreamEvent streamEvent, Map<Integer, StreamEvent> events, Map<String, List<StreamEvent>> groupEvents) {
    events.put(streamEvent.getId(), streamEvent);
    groupEvents.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
  }

  public static StreamEvent findStreamEventById(int id, Map<Integer, StreamEvent> events) {
    return events.get(id);
  }

  public static List<StreamEvent> findArraysStreamEventByEventType(String eventType, Map<String, List<StreamEvent>> groupsEvents) {
    return groupsEvents.get(eventType);
  }

  public static void deleteStreamEvent(int id, Map<Integer, StreamEvent> events, Map<String, List<StreamEvent>> groupEvents) {
    StreamEvent streamEvent = findStreamEventById(id, events);

    events.remove(id);
    groupEvents.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).remove(streamEvent);
  }

}
