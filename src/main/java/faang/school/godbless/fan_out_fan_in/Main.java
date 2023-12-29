package faang.school.godbless.fan_out_fan_in;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    private static final int SIZE_LIST = 1000;

    public static void main(String[] args) {
        launch();
    }


    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size()); //хотел использовать кэшПул, мне кажется он тут в тему! если у меня 4 ядра на компе,
        // то смысл создавать 1000 потоков! но в заданий исп. размер списка на 1000 потоков фиксированный? как думаете?

        //fan - out           создаем список будущих асинхрон. задач
        List<CompletableFuture<Void>> futureTasks = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService))
                .toList();                          //runAsync не возвращает рез-т операций, но возвращает Комплитбл Фючерс

        //fan -in
        CompletableFuture.allOf(futureTasks.toArray(new CompletableFuture[0])).join(); //заполняет новый массив из списка (задач фьючеров), и передается в СF.allOf,СF не сохраняятся
        executorService.shutdown();                                                   //в переменную, он для синхрона завершения всех задач, .join на рез-те allOf
        return resultConsumer.getSumOfSquaredNumbers().get();                        //заставляет ожидать текущий поток пока условие не выполнено.
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 1; i <= SIZE_LIST; i++) {
            requests.add(new SquareRequest(i));
        }
        System.out.println("Вызываем метод FanFan " + fanOutFanIn(requests, new ResultConsumer(0L)));
    }
}

@Getter
@AllArgsConstructor
class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;

    private final long number;

    public Long longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(1000);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return resultConsumer.add(number * number);
        }
    }
}


@Getter
class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}