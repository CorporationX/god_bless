package school.faang.lightsect.BJS233245;

public class Main {
    public static void main(String[] args) {
        Event event = new Event();
        event.addEvent(new StreamEvent(1, "Работа", "Любая работа"));
        System.out.println(Event.LIST_OF_EVENT_WITH_TYPE);
        event.printAllEvents();

        System.out.println();
        event.addEvent(new StreamEvent(2, "Путешествие", "Любимое путешествие"));
        System.out.println(Event.LIST_OF_EVENT_WITH_TYPE);
        event.printAllEvents();

        System.out.println();
        event.addEvent(new StreamEvent(3, "Отдых", "Любимый отдых"));
        System.out.println(Event.LIST_OF_EVENT_WITH_TYPE);
        event.printAllEvents();

        System.out.println();
        System.out.println(event.getEventById(2));

        event.deleteStreamById(1);
        System.out.println();
        System.out.println(Event.LIST_OF_EVENT_WITH_TYPE);
        event.printAllEvents();

        System.out.println();
        System.out.println(event.searchStreamEvenByType("Путешествие"));

        event.printAllEvents();
    }
}
