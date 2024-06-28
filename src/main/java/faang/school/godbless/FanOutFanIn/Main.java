package faang.school.godbless.FanOutFanIn;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<SquareRequest> requests = launch();

        ResultConsumer resultConsumer = new ResultConsumer(0L);

        long result = SquareRequest.fanOutFanIn(requests, resultConsumer);

        System.out.println("Sum of squares from 1 to 1000 " + result);
    }

    public static List<SquareRequest> launch() {
        return IntStream.rangeClosed(1, 1000)
                .parallel()  // Параллельный стрим
                .mapToObj(i -> new SquareRequest((long) i))
                .collect(Collectors.toList());
    }
}
