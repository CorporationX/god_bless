package faang.school.godbless.FanOutFanIn;
import faang.school.godbless.FanOutFanIn.SquareRequest;

import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;

import javax.xml.transform.Result;
import java.util.ArrayList;
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
        List<SquareRequest> requests = IntStream.rangeClosed(1, 1000)
                .parallel()  // Параллельный стрим
                .mapToObj(i -> new SquareRequest((long) i))
                .collect(Collectors.toList());
        return requests;
    }


}
