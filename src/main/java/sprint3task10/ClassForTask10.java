package sprint3task10;
import java.util.function.Supplier;

public class ClassForTask10 {

    public static void main(String[] args) {
//        RemoteService remoteService = new RemoteService();
//        //нужен метод, который будет писать:
//        try {
//            return remoteService.call(param);
//        } catch (Exception e) {
//            log.warn("Не удалось получить доступ к Remote Service. Вернем default значение");
//            return "DEFAULT";
//        }

        String remoteServiceUrl = "url:262642";
        String result = withErrorHandling1(
                () -> { System.out.println("Вызываем удаленный сервис (remoteService) по URL:" + remoteServiceUrl);
                    return "Успех";},
                (ohNo) -> { System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
                return url;
                }
        );
        System.out.println(result);
    }
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

    public static String withErrorHandling1
            (Supplier<String>  lambda1, ExceptionHandler <String> lambda2) {

        try{
           //throw new IllegalArgumentException();
            return lambda1.get();
        }
        catch (Exception e){
            return lambda2.handlingWithException(e);
        }




    }}