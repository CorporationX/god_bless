package tasks.bjs2_33307;

public class Main {
    public static void main(String[] args) {
        EventController controller = new EventController(100);
        controller.showEvents();
        controller.showEventsGroupedByEventType();
        controller.addEvent(EventType.ADD_COMMENT);
        controller.showEventsByType(EventType.ADD_POST);
        controller.showEventById(55);
        controller.showEventById(199);
        controller.removeEvent(55);
        controller.removeEvent(199);
        controller.showEvents();
    }
}
