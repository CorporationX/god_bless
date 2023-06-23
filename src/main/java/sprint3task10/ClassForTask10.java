package sprint3task10;
import java.util.function.Supplier;

public class ClassForTask10 {

//        нужен метод, который будет писать:
//        try {
//            return remoteService.call(param);
//        } catch (Exception e) {
//            log.warn("Не удалось получить доступ к Remote Service. Вернем default значение");
//            return "DEFAULT";
//        }

    public static void main(String[] args) {
        //объект класса RemoteService не нужен на самом деле
        //будем считать, что для доступа к удаленному "микро"сервису
        //нам достаточно иметь ссылку (URL) на него (String remoteServiceUrl = "url:262642";).
        RemoteService remoteService = new RemoteService();

        String remoteServiceUrl = "262642";

        //пишем лямбды в main, хотя в жизни нужно их прям в коде прописывать.
        String result = withErrorHandling(
                () -> {
                    System.out.println("Вызываем удаленный сервис (remoteService) по URL:" + remoteServiceUrl);
                    return "Успех";
                },
                (ohNo) -> {
                    System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
                    return "Возвращаем обратно URL: "+ remoteServiceUrl;
                }
        );
        //Нельзя было бы прописать просто System.out.println(withErrorHandling);
        //тк в методе должно быть указано, что с лямбами случается.
        //Поэтому через result. result на один раз.
        System.out.println(result);
    }

    public static <T> T withErrorHandling
            (Supplier<T> lambda1, ExceptionHandler<T> lambda2) {

        try {
            throw new IllegalArgumentException();
            //включаем запускаем исключение и выключаем return,
            //если хотим чтобы выполнилось catch,
            //return lambda1.get();
        } catch (Exception e) {
            return lambda2.handlingWithException(e);
        }
    }
}

//просто старый метод withErrorHandling с первыми мылсями

//    public static <T> T withErrorHandling
//            (Supplier<T>  lambda1, ExceptionHandler <T> lambda2) {
////Внутри withErrorHandling нужно написать try/catch.
////Внутри try использовать action, внутри catch использовать onError
////и передать туда пойманный Exception.
//
//        RemoteService remoteService = new RemoteService();
////Первая лямбда - то, что нужно сделать; вызов удаленного сервиса remoteService.call(param);
//        try {
//            Supplier<T> lambda1 =  () -> {
//                remoteService.call(" ");
//            return lambda1;};
//        }
//
////.call = .get ?
////Вторая лямбда - то, что нужно сделать при ошибке первого действия.
//        catch (Exception e) {
//            ExceptionHandler<T> lambda2 = ohNo -> {
//                System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение") +
//                return "DEFAULT";
//            };
//            lambda2.handlingWithException();
//        }
//        return T;
//    }