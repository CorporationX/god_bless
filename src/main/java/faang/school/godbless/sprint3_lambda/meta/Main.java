package faang.school.godbless.sprint3_lambda.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);


    }
}

//        Notification notification = new Notification("mail", "sup");
//        Consumer<Notification> notificationConsumer = (param) -> {
//            System.out.println("sup" + param.getMessage());
//        };
//        notificationConsumer.accept(notification);

//    Predicate<String> not = (param) -> {
//        if (param == null) {
//            System.out.println("hyi");
//            return false;
//        }else {
//            System.out.println("her");
//            return true;
//        }
//    };

//    Consumer<Double> ii = (dob) -> {
//        dob *= 2;
//        System.out.println(dob);
//    }




