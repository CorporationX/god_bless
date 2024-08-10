package faang.school.godbless;

public class Main {

    public static void main(String[] args) {
        StreamEventService streamEventService = new StreamEventService();

        try {
            StreamEvent event1 = new StreamEvent("LOGIN", "User logged in");

            streamEventService.addEvent(event1);
            streamEventService.addEvent(new StreamEvent("LOGOUT", "User logged out"));
            streamEventService.addEvent(new StreamEvent("LOGIN", "User logged in"));
            streamEventService.addEvent(new StreamEvent("ERROR", "User has an error"));

            streamEventService.printAllEvents();

            System.out.println("Event with ID " + event1.getId() + ":\n    " + streamEventService.getEventById(event1.getId()));
            System.out.println("Events of type LOGIN: ");
            streamEventService.getEventsByType("LOGIN").forEach(event -> System.out.println("    " + event));

            streamEventService.removeEventById(event1.getId());

            streamEventService.printAllEvents();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}