package faang.school.godbless.Sprint4.Fan_out_Fan_In;

import java.util.List;
import java.util.concurrent.*;

public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    private Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public static long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newCachedThreadPool();
        Future future = null;
        for (SquareRequest request : requests) {
            future = executors.submit(() -> {
                request.longTimeSquare(resultConsumer);
                //System.out.println(resultConsumer.getSumOfSquaredNumbers().get() + " for num = " + request.number);
            });
        }
        future.get();


        executors.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
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
