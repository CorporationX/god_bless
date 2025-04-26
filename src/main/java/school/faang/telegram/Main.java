package school.faang.telegram;

//Описание
//
//Вы разрабатываете Telegram-бота, который должен обрабатывать сообщения от пользователей и отправлять ответы. Но чтобы
// избежать блокировки от серверов Telegram, нужно ограничить количество запросов к API. Например, бот должен отправлять
// не более 5 запросов в секунду. Ваша задача — реализовать механизм управления количеством запросов с учетом этого
// ограничения.
//
//Требования задачи:
//        1. Создать класс TelegramBot с приватными полями:
//
//REQUEST_LIMIT — максимальное количество запросов в секунду.
//
//        requestCounter — счетчик запросов в текущую секунду.
//
//        lastRequestTime — время последнего запроса.
//
//2. Создать конструктор: Инициализировать поля requestCounter и lastRequestTime (например, установите текущее время при
// создании объекта).
//
//        3. Создать метод sendMessage(String message):
//
//Этот метод будет имитировать отправку сообщение через API Telegram.
//
//В начале метода получите текущее время.
//
//Вычислите, сколько времени прошло с момента последнего запроса.
//
//4. Проверить лимиты:
//
//Если с последнего запроса прошло меньше секунды, увеличьте requestCounter на 1.
//
//Если requestCounter превышает REQUEST_LIMIT, подождите до конца текущей секунды, прежде чем отправить сообщение.
//
//5. Обнуление счетчика: Если прошедшее время с момента последнего запроса больше или равно секунде, обнулите
// requestCounter и обновите lastRequestTime на текущее время.
//
//        6. После выполнения всех проверок, “отправьте” сообщение через API.
//
//7. Создать метод main в классе Main:
//
//Создайте объект бота и запустите несколько потоков, каждый из которых будет пытаться отправить сообщение.
//
//После завершения всех потоков, выведите сообщение о том, что задача выполнена.

import lombok.extern.slf4j.Slf4j;
import school.WaitUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(telegramBot::activateBot);
        for (Message message : getMessagesData(100)) {
            executorService.submit(() -> telegramBot.sendMessage(message));
        }
        executorService.submit(telegramBot::deactivateBot);
        WaitUtils.shutdownExecutorWithWait(executorService, 1, TimeUnit.MINUTES);
    }

    private static List<Message> getMessagesData(int count) {
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            messages.add(new Message("Message #%d".formatted(i + 1)));
        }
        return messages;
    }
}
