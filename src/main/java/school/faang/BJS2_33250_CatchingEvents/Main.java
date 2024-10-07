package school.faang.BJS2_33250_CatchingEvents;

public class Main {
    private static final StreamEventService STREAM_SERVICE = new StreamEventService();

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent("INFO", "First event data");
        StreamEvent event2 = new StreamEvent("ERROR", "Second event data");
        StreamEvent event3 = new StreamEvent("INFO", "Third event data");
        StreamEvent event4 = new StreamEvent("DEBUG", "Fourth event data");
        StreamEvent event5 = new StreamEvent("ERROR", "Fifth event data");

        STREAM_SERVICE.addEvent(event1);
        STREAM_SERVICE.addEvent(event2);
        STREAM_SERVICE.addEvent(event3);
        STREAM_SERVICE.addEvent(event4);
        STREAM_SERVICE.addEvent(event5);

        System.out.println("All events:");
        STREAM_SERVICE.printAllEvents();

        System.out.println("\nEvent with id 1:");
        System.out.println(STREAM_SERVICE.getEvent(1));

        System.out.println("\nEvents with type 'ERROR':");
        System.out.println(STREAM_SERVICE.getEvents("ERROR"));

        System.out.println("\nRemoving event with id 2");
        STREAM_SERVICE.removeEvent(2);

        System.out.println("\nAll events after removing event with id 2:");
        STREAM_SERVICE.printAllEvents();
    }
}
