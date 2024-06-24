package faang.school.godbless.fanoutfanin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class SquareRequestManager {
    private static final long NUMBERS_OF_NUMBERS = 1000;
    private static final int TREAD_POOL_NUMBERS = 10;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(TREAD_POOL_NUMBERS);
    private static final List<CompletableFuture<List<SquareRequest>>> CACHE = new ArrayList<>();
    private static final long COUNT_OF_NUMBERS_PER_STREAM = NUMBERS_OF_NUMBERS / TREAD_POOL_NUMBERS;
    private static final long THE_REMAINDER_OF_THE_DIVISION = NUMBERS_OF_NUMBERS % TREAD_POOL_NUMBERS;
    private static final ExecutorService POOL_FOR_ELEMENTS = Executors.newFixedThreadPool((int) NUMBERS_OF_NUMBERS);

    private Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> fanOutFanIn = new ArrayList<>();
        for (SquareRequest request : requests) {
            fanOutFanIn.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), POOL_FOR_ELEMENTS));
        }
        fanOutFanIn.forEach(CompletableFuture::join);
        POOL_FOR_ELEMENTS.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public void launch() {
        for (long i = 0; i < TREAD_POOL_NUMBERS; i++) {
            long numberRange = i;
            CACHE.add(CompletableFuture.supplyAsync(() -> getSquareRequest(numberRange), EXECUTOR_SERVICE));
        }
        if (THE_REMAINDER_OF_THE_DIVISION != 0L) {
            CACHE.add(CompletableFuture.supplyAsync(SquareRequestManager::TheNumbersIsNotAMultipileOfTheThreadPool, EXECUTOR_SERVICE));
        }
        EXECUTOR_SERVICE.shutdown();
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        System.out.println(fanOutFanIn(getASheetFromCACHE(), resultConsumer));
    }

    private List<SquareRequest> getASheetFromCACHE() {
        return CACHE.stream()
                .map(CompletableFuture::join)
                .flatMap(Collection::stream)
                .toList();
    }

    private static List<SquareRequest> getSquareRequest(long id) {
        long numberRangeStart = id * COUNT_OF_NUMBERS_PER_STREAM + 1;
        long numberRangeEnd = ((id + 1) * COUNT_OF_NUMBERS_PER_STREAM) + 1;
        return PutSquareRequestInSheet(numberRangeStart, numberRangeEnd);
    }

    private static List<SquareRequest> TheNumbersIsNotAMultipileOfTheThreadPool() {
        long numberRangeStart = (long) SquareRequestManager.TREAD_POOL_NUMBERS * COUNT_OF_NUMBERS_PER_STREAM + 1;
        long numberRangeEnd = THE_REMAINDER_OF_THE_DIVISION + numberRangeStart;
        return PutSquareRequestInSheet(numberRangeStart, numberRangeEnd);
    }

    private static List<SquareRequest> PutSquareRequestInSheet(long numberRangeStart, long numberRangeEnd) {
        return LongStream.range(numberRangeStart, numberRangeEnd)
                .mapToObj(SquareRequest::new)
                .toList();
    }
}
