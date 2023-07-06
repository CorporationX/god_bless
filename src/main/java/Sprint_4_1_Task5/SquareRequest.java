package Sprint_4_1_Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

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
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer){
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        CompletableFuture.runAsync( () -> {
            requests.forEach(request -> request.longTimeSquare(resultConsumer));
        });
    }
    public void launch(){
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }
        for (SquareRequest request : requests) {
            fanOutFanIn(requests, resultConsumer);
        }

    }

    public static void main(String[] args) {


        CompletableFuture.allOf().join();
    }
}
