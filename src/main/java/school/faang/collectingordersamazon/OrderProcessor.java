package school.faang.collectingordersamazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderProcessor {
    // Потокобезопасный счетчик для общего количества обработанных заказов
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);}