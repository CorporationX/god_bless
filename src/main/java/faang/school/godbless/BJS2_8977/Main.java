package faang.school.godbless.BJS2_8977;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private HashMap<Integer, StreamEvent> mapIdEvent = new HashMap<>();
    private HashMap<String, List<StreamEvent>> mapEventsType = new HashMap<>();

    public void addStreamEvent(int id, String eventType, String data) {
        checkInputValidation(id, eventType, data);

        if(mapIdEvent.containsKey(id)) throwIllegalArgument("ID событи€ уже существует");
        mapIdEvent.put(id, createStreamEvent(id, eventType, data));

        updateMapEventsType(id, eventType, data);
    }

    void updateMapEventsType(int id, String eventType, String data) {
        checkInputValidation(id, eventType, data);
        mapEventsType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(createStreamEvent(id, eventType, data));
    }

    public StreamEvent findEventTypeById(int id) {
        checkInputId(id);

        StreamEvent streamEvent = mapIdEvent.get(id);
        if (streamEvent == null) throwIllegalArgument("Ќе найдено событие");
        return streamEvent;
    }

    public List<StreamEvent> findListEventTypeByEventType(String eventType) {
        checkInputString(eventType);

        List<StreamEvent> streamsEvent = mapEventsType.get(eventType);

        if (streamsEvent == null) throwIllegalArgument("ѕо такому типу событи€ не найдено списка событий");

        return streamsEvent;
    }

    public void deleteEventById(int id) {
        checkInputId(id);

        StreamEvent streamEvent = mapIdEvent.get(id);
        if (streamEvent == null) throwIllegalArgument("ѕо такому id не найдено событие");
        mapIdEvent.remove(id);

        List<StreamEvent> streamsEventList = mapEventsType.get(streamEvent.getEventType());
        if (streamsEventList == null)
            throwIllegalArgument("ѕо такому типу событи€ не найдено списка событий");
        mapEventsType.remove(streamEvent.getEventType());
    }

    public void printStreamEventList(){
        for (Map.Entry<Integer, StreamEvent>  list: mapIdEvent.entrySet()) {
            System.out.println(list.getValue());
        }
    }

    public void printEventsList(){
        for (Map.Entry<String, List<StreamEvent>> list: mapEventsType.entrySet()) {
            System.out.println(list.getKey() + list.getValue());
        }
    }
    private StreamEvent createStreamEvent(int id, String eventType, String data) {
        return new StreamEvent(id, eventType, data);
    }

    private void checkInputValidation(int id, String eventType, String data) {
        checkInputId(id);
        checkInputString(eventType);
        checkInputString(data);
    }

    private void checkInputString(String input) {
        if (input == null || input.trim().isEmpty())
            throw new IllegalArgumentException("¬ход€щее значение невалидно");
    }

    private void checkInputId(int id) {
        if (id < 0) throwIllegalArgument("Id не может быть меньше 0");
    }

    private void throwIllegalArgument(String error) {
        throw new IllegalArgumentException(error);
    }
}
