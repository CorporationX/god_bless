package faang.school.godbless.BJS2_5131;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StreamEventValues eventValues = getStreamEventValues();
        System.out.println("добавляем все события");
        eventValues.printAllEvents();

        StreamEvent newStreamEventBank = eventValues.getEventById(1);
        System.out.println("выводим событие с айди 1");
        System.out.println(newStreamEventBank.toString());

        List<StreamEvent> eventsByType = eventValues.getEventsByType("message");
        System.out.println("выводим события с типом message");
        System.out.println(eventsByType.toString());

        try {
            eventValues.removeStream(1);
        } catch (IllegalArgumentException e) {
            System.out.println("удаляем событие из потока: " + e);
        }
        System.out.println("удаляем событие");
        eventValues.printAllEvents();


    }

    private static StreamEventValues getStreamEventValues() {

        StreamEvent streamEventBank = new StreamEvent(1, "update", "salary");
        StreamEvent streamEventMessenger1 = new StreamEvent(2, "message", "Hello mike!");
        StreamEvent streamEventMessenger2 = new StreamEvent(3, "message", "How are you doing?");
        StreamEvent streamEventVideoHosting1 = new StreamEvent(4, "notice", "new video");
        StreamEvent streamEventVideoHosting2 = new StreamEvent(5, "notice", "new shorts video");

        StreamEventValues eventValues = new StreamEventValues();

        try {
            eventValues.addStream(streamEventBank);
            eventValues.addStream(streamEventMessenger1);
            eventValues.addStream(streamEventMessenger2);
            eventValues.addStream(streamEventVideoHosting1);
            eventValues.addStream(streamEventVideoHosting2);
        } catch (IllegalArgumentException e) {
            System.out.println("добавление событий в поток:" + e);
        }

        return eventValues;
    }
}
