package faang.school.godbless.fanoutfanin;

import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.fanoutfanin.FanOutFanIn.*;

public class Launcher {
    public static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }
        Long result = fanOutFanIn(requests, resultConsumer);
        System.out.println(result);
    }
}