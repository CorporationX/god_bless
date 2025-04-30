package school.faang.fan_calculations;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    private static void launch() {
        List<SquareRequest> squareRequests = LongStream.range(0, 1000).mapToObj(SquareRequest::new).toList();


    }
}
