package school.faang.m1.concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) throws InterruptedException {
        CollaborativeDocument doc = new CollaborativeDocument();

        DocumentSection intro = new DocumentSection("intro", doc);
        DocumentSection api = new DocumentSection("api", doc);
        DocumentSection faq = new DocumentSection("faq", doc);

        ExecutorService pool = Executors.newFixedThreadPool(
                Math.min(8, Math.max(2, Runtime.getRuntime().availableProcessors())));

        AtomicInteger counter = new AtomicInteger();

        // Запускаем по нескольку обработчиков на каждую секцию — имитируем совместное редактирование
        pool.submit(named("intro-worker-" + counter.incrementAndGet(),
                new DocumentSectionProcessor(intro, List.of("Welcome ", "to ", "GoogleDocs! "), 10)));
        pool.submit(named("intro-worker-" + counter.incrementAndGet(),
                new DocumentSectionProcessor(intro, List.of("Collaborate ", "safely. "), 15)));

        pool.submit(named("api-worker-" + counter.incrementAndGet(),
                new DocumentSectionProcessor(api, List.of("GET /docs ", "POST /docs "), 12)));
        pool.submit(named("api-worker-" + counter.incrementAndGet(),
                new DocumentSectionProcessor(api, List.of("PUT /docs/{id} ", "DELETE /docs/{id} "), 8)));

        pool.submit(named("faq-worker-" + counter.incrementAndGet(),
                new DocumentSectionProcessor(faq, List.of("Q: Is it thread-safe? ", "A: Yes. "), 5)));
        pool.submit(named("faq-worker-" + counter.incrementAndGet(),
                new DocumentSectionProcessor(faq, List.of("Q: Lock-free? ", "A: Per-key atomic ops. "), 7)));

        pool.shutdown();
        if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
            pool.shutdownNow();
        }


        // Итог
        System.out.println("=== Final sections ===");
        doc.snapshot().forEach((k, v) -> System.out.println(k + " => " + v));
    }

    static Runnable named(String threadName, Runnable r) {
        return () -> {
            String old = Thread.currentThread().getName();
            Thread.currentThread().setName(threadName);
            try {
                r.run();
            } finally {
                Thread.currentThread().setName(old);
            }
        };
    }
}