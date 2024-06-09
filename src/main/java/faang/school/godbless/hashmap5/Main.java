package faang.school.godbless.hashmap5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static int COUNT_ID = 0;
    private static final String ERROR = "Такого события нет в базе";
    private static final Map<Integer, StreamEvent> STREAM_EVENTS = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENT_TYPES = new HashMap<>();

    public static void main(String[] args) {
        addStreamEvent("Warning", "data_warning1");
        addStreamEvent("Warning", "data_warning2");
        addStreamEvent("Warning", "data_warning3");
        addStreamEvent("Warning", "data_warning4");
        addStreamEvent("Info", "data_info1");
        addStreamEvent("Error", "data_error1");
        addStreamEvent("Error", "data_error2");
        System.out.println(findStreamEvent(10));
        System.out.println(findStreamEvent(3));
        List<StreamEvent> warnings = getListStreamEvent("Warning");
        System.out.println(warnings);
        displayAllStreamEvents();
        deleteStreamEvent(5);
        displayAllStreamEvents();
    }


    public static void displayError() {
        System.out.println(ERROR);
    }

    public static void addStreamEvent(String eventType, String data) {
        StreamEvent streamEvent = new StreamEvent(COUNT_ID, eventType, data);
        STREAM_EVENTS.put(streamEvent.id(), streamEvent);
        if (!EVENT_TYPES.containsKey(eventType)) {
            List<StreamEvent> streamEvents = new ArrayList<>();
            streamEvents.add(streamEvent);
            EVENT_TYPES.put(eventType, streamEvents);
        } else {
            EVENT_TYPES.get(eventType).add(streamEvent);
        }
        COUNT_ID++;
    }

    public static StreamEvent findStreamEvent(int id) throws IllegalArgumentException {
        if (STREAM_EVENTS.containsKey(id)) {
            return STREAM_EVENTS.get(id);
        } else {
            displayError();
            return null;
        }
    }

    public static List<StreamEvent> getListStreamEvent(String eventType) {
        return EVENT_TYPES.get(eventType);
    }

    public static void deleteStreamEvent(int id) {
        if (STREAM_EVENTS.containsKey(id)) {
            StreamEvent streamEvent = STREAM_EVENTS.get(id);
            STREAM_EVENTS.remove(id);
            EVENT_TYPES.get(streamEvent.eventType()).remove(streamEvent);
        } else {
            displayError();
        }
    }

    public static void displayAllStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : STREAM_EVENTS.entrySet()) {
            System.out.printf("id : %d, eventType : %s, data : %s \n",
                    entry.getKey(), entry.getValue().eventType(), entry.getValue().data());
        }
    }
}
