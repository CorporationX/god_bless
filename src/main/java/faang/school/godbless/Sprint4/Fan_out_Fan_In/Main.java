package faang.school.godbless.Sprint4.Fan_out_Fan_In;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static faang.school.godbless.Sprint4.Fan_out_Fan_In.SquareRequest.fanOutFanIn;

public class Main {
    public static void main(String[] args) {
        try {
            launch();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void launch() throws ExecutionException, InterruptedException {
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            requests.add(new SquareRequest((long) i));
        }
        System.out.println(fanOutFanIn(requests, new ResultConsumer(0L)));

    }
}
