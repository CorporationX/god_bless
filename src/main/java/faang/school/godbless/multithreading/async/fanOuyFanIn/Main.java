package faang.school.godbless.multithreading.async.fanOuyFanIn;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        launch(1, 100);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        requests.parallelStream().forEach((request -> request.longTimeSquare(resultConsumer)));
        return resultConsumer.get();
    }

    public static void launch(long begin, long end) {
        ResultConsumer consumer = new ResultConsumer(0L);
        List<SquareRequest> squares = new ArrayList<>();

        for (long i = begin; i < end; i++) {
            squares.add(new SquareRequest(i));
        }

        System.out.println(fanOutFanIn(squares, consumer));
    }
}
