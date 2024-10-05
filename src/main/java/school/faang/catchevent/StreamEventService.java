package school.faang.catchevent;

import java.util.*;

public class StreamEventService {

    public void addStreamEvent(StreamEvent streamEvent, Map<Integer, StreamEvent> events){
        streamEvent.setId(events.size() + 1);
        events.put(streamEvent.getId(), streamEvent);
    }

    public void updateMapsByAddingEvent(Map<Integer, StreamEvent> events, Map<String, List<StreamEvent>> groupedEvents){
        for(Map.Entry<Integer, StreamEvent> entry : events.entrySet()){
            if(events.size() > groupedEvents.size()){
                StreamEvent event = entry.getValue();
                if (!groupedEvents.containsKey(event.getEventType())){
                    groupedEvents.putIfAbsent(event.getEventType(), new ArrayList<>());
                    groupedEvents.get(event.getEventType()).add(event);
                }
            }
        }
    }

    public void deleteEventsFromBothMaps(Integer id, Map<Integer, StreamEvent> events, Map<String, List<StreamEvent>> groupedEvents) {
        StreamEvent event = events.remove(id);
        String eventType = event.getEventType();
        List<StreamEvent> eventList = groupedEvents.get(eventType);

        Iterator<StreamEvent> iterator = eventList.iterator();
        while (iterator.hasNext()) {
            StreamEvent currentEvent = iterator.next();

            if (Objects.equals(currentEvent.getId(), id)) {
                iterator.remove();
                break;
            }
        }
        if (eventList.isEmpty()) {
            groupedEvents.remove(eventType);
        }
    }

    public Optional<StreamEvent> findStreamEventById(Integer id, Map<Integer, StreamEvent> events){
        return Optional.ofNullable(events.get(id));
    }

    public Optional<List<StreamEvent>> findListOfStreamEventsByEventType(String eventType, Map<String, List<StreamEvent>> groupedEvents){
        return Optional.ofNullable(groupedEvents.get(eventType));
    }

    public List<StreamEvent> showAllEvents(Map<Integer, StreamEvent> events){
        List<StreamEvent> allEvents = new ArrayList<>();

        for(Map.Entry<Integer, StreamEvent> entry : events.entrySet()){
            StreamEvent streamEvent = entry.getValue();
            allEvents.add(new StreamEvent(streamEvent.getId(), streamEvent.getEventType(), streamEvent.getData()));
        }

        return allEvents;
    }
}
