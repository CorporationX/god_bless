package faang.school.godbless.FanOut_FanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        launch(10);
    }

    public static void launch(int maxNumber) {
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i <= maxNumber; i++) {
            requests.add(new SquareRequest(i));
        }
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        System.out.println(SquareRequest.fanOutFanIn(requests, resultConsumer));
    }
}
