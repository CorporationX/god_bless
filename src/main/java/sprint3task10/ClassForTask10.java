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
    public T withErrorHandling (lambda1, lambda2 ){
//Первая лямбда - то, что нужно сделать; вызов удаленного сервиса remoteService.call(param);

// Вторая лямбда - то, что нужно сделать при ошибке первого действия.

        ExceptionHandler<Exception> lambda2 = ohNo -> {
            System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение"+ "DEFAULT");
        };

// Передадим значение в объект Consumer и вызовем метод accept()
        consumer.accept("Hello world!"); // выводит "Consumed – Hello world!"


    }


}



//лямбда сидит на функциональных интерфейсах
