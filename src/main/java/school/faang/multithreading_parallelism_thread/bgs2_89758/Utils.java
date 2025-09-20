package school.faang.multithreading_parallelism_thread.bgs2_89758;

import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SuppressWarnings("checkstyle:CommentsIndentation")
public class Utils {

    public static void runWithThreadErrorHandling(CheckedRunnable logic) {
        try {
            logic.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Поток прерван " + e.getMessage());
            e.printStackTrace(System.err);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            System.err.println("Ошибка выполнения задачи " + (cause != null ? cause : e));
            Objects.requireNonNullElse(cause, e).printStackTrace(System.err);
        } catch (CancellationException e) {
            System.err.println("Задача была отменена" + e.getMessage());
            e.printStackTrace(System.err);
        } catch (TimeoutException e) {
            System.err.println("Ожидание результата дольше заданного лимита " + e.getMessage());
            e.printStackTrace(System.err);
        } catch (RejectedExecutionException e) {
            System.err.println("Отказ принять задачу в остановленный/переполненный executor" + e.getMessage());
            e.printStackTrace(System.err);
        } catch (BrokenBarrierException e) {
            System.err.println("\"Барьер синхронизации сломан — фаза сорвалась " +
                    "(прерывание участника, таймаут, reset или ошибка barrierAction). \" +%n" +
                    e.getMessage());
            e.printStackTrace(System.err);
        } catch (Exception e) {
            System.err.println("Ошибка " + e);
            e.printStackTrace(System.err);
        }
    }

    public static void runAwaitAndShutdown(ExecutorService executor,
                                           CheckedRunnable logic,
                                           long timeout,
                                           TimeUnit unit) {
        try {
            runWithThreadErrorHandling(logic);
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(timeout, unit)) {
                    executor.shutdownNow();
                    if (!executor.awaitTermination(timeout, unit)) {
                        System.err.println("Пул не завершился корректно за отведённое время");
                    }
                }
            } catch (InterruptedException ie) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void runAwaitAndShutdown(ExecutorService executor,
                                           CheckedRunnable logic) {

        runAwaitAndShutdown(executor, logic, 30, TimeUnit.SECONDS);
    }

    public static Printf createPrintfWithSuffix(String terminatorChar) {
        return (format, args) -> System.out.printf(format.toString() + terminatorChar, args);
    }

    public static Long measureExecutionTime(Runnable function) {
        long startTimeNs = System.nanoTime();
        function.run();
        long leadTimeNs = System.nanoTime() - startTimeNs; // длительность в наносекундах
        return leadTimeNs / 1_000_000;
    }
}