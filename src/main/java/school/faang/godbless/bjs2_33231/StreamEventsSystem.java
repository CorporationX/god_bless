package school.faang.godbless.bjs2_33231;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class StreamEventsSystem {

  private final Map<Integer, StreamEvent> idEventMap = new HashMap<>();
  private final Map<String, List<StreamEvent>> typeEventsListMap = new HashMap<>();

  public void addStreamEvent(StreamEvent event) {
    idEventMap.put(event.getId(), event);
    typeEventsListMap.computeIfAbsent(event.getEventType(), key -> new ArrayList<>()).add(event);
  }

  public Optional<StreamEvent> getById(int id) {
    return idEventMap.containsKey(id) ? Optional.of(idEventMap.get(id)) : Optional.empty();
  }

  public Optional<List<StreamEvent>> getByType(String type) {
    return typeEventsListMap.containsKey(type) ? Optional.of(typeEventsListMap.get(type)) : Optional.empty();
  }

  public boolean removeById(int id) {
    StreamEvent eventToDelete = idEventMap.get(id);
    if (eventToDelete == null) {
      return false;
    }
    idEventMap.remove(id);
    return typeEventsListMap.get(eventToDelete.getEventType()).remove(eventToDelete);
  }

  public String getEventsAsString() {
    StringBuilder sb = new StringBuilder();
    idEventMap.forEach((key, event) -> sb.append(event));
    return sb.toString();
  }
}
