package faang.school.godbless.Sprint4Future.FanInFanOut;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<SquareRequest> requests = new ArrayList<>();

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public void launch() {
        for (long i = 1; i < 1000; i++) {
            requests.add(new SquareRequest(i));
        }
        fanOutFanIn(requests, new ResultConsumer(1000L));
    }
}
