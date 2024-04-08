package faang.school.godbless.lambdas.task_9;

import faang.school.godbless.lambdas.task_9.handler.ExceptionManager;
import faang.school.godbless.lambdas.task_9.service.MockRemoveService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {
        MockRemoveService remoteService = new MockRemoveService();
        ExceptionManager<String> exceptionManager = new ExceptionManager<>();
        exceptionManager.manageMethodWithException(() -> remoteService.call(false), (exception) -> {
            log.warn("Не удалось получить доступ к Remote Service. Вернем default значение");
            return "DEFAULT";
        });
    }
}