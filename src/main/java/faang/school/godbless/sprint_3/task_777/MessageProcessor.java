package faang.school.godbless.sprint_3.task_777;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        boolean isValid = true;
        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                isValid = false;
            }
        }
        return isValid;
    }
}

/*Цель: Создайте собственный функциональный интерфейс MessageFilter и класс MessageProcessor,
который будет использовать список объектов MessageFilter для обработки сообщений.

Требования:

Создайте функциональный интерфейс MessageFilter с методом filter, который принимает строку (сообщение)
и возвращает boolean (применяется фильтр или нет);

Создайте класс MessageProcessor с методом processMessage;

Метод processMessage должен принимать входящее сообщение и список объектов MessageFilter для обработки сообщения;

Создайте несколько фильтров с помощью лямбда-выражений и добавьте их в список;

Протестируйте вашу систему, обрабатывая несколько входящих сообщений с разными фильтрами.*/

