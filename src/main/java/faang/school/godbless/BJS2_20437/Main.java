package faang.school.godbless.BJS2_20437;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    HashMap<Integer, StreamEvent> streamEventByID = new HashMap<>();
    HashMap<String, List<StreamEvent>> streamEventByType = new HashMap<>();

    public void addNewStreamEvent(StreamEvent streamEvent) {
        streamEventByID.put(streamEvent.getId(), streamEvent);
        streamEventByType.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public void searchEventByID(Integer id) {
        System.out.println(streamEventByID.get(id));
    }

    public void searchStreamEventByType(String type) {
        for(var event : streamEventByType.get(type)) {
            System.out.println(event);
        }
    }

    public void removeStreamEventByID(Integer id) {
        StreamEvent temp = streamEventByID.remove(id);

        streamEventByType.get(temp.getEventType()).remove(temp);
    }

    public void printAll() {
        for(var entry : streamEventByID.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
