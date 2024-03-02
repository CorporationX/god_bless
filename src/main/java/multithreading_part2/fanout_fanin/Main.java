package multithreading_part2.fanout_fanin;

import multithreadingPart1.armyHeroes.Swordsman;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static List<SquareRequest> launch() {
        List<SquareRequest> list = new ArrayList<>();
        for (long i = 1; i <= 1000; i++) {
            list.add(new SquareRequest(i));
        }
        return list;
    }

    public static Long fanOutFanIn(List<SquareRequest> requestList, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requestList.size());
        List<CompletableFuture<?>> futures = new ArrayList<>();
        for (SquareRequest square : requestList) {
            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> square.longTimeSquare(resultConsumer), executorService);
            futures.add(voidCompletableFuture);
        }
        executorService.shutdown();
        CompletableFuture<Void> allFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        allFuture.join();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void main(String[] args) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requestList = launch();
        Long reuslt = fanOutFanIn(requestList, resultConsumer);
        System.out.println(reuslt);
    }
}
