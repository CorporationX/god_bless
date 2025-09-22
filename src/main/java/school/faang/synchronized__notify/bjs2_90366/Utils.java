package school.faang.synchronized__notify.bjs2_90366;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Utils {

    public static void runWithThreadErrorHandling(CheckedRunnable logic) {
        try {
            logic.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван {}", e.getMessage());
            e.printStackTrace(System.err);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause() != null ? e.getCause() : e;
            log.error("Ошибка выполнения задачи {}", String.valueOf(cause));
            Objects.requireNonNullElse(cause, e).printStackTrace(System.err);
        } catch (CancellationException e) {
            log.error("Задача была отменена{}", e.getMessage());
            e.printStackTrace(System.err);
        } catch (TimeoutException e) {
            log.error("Ожидание результата дольше заданного лимита {}", e.getMessage());
            e.printStackTrace(System.err);
        } catch (RejectedExecutionException e) {
            log.error("Отказ принять задачу в остановленный/переполненный executor{}", e.getMessage());
            e.printStackTrace(System.err);
        } catch (BrokenBarrierException e) {
            log.error("\"Барьер синхронизации сломан — фаза сорвалась (прерывание участника, " +
                    "таймаут, reset или ошибка barrierAction). \" +%n{}", e.getMessage());
            e.printStackTrace(System.err);
        } catch (Exception e) {
            log.error("Ошибка {}", String.valueOf(e));
            e.printStackTrace(System.err);
        }
    }
}