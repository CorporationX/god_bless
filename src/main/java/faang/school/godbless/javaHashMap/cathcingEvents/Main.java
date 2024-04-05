package faang.school.godbless.javaHashMap.cathcingEvents;

public class Main {

    public static void main(String[] args) {
        EventsManager eventsManager = new EventsManager();

        System.out.println("Stream events manager check");

        System.out.println("Events base state at start point:");
        eventsManager.printAllEventsInfo();


        System.out.println("\n\nAdding some new events:");
        eventsManager.addNewEvent(1, "click", "Clicked on homepage button");
        eventsManager.addNewEvent(2, "hover", "Hovered over product image");
        eventsManager.addNewEvent(3, "scroll", "Scrolled down the page");
        eventsManager.addNewEvent(4, "click", "Clicked on 'Add to Cart'");
        eventsManager.addNewEvent(5, "hover", "Hovered over navigation menu");

        System.out.println("Events base state at this point:");
        eventsManager.printAllEventsInfo();


        System.out.println("\n\nGetting event by id (3) :");
        System.out.println(eventsManager.getEventById(3));


        System.out.println("\n\nGetting events by type (hover) :");
        System.out.println(eventsManager.getStreamEventsByType("hover"));


        System.out.println("\n\nRemoving event by id (3) :");
        eventsManager.removeEvent(3);

        System.out.println("Events base state at this point");
        eventsManager.printAllEventsInfo();

        System.out.println("\n\nDone.");
    }
}
