package faang.school.godbless.BJS2_6171;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SumController {
    public synchronized int sumElementsFromList(List<CompletableFuture<Integer>> inputList) {
        return inputList.stream().mapToInt(CompletableFuture::join).sum();
    }
}
