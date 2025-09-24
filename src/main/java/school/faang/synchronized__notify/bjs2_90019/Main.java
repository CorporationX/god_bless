package school.faang.synchronized__notify.bjs2_90019;

import lombok.extern.slf4j.Slf4j;
import school.faang.multithreading_parallelism_thread.bgs2_89758.CheckedRunnable;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static school.faang.utils.Utils.pickRandom;
import static school.faang.utils.Utils.runAwaitAndShutdown;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 1000;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager videoManager = new VideoManager();

        List<Video> videos = List.of(
                new Video(1, "Обзор Java Streams"),
                new Video(2, "Lambda-выражения за 10 минут"),
                new Video(3, "Коллекции: List, Set, Map"),
                new Video(4, "Исключения и try-with-resources"),
                new Video(5, "Логирование со SLF4J/Logback"),
                new Video(6, "Работа с Optional правильно"),
                new Video(7, "Многопоточность: Thread и Runnable"),
                new Video(8, "ExecutorService и Future"),
                new Video(9, "CompletableFuture — основы"),
                new Video(10, "Параллельные стримы: когда можно"),
                new Video(11, "Java Time API: даты и время"),
                new Video(12, "Регулярные выражения в Java"),
                new Video(13, "Record-классы и их плюсы"),
                new Video(14, "Generics без боли"),
                new Video(15, "Сериализация JSON: Jackson"),
                new Video(16, "JUnit 5: пишем тесты"),
                new Video(17, "Профилирование и производительность"),
                new Video(18, "Collections: внутренности HashMap"),
                new Video(19, "Паттерны проектирования в Java"),
                new Video(20, "Spring Boot: быстрый старт")
        );

        Runnable task = () -> {
            Video randomVideo = pickRandom(videos);
            videoManager.addView(randomVideo);
        };

        CheckedRunnable t = () -> {
            for (int i = 0; i < NUM_VIDEOS; i++) {
                executor.submit(task);
            }
        };

        runAwaitAndShutdown(executor, t);
        videos.forEach(video -> log.info("{} : {} просмотров",
                video.title(),
                videoManager.getViewCount(video.videoId())));
    }
}