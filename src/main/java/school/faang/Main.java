package school.faang;


public class Main {


    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String piu = "Piu";
        String bum = "Bum";
        String viu = "Viu";


        //оповещения
        Notification emailNotification = new Notification(
                NotificationType.EMAIL, " Notification for Email ");
        Notification smsNotification = new Notification(
                NotificationType.SMS, " Notification for SMS ");
        Notification pushNotification = new Notification(
                NotificationType.PUSH, " Notification for Push "
        );

        //регистрация обработчиков
        NotificationManager manager = new NotificationManager();
        manager.registerHandler(NotificationType.EMAIL, notification ->
                System.out.println("Email: " + notification.getMessage()));
        manager.registerHandler(NotificationType.SMS, notification ->
                System.out.println("SMS: " + notification.getMessage()));
        manager.registerHandler(NotificationType.PUSH, notification ->
                System.out.println("Push: " + notification.getMessage()));

        String piuEffect = "Bullet doing piu piu piu piu piu";
        String bumEffect = "Explosion bum bum bum bum bum";
        String viuEffect = "Going faster viu viu viu viu";

        spellCaster.cast(piu, (spellName) -> spellName + " Action : piu piu piu ", (effect) ->  piuEffect);
        spellCaster.cast(bum, (spellName) -> spellName + " Action : the shield activated ", (effect) ->  bumEffect);
        spellCaster.cast(viu, (spellName) -> spellName + " Action : spell go back by ", (effect) ->  viuEffect);


        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
        System.out.println("with function : \n");
        manager.notificationWithDescription(emailNotification);
        manager.notificationWithDescription(smsNotification);
    }
}
