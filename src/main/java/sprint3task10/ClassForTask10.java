package sprint3task10;
public class ClassForTask10 {
    RemoteService remoteService = new RemoteService();

    public static void main(String[] args) {
        //нужно написать метод, который будет писать:
        try {
            return remoteService.call(param);
        } catch (Exception e) {
            log.warn("Не удалось получить доступ к Remote Service. Вернем default значение");
            return "DEFAULT";
        }
    }
    public static T withErrorHandling(U lambda1, V ExceptionHandler lambda2, RemoteService param) {
//Первая лямбда - то, что нужно сделать; вызов удаленного сервиса remoteService.call(param);
        if (remoteService.lambda1) {
            call(param)
//.call = .test ?
        }
// Вторая лямбда - то, что нужно сделать при ошибке первого действия.
        else {
            ExceptionHandler<Exception> lambda2 = ohNo -> {
                System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение") +
                return "DEFAULT";
            };
            lambda2.handlingWithException();
        }
    }

}


//лямбда сидит на функциональных интерфейсах
