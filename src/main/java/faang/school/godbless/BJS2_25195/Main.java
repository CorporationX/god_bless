package faang.school.godbless.BJS2_25195;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    //SquareRequest - нужен для того чтобы передать в него число и у него есть метод longTimeSquare который сохраняет результат
    // в переменную AtomicLong sumOfSquaredNumbers объекта ResultConsumer resultConsumer с помощью метода add.

    //1. Создать лист из 1000 объектов SquareRequest
    //2. Вызвать асинхронно 1000 задач по выполнению метода longTimeSquare у каждого объекта SquareRequest из списка
    //3. Дождаться завершения всех задач
    //4. Вывести результат в консоль


    /*
    1. Заполняет список элементами SquareRequest от 1 до 1000
    2.Вызывает для каждого элемента для них fanOutFanIn и выведет результат в консоль
    */
    public static void launch(int squareStartNumber, int squareEndNumber) {
        List<SquareRequest> SquareRequestNumbers = new ArrayList<>();

        for (int i = squareStartNumber; i <= squareEndNumber; i++) {
            SquareRequestNumbers.add(new SquareRequest(Long.valueOf(i)));
        }

        ResultConsumer resultConsumer = new ResultConsumer(0L);
        System.out.println(fanOutFanIn(SquareRequestNumbers, resultConsumer));
    }

    private static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        try {
            allFutures.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return resultConsumer.getSum();
    }

    public static void main(String[] args) {

        int squareStartNumber = 1;
        int squareEndNumber = 1000;

        launch(squareStartNumber, squareEndNumber);
    }
}
