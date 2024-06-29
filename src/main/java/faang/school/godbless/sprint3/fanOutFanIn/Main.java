package faang.school.godbless.sprint3.fanOutFanIn;

import java.util.List;

public class Main {

    public static final int NUM_SIZE = 4;
    public static final long START_CAPACITY = 0L;

    public static void main(String[] args) {
        List<SquareRequest> launchList = SquareRequest.launch(NUM_SIZE);

        ResultConsumer resultConsumer = new ResultConsumer(START_CAPACITY);

        Long sum = SquareRequest.fanOutFanIn(launchList, resultConsumer);
    }
}
