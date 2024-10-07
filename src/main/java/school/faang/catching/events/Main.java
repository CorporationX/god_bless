package school.faang.catching.events;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Event teamCall = new Event(1, "Работа", "Созвон насчет фичи с разработчиками Агента");
        Event retro = new Event(2, "Работа", "Ретро с командой");
        Event gym = new Event(3, "Спорт", "Поход в зал");
        Event running = new Event(4, "Спорт", "Бег");
        Event meeting = new Event(5, "Личная жизнь", "Увидеться с друзьями");

        StreamEvent eventStream = new StreamEvent();
        eventStream.add(teamCall);
        eventStream.add(retro);
        eventStream.add(gym);
        eventStream.add(running);
        eventStream.add(meeting);
        eventStream.printEvents();

        System.out.println("Событие с id 1: " + eventStream.get(1));
        List<Event> events = eventStream.get("Работа");
        events.forEach(System.out::println);
        eventStream.remove(4);
        eventStream.printEvents();
    }
}
