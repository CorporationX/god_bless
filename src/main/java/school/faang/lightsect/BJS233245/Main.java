package school.faang.lightsect.BJS233245;

public class Main {
    public static void main(String[] args) {
        Event.addEvent(new StreamEvent(1, "Работа", "Любая работа"));
        System.out.println(Event.LIST_OF_EVENT_WITH_TYPE);
        Event.printAllEvents();

        System.out.println();
        Event.addEvent(new StreamEvent(2, "Путешествие", "Любимое путешествие"));
        System.out.println(Event.LIST_OF_EVENT_WITH_TYPE);
        Event.printAllEvents();

        System.out.println();
        Event.addEvent(new StreamEvent(3, "Отдых", "Любимый отдых"));
        System.out.println(Event.LIST_OF_EVENT_WITH_TYPE);
        Event.printAllEvents();

        System.out.println();
        System.out.println(Event.getEventById(2));

        Event.deleteStreamById(1);
        System.out.println();
        System.out.println(Event.LIST_OF_EVENT_WITH_TYPE);
        Event.printAllEvents();

        System.out.println();
        System.out.println(Event.searchStreamEvenByType("Путешествие"));

        Event.printAllEvents();
    }
}
