package school.faang.catchevent;

import java.util.*;

public class StreamEventService {

    public void addStreamEvent(StreamEvent streamEvent, Map<String, StreamEvent> events, Map<String, List<StreamEvent>> groupedEvents){
        String id = UUID.randomUUID().toString();
        streamEvent.setId(id);
        events.put(id, streamEvent);

        String eventType = streamEvent.getEventType();

        groupedEvents.putIfAbsent(eventType, new ArrayList<>());
        groupedEvents.get(eventType).add(streamEvent);
    }

    public void updateMapsByAddingEvent(Map<String, StreamEvent> events, Map<String, List<StreamEvent>> groupedEvents){
        for(Map.Entry<String, StreamEvent> entry : events.entrySet()){
            if(events.size() > groupedEvents.size()){
                StreamEvent event = entry.getValue();
                if (!groupedEvents.containsKey(event.getEventType())){
                    groupedEvents.putIfAbsent(event.getEventType(), new ArrayList<>());
                    groupedEvents.get(event.getEventType()).add(event);
                }
            }
        }
    }

    public void deleteEventsFromBothMaps(String id, Map<String, StreamEvent> events, Map<String, List<StreamEvent>> groupedEvents) {
        StreamEvent event = events.remove(id);
        String eventType = event.getEventType();
        List<StreamEvent> eventList = groupedEvents.get(eventType);
        eventList.remove(event);
    }

    public Optional<StreamEvent> findStreamEventById(String id, Map<String, StreamEvent> events){
        return Optional.ofNullable(events.get(id));
    }

    public List<StreamEvent> findListOfStreamEventsByEventType(String eventType, Map<String, List<StreamEvent>> groupedEvents){
        return groupedEvents.get(eventType);
    }

    public List<StreamEvent> showAllEvents(Map<String, StreamEvent> events){
        List<StreamEvent> allEvents = new ArrayList<>();

        for(Map.Entry<String, StreamEvent> entry : events.entrySet()){
            StreamEvent streamEvent = entry.getValue();
            allEvents.add(new StreamEvent(streamEvent.getId(), streamEvent.getEventType(), streamEvent.getData()));
        }

        return allEvents;
    }
}
