package school.faang.catchingevents;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static final Map<Integer, StreamEvent> STREAM_EVENT = new HashMap<>();
    public static final Map<String, List<StreamEvent>> TYP_AND_LIST_EVENT = new HashMap<>();

    public static void main(String[] args) {
        Service service = new Service();
        StreamEvent event = new StreamEvent(1, "Concert", new Date());
        StreamEvent event1 = new StreamEvent(2, "Kino", new Date());
        StreamEvent event2 = new StreamEvent(3, "Dance", new Date());

        service.addEvent(event);
        service.addEvent(event2);
        service.addEvent(event1);

        System.out.println("Все события");
        service.printAllStreamEvents();

        System.out.println("События c id 1 :");
        System.out.println(service.searchedById(1));

        System.out.println("События типа 'Dance':");
        System.out.println(service.searchedByType("Dance"));

        service.removeStreamEventsById(2);
        System.out.println("Все события после удаления ID 1");
        service.printAllStreamEvents();
    }
}
