package school.faang.multithreading_parallelism_thread.bgs2_91238;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.stream.IntStream.rangeClosed;

public class MailSender {
    private static final int NUMBER_OF_THREADS = 5;
    private static final int NUMBER_OF_MAIL_LETTERS = 1000;

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Function<Integer, Integer>> calculateBatchSize =
                (numberOfThreads, numberOfMailLetters) -> {
                    int batchSize = numberOfMailLetters / numberOfThreads;
                    int remainder = numberOfMailLetters % numberOfThreads;

                    return batchNumber -> batchNumber < numberOfThreads
                            ? batchNumber * batchSize
                            : batchNumber * batchSize + remainder;
                };

        Function<Integer, Integer> getBatchSize =
                calculateBatchSize.apply(NUMBER_OF_THREADS, NUMBER_OF_MAIL_LETTERS);

        Consumer<Thread> threadJoin = t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.print(e.getMessage());
            }
        };

        List<Thread> taksForLow = rangeClosed(0, NUMBER_OF_THREADS - 1)
                .mapToObj(item -> new Thread(new SenderRunnable(getBatchSize.apply(item),
                                                                getBatchSize.apply(item + 1)),
                                       "Thread № " + item))
                .toList();

        taksForLow.stream()
                .peek(itemThread -> {
                    itemThread.start();
                    System.out.print("Старт потока " + itemThread.getName() + " \n");
                })
                .toList()
                .forEach(threadJoin);

        System.out.print("Все письма отправлены");
    }
}