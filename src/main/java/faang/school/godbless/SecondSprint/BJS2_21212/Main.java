package faang.school.godbless.SecondSprint.BJS2_21212;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        int param = 6;
        System.out.println(withErrorHandling(() -> remoteService.call(param), (e) -> e.getClass()));
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> handler){
        try{
            return supplier.get();
        } catch (Exception e){
            System.out.println(e.getMessage() + "\n" + "Класс ошибки:");
            return handler.warn(e);
        }
    }
}
