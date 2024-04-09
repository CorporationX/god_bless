package faang.school.godbless.lambdas.task_9.service;

public class MockRemoveService {
    public String call(boolean param) {
        if (!param) {
            throw new IllegalArgumentException("Не удалось получить доступ к Remote Service");
        }
        return "Доступ разрешен";
    }
}