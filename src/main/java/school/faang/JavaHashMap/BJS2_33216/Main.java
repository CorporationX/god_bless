package school.faang.JavaHashMap.BJS2_33216;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer, StreamEvent> events = new HashMap<>();
    static Map<String, List<StreamEvent>> eventData = new HashMap<>();

    public static void main(String[] args) {
        addEvent(1, "Регистрация", "Пользователь зарегистрировался на курсе по Java.");
        addEvent(2, "Начало урока", "Пользователь начал урок по объектно-ориентированному программированию.");
        addEvent(3, "Прохождение теста", "Пользователь завершил тест на знание базовых синтаксических конструкций.");
        addEvent(4, "Загрузка задания", "Пользователь загрузил задание по созданию классов и объектов.");
        addEvent(5, "Рецензия", "Преподаватель оставил отзыв на задание пользователя.");
        addEvent(6, "Рецензия", "Преподаватель отправил замечания по исправлению кода.");
        addEvent(7, "Ошибка компиляции", "Пользователь столкнулся с ошибкой компиляции при решении задачи.");
        addEvent(8, "Загрузка задания", "Пользователь загрузил исправленное задание.");
        addEvent(9, "Рецензия", "Пользователь присоединился к вебинару по тестированию программного обеспечения.");
        addEvent(10, "Начало урока", "Пользователь начал урок по Stream API.");
        addEvent(11, "Сдача проекта", "Пользователь сдал финальный проект для проверки.");
        addEvent(12, "Добавление комментария", "Пользователь оставил комментарий в обсуждении на форуме курса.");
        addEvent(13, "Обновление курса", "Курс получил обновление с новыми материалами по Java 17.");
        addEvent(14, "Решение задачи", "Пользователь решил задачу по использованию коллекций в Java.");
        addEvent(15, "Решение задачи", "Пользователь решил задачу по обработке исключений.");
        addEvent(16, "Начало проекта", "Пользователь начал работу над финальным проектом курса.");
        addEvent(17, "Создание аккаунта", "Пользователь создал аккаунт для доступа к платформе курсов.");
        addEvent(18, "Отправка уведомления", "Пользователь получил уведомление о новом уроке.");
        addEvent(19, "Начало урока", "Пользователь начал урок по паттернам проектирования.");
        addEvent(20, "Просмотр видео", "Пользователь просмотрел обучающее видео по использованию Stream API.");

        searchEventById(1);
        searchEventById(4);
        searchEventById(21);

        System.out.println("\n----------------------------------------------------------------------------------------------");

        searchEventByEventType("Залипал в потолок");
        searchEventByEventType("Начало урока");

        System.out.println("\n----------------------------------------------------------------------------------------------");

        removeEvent(5);
        removeEvent(18);

        System.out.println("\n----------------------------------------------------------------------------------------------");

        allEvents();
    }

    private static void addEvent(int id, String eventType, String data) {
        StreamEvent event = new StreamEvent(id, eventType, data);
        events.put(id, event);
        eventData.putIfAbsent(eventType, new ArrayList<>()).add(event);
    }

    private static void searchEventById(int id) {
        StreamEvent event = events.get(id);
        if (event == null) {
            System.out.println("\n События с таким id нет :" + id);
        } else {
            System.out.println("\n Id события: " + event.getId() +
                    "\n Тип события: " + event.getEventType() +
                    "\n Данные события: " + event.getData());
        }
    }

    private static void searchEventByEventType(String eventType) {
        List<StreamEvent> streamEventList = eventData.get(eventType);
        if (streamEventList == null || streamEventList.isEmpty()) {
            System.out.println("\n Списка событий с таким типом нет: " + eventType);
        } else {
            System.out.println(" Список событий событий с типом: " + eventType);
            for (StreamEvent streamEvent : streamEventList) {
                System.out.println("\n Id события: " + streamEvent.getId() +
                        "\n Данные события: " + streamEvent.getData());
            }
        }
    }

    private static void removeEvent(int id) {
        StreamEvent event = events.get(id);
        if (event != null) {
            events.remove(id);
            String eventType = event.getEventType();
            List<StreamEvent> streamEventList = eventData.get(eventType);
            if (streamEventList != null) {
                streamEventList.remove(event);
                System.out.println("Событие: " + eventType + " с id: " + id + " Удалено");
                if (streamEventList.isEmpty()) {
                    eventData.remove(eventType);
                    System.out.println("Список событий: " + eventType + " Удален");
                }
            }
        } else {
            System.out.println("Событие с таким ID не найдено.");
        }
    }

    private static void allEvents() {
        for (Map.Entry<String, List<StreamEvent>> entry : eventData.entrySet()) {
            System.out.println("\nТип события: " + entry.getKey());
            for (StreamEvent event : entry.getValue()) {
                System.out.println("  ID события: " + event.getId() +
                        ", Данные события: " + event.getData());
            }
        }
    }
}
