package faang.school.godbless.BJS2_8774;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  static Map<Long, StreamEvent> eventsId = new HashMap<>();
  static Map<String, List<StreamEvent>> groupEvents = new HashMap<>();
  public static void main(String[] args) {
    addStreamEvent(new StreamEvent(1, "info", "aljfdal"));
    addStreamEvent(new StreamEvent(2, "info", "aljfdal"));
    addStreamEvent(new StreamEvent(3, "warning", "aljfdal"));
    addStreamEvent(new StreamEvent(4, "error", "aljfdal"));
    System.out.println(eventsId);
    System.out.println(groupEvents);
    System.out.println(getStreamEventById(2));
    System.out.println(getListStreamEventsByEventType("info"));
    deleteStreamEventById(2);
    System.out.println(eventsId);
    System.out.println(groupEvents);
    getAllStreamEvents();

  }

  public static void addStreamEvent(StreamEvent streamEvent) {
    eventsId.put(streamEvent.getId(), streamEvent);
    groupEvents.computeIfAbsent(streamEvent.getEventType(), s -> new ArrayList<>()).add(streamEvent);
  }

  public static StreamEvent getStreamEventById(long id) {
    return eventsId.get(id);
  }

  public static List<StreamEvent> getListStreamEventsByEventType(String eventType) {
    return groupEvents.get(eventType);
  }

  public static void deleteStreamEventById(long id) {
    StreamEvent streamEvent = getStreamEventById(id);
    List<StreamEvent> streamEvents = groupEvents.get(streamEvent.getEventType());
    streamEvents.remove(streamEvent);
    groupEvents.put(streamEvent.getEventType(), streamEvents);
    eventsId.remove(id);
  }

  public static void getAllStreamEvents() {
    for (Map.Entry<Long, StreamEvent> entry : eventsId.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue().getEventType() + " " + entry.getValue().getData());
    }
  }
}
