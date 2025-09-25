package school.utils;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static java.util.concurrent.ThreadLocalRandom.current;

@Slf4j
public class Utils {

    public static <T> Optional<T> runWithThreadErrorHandling(CheckedCallable<T> logic) {
        try {
            return Optional.ofNullable(logic.call());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван {}", e.getMessage());
            e.printStackTrace(System.err);
            return Optional.empty();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause() != null ? e.getCause() : e;
            log.error("Ошибка выполнения задачи {}", String.valueOf(cause));
            Objects.requireNonNullElse(cause, e).printStackTrace(System.err);
            return Optional.empty();
        } catch (CancellationException e) {
            log.error("Задача была отменена{}", e.getMessage());
            e.printStackTrace(System.err);
            return Optional.empty();
        } catch (TimeoutException e) {
            log.error("Ожидание результата дольше заданного лимита {}", e.getMessage());
            e.printStackTrace(System.err);
            return Optional.empty();
        } catch (RejectedExecutionException e) {
            log.error("Отказ принять задачу в остановленный/переполненный executor{}", e.getMessage());
            e.printStackTrace(System.err);
            return Optional.empty();
        } catch (BrokenBarrierException e) {
            log.error("\"Барьер синхронизации сломан — фаза сорвалась (прерывание участника, " +
                    "таймаут, reset или ошибка barrierAction). \" +%n{}", e.getMessage());
            e.printStackTrace(System.err);
            return Optional.empty();
        } catch (Exception e) {
            log.error("Ошибка {}", String.valueOf(e));
            e.printStackTrace(System.err);
            return Optional.empty();
        }
    }

    public static void runWithThreadErrorHandling(CheckedRunnable logic) {
        runWithThreadErrorHandling(() -> {
            logic.run();
            return null;
        });
    }

    public static <T> Optional<T> runAwaitAndShutdown(ExecutorService executor,
                                                      CheckedCallable<T> logic,
                                                      boolean shouldShutdownExecutor,
                                                      long timeout,
                                                      TimeUnit unit) {
        try {
            return runWithThreadErrorHandling(logic);
        } finally {
            if (shouldShutdownExecutor) {
                shutdownAndAwaitTermination(executor, timeout, unit);
            }
        }
    }

    public static <T> Optional<T> runAwaitAndShutdown(ExecutorService executor,
                                                      CheckedCallable<T> logic,
                                                      boolean shouldShutdownExecutor) {
        return runAwaitAndShutdown(executor, logic, shouldShutdownExecutor, 30, TimeUnit.SECONDS);
    }

    public static <T> Optional<T> runAwaitAndShutdown(ExecutorService executor,
                                                      CheckedCallable<T> logic) {
        return runAwaitAndShutdown(executor, logic, false);
    }

    public static void runAwaitAndShutdown(ExecutorService executor,
                                           CheckedRunnable logic) {
        CheckedCallable<Void> logicCheckedCallable = () -> {
            logic.run();
            return null;
        };
        runAwaitAndShutdown(executor, logicCheckedCallable);
    }

    public static void shutdownAndAwaitTermination(ExecutorService executor,
                                                   long timeout,
                                                   TimeUnit unit) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(timeout, unit)) {
                executor.shutdownNow();
                if (!executor.awaitTermination(timeout, unit)) {
                    log.error("Пул не завершился корректно за отведённое время");
                }
            }
        } catch (InterruptedException ie) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static void shutdownAndAwaitTermination(ExecutorService executor) {
        shutdownAndAwaitTermination(executor, 30, TimeUnit.SECONDS);
    }

    public static <T> T pickRandom(@NonNull List<T> list) {
        return list.get(current().nextInt(list.size()));
    }
}