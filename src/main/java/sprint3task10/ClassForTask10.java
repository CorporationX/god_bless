package sprint3task10;
import java.util.function.Supplier;

public class ClassForTask10 {
    RemoteService remoteService = new RemoteService();
    public static void main(String[] args) {
        //нужен метод, который будет писать:
        try {
            return remoteService.call(param);
        } catch (Exception e) {
            log.warn("Не удалось получить доступ к Remote Service. Вернем default значение");
            return "DEFAULT";
        }
    }
    public static <T> T withErrorHandling
            (Supplier<T>  lambda1, V ExceptionHandler <T> lambda2, RemoteService param) {
//Внутри withErrorHandling нужно написать try/catch.
//Внутри try использовать action, внутри catch использовать onError
//и передать туда пойманный Exception.

//Первая лямбда - то, что нужно сделать; вызов удаленного сервиса remoteService.call(param);
        try {
            Supplier<T> lambda1 = param -> {
                remoteService.call(param);};
            return lambda1;
        }
//.call = .get ?
// Вторая лямбда - то, что нужно сделать при ошибке первого действия.
        catch (Exception e) {
            ExceptionHandler<T> lambda2 = ohNo -> {
                System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение") +
                return "DEFAULT";
            };
            lambda2.handlingWithException();
        }
        return null;
    }
}



