package school.faang.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  private static final Map<Integer, StreamEvent> INDEX = new HashMap<>();
  private static final Map<String, List<StreamEvent>> STREAMS_GROUPED = new HashMap<>();

  public static void main(String[] args) {
    StreamEvent event1 = new StreamEvent(1, "type1", "data1");
    addEvent(event1);
    StreamEvent event2 = new StreamEvent(2, "type2", "data2");
    addEvent(event2);
    StreamEvent event3 = new StreamEvent(3, "type3", "data3");
    addEvent(event3);
    StreamEvent event4 = new StreamEvent(4, "type3", "data4");
    addEvent(event4);
    StreamEvent event5 = new StreamEvent(5, "type3", "data5");
    addEvent(event5);
    listAllEvents();
    System.out.println(findById(2));
    System.out.println(findByEventType("type3"));
    listAllGrouped();
    removeEvent(3);
    removeEvent(5);
    listAllEvents();
    listAllGrouped();
  }

  public static void addEvent(StreamEvent event) {
    INDEX.put(event.getId(), event);
    List<StreamEvent> eventsByType = STREAMS_GROUPED.computeIfAbsent(event.getEventType(),
        k -> new ArrayList<>());
    eventsByType.add(event);
  }

  public static StreamEvent findById(Integer id) {
    return INDEX.get(id);
  }

  public static List<StreamEvent> findByEventType(String type) {
    return STREAMS_GROUPED.get(type);
  }

  public static void removeEvent(Integer id) {
    StreamEvent event = findById(id);
    List<StreamEvent> eventGroup = findByEventType(event.getEventType());
    eventGroup.remove(event);
    INDEX.remove(id);
  }

  public static void listAllEvents() {
    for (Map.Entry<Integer, StreamEvent> entry : INDEX.entrySet()) {
      System.out.println(entry.getKey() + " | " + entry.getValue());
    }
  }

  public static void listAllGrouped() {
    for (Map.Entry<String, List<StreamEvent>> entry : STREAMS_GROUPED.entrySet()) {
      System.out.println(entry.getKey() + " | " + entry.getValue());
    }
  }

}
