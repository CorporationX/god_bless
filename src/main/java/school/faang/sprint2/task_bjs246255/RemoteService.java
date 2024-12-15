package school.faang.sprint2.task_bjs246255;

public class RemoteService {
    public static String call(String param) throws IllegalArgumentException {
        System.out.println("Метод был вызван со значением: " + param + " и вернул ошибку");
        throw new IllegalArgumentException("Сервис недоступен");
    }
}
