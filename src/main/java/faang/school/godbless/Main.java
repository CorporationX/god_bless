package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  private static Map<Integer, StreamEvent> streamEventMapId = new HashMap<>();
  private static Map<String, List<StreamEvent>> streamEventMapType = new HashMap<>();

  public static void main(String[] args) {
    streamEventMapId.put(1, new StreamEvent(1, "1", 1));
    List<StreamEvent> types = new ArrayList<>();
    types.add(new StreamEvent(1, "1", 1));
    streamEventMapType.put("1", types);
    addStreamEvent(new StreamEvent(2, "2", 2));
    getStreamEventById(2);
    getStreamEventByType("2");
    deleteStreamEventById(1);
    getAllEvents().entrySet().forEach(System.out::println);
  }

  public static void addStreamEvent(StreamEvent streamEvent) {
    streamEventMapId.put(streamEvent.getId(), streamEvent);
    streamEventMapType.computeIfAbsent(streamEvent.getEventType(), s -> new ArrayList<>()).add(streamEvent);
  }
  public static StreamEvent getStreamEventById(int id) {
    return streamEventMapId.get(id);
  }
  public static List<StreamEvent> getStreamEventByType(String type) {
    return streamEventMapType.get(type);
  }
  public static void deleteStreamEventById(int id) {
    StreamEvent event = streamEventMapId.remove(id);
    streamEventMapType.get(event.getEventType()).remove(event);
  }
  public static Map<Integer, StreamEvent> getAllEvents() {
    return streamEventMapId;
  }
}
