package faang.school.godbless.BJS2_6037;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<SquareRequest> requests = List.of(new SquareRequest(2L), new SquareRequest(3L), new SquareRequest(4L));
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        Long result = SquareRequest.fanOutFabIn(requests, resultConsumer);
        System.out.println(result);
        SquareRequest.launch();

    }
}
