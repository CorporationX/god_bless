package faang.school.godbless.BJS2_20385;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Getter
@ToString
@AllArgsConstructor
public class StreamEvent {

    private int id;
    private String type;
    private String data;

    public void addStreamEvent(Map<Integer, StreamEvent> mapIdKey,
                                      Map<String, List<StreamEvent>> mapTypeKey) {
        addStreamEventById(mapIdKey);
        addStreamEventByType(mapTypeKey);
    }

    private void addStreamEventById(Map<Integer, StreamEvent> map) {
        map.put(id, this);
    }

    private void addStreamEventByType(Map<String, List<StreamEvent>> map) {
        List<StreamEvent> streamEvents = map.getOrDefault(type, new ArrayList<>());
        streamEvents.add(this);
        map.put(type, streamEvents);
    }

    public static Optional<StreamEvent> getStreamEventById(Map<Integer, StreamEvent> map, int id) {
        StreamEvent streamEvent = map.get(id);
        return Optional.ofNullable(streamEvent);
    }

    public static Optional<List<StreamEvent>> getListOfStreamEventByType(Map<String, List<StreamEvent>> map, String type) {
        List<StreamEvent> streamEvents = map.get(type);
        return Optional.ofNullable(streamEvents);
    }

    public void removeStreamEventById(Map<Integer, StreamEvent> mapIdKey,
                               Map<String, List<StreamEvent>> mapTypeKey) {
        removeInMapWithIdKey(mapIdKey);
        removeInMapWithTypeKey(mapTypeKey);
    }

    private void removeInMapWithIdKey(Map<Integer, StreamEvent> map) {
        map.remove(id);
    }

    private void removeInMapWithTypeKey(Map<String, List<StreamEvent>> map) {
        List<StreamEvent> streamEvents = map.get(type);
        if (streamEvents != null) {
            streamEvents.remove(this);
            if (streamEvents.isEmpty()) {
                map.remove(type);
            }
        }
    }

    public static void printAllStreamEvents(Map<Integer, StreamEvent> map) {
        for (Map.Entry<Integer, StreamEvent> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
