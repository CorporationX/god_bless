Представьте, что вам дали задание, вычислить сумму квадратов чисел от 1 до n — 1^2 + 2^2 + 3^2 + … n^2.

Вы, как опытный программист, решили оптимизировать задачу и выполнить её параллельно, 
используя паттерн Fan out – Fan in. 
Этот алгоритм разбивает большую задачу на меньшие подзадачи, 
которые обрабатываются параллельно на различных узлах, а затем объединяют результаты их выполнения.

Он состоит из 2 этапов:

Fan Out — данные распределяются по нескольким узлам, где каждый узел выполняет свою часть работы;

Fan In — результаты собираются обратно в единую систему.

1.  Вам дан класс SquareRequest, метод longTimeSquare которого вычисляет квадрат числа, 
и может это делать от 3 до 4 секунд. В конце “вычислений” longTimeSquare 
копит результат у некого ResultConsumer :

public class SquareRequest {

    private static final long MIN_TIMEOUT = 3000L;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(1000);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            resultConsumer.add(number * number);
        }
    }
}
ResultConsumer класс, который копит результат в AtomicLong переменной. 
Т.е. в конце алгоритма у нас там будет лежать сумма квадратов чисел от 1 до n.
AtomicLong здесь используется, что бы результат был корректный в многопоточной среде исполнения.

public class ResultConsumer {
private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
2. Реализуйте метод:

public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer)
Он должен запустить n CompletableFuture задач, и дождаться выполнения всех задач. 
После этого нужно вернуть результат у ResultConsumer

3. Реализуйте метод launch, который заполнит список элементами SquareRequest 
от 1 до 1000, а далее вызовет для них fanOutFanIn и выведет результат в консоль

Почему эта задача полезна?