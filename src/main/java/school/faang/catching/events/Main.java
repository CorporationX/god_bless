package school.faang.catching.events;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Event event1 = new Event(1, "Работа", "Созвон насчет фичи с разработчиками Агента");
        Event event2 = new Event(2, "Работа", "Ретро с командой");
        Event event3 = new Event(3, "Спорт", "Поход в зал");
        Event event4 = new Event(4, "Спорт", "Бег");
        Event event5 = new Event(5, "Личная жизнь", "Увидеться с друзьями");

        StreamEvent eventStream = new StreamEvent();
        eventStream.add(event1);
        eventStream.add(event2);
        eventStream.add(event3);
        eventStream.add(event4);
        eventStream.add(event5);
        eventStream.printEvents();

        //получаем по id
        System.out.println("Событие с id 1: " + eventStream.get(1));

        //получаем по типу
        List<Event> events = eventStream.get("Работа");
        events.forEach(System.out::println);

        //удаление
        eventStream.remove(4);
        eventStream.printEvents();
    }
}
