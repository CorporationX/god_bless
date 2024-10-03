package school.faang.catchingEvents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Map<Integer, StreamEvent> events = new HashMap<>();
    Map<String, List<StreamEvent>> groupEvents = new HashMap<>();

    StreamEvent.addStreamEvent(new StreamEvent(0, "2", "12312"), events, groupEvents);
    StreamEvent.addStreamEvent(new StreamEvent(1, "2", "12321313"), events, groupEvents);
    StreamEvent.addStreamEvent(new StreamEvent(2, "23", "12321313"), events, groupEvents);
    StreamEvent.addStreamEvent(new StreamEvent(3, "23", "1111"), events, groupEvents);

    System.out.println(events);
    System.out.println(groupEvents);

    System.out.println("=============");

    System.out.println(StreamEvent.findStreamEventById(3, events));
    System.out.println(StreamEvent.findArraysStreamEventByEventType("23", groupEvents));

    StreamEvent.deleteStreamEvent(2, events, groupEvents);
    StreamEvent.deleteStreamEvent(0, events, groupEvents);

    System.out.println("=============");

    System.out.println(events);
    System.out.println(groupEvents);



  }
}
