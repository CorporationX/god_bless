package faang.school.godbless.bjs2_8777;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  private static final String STREAM_EVENT = "СОбытие потока - ";
  private static final String ID_EVENT = "id: ";
  private static final String EVENT_TYPE = "тип событий: ";
  private static final String EVENT_DATA = "данные событий: ";
  private static final String SEPARATOR = ", ";

  private static final Map<Integer, StreamEvent> streamEventMap = new HashMap<>();
  private static final Map<String, List<StreamEvent>> streamEvenListMap = new HashMap<>();

  public static void main(String[] args) {
    addNewStreamEvent(new StreamEvent(1, "первый тип", "Данные событий первого потока"));
    addNewStreamEvent(new StreamEvent(2, "первый тип", "Данные событий второго потока"));
    addNewStreamEvent(new StreamEvent(3, "второй тип", "Данные событий третьего потока"));
    addNewStreamEvent(new StreamEvent(4, "удалить", "Данные событий четвертого потока"));

    showAllStreamEvent();

    deleteStreamEventById(4);

    showAllStreamEvent();

    System.out.println(findStreamEventById(2));

    System.out.println(findStreamEventByType("первый тип"));

  }

  private static void addNewStreamEvent(StreamEvent streamEvent) {
    streamEventMap.put(streamEvent.id(), streamEvent);
    streamEvenListMap.computeIfAbsent(streamEvent.eventType(), key ->  new ArrayList<>()).add(streamEvent);
  }

  private static void deleteStreamEventById(int id) {
    if (streamEventMap.containsKey(id)) {
      final var deletableStreamEvent = streamEventMap.remove(id);
      streamEvenListMap.get(deletableStreamEvent.eventType()).remove(deletableStreamEvent);
    }
  }

  private static StreamEvent findStreamEventById(int id) {
    return streamEventMap.get(id);
  }

  private static List<StreamEvent> findStreamEventByType(String eventType) {
    return streamEvenListMap.get(eventType);
  }

  private static void showAllStreamEvent() {
    for (var streamEvent : streamEventMap.entrySet()) {
      System.out.println(STREAM_EVENT + ID_EVENT + streamEvent.getValue().id() + SEPARATOR +
          EVENT_TYPE + streamEvent.getValue().eventType() + SEPARATOR +
          EVENT_DATA + streamEvent.getValue().data());
    }
  }

}
