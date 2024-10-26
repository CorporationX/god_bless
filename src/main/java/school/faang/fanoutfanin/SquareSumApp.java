package school.faang.fanoutfanin;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class SquareSumApp {
    public static void launch() {
        List<SquareRequest> requests = LongStream.rangeClosed(1, 1000)
                .mapToObj(SquareRequest::new)
                .collect(Collectors.toList());

        ResultConsumer resultConsumer = new ResultConsumer(0L);

        Long totalSum = SquareCalculator.fanOutFanIn(requests, resultConsumer);

        System.out.println("The sum of squares from 1 to 1000 is: " + totalSum);
    }

    public static void main(String[] args) {
        launch();
    }
}

