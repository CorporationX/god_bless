package faang.school.godbless.meta_universe;

public enum NotificationType {
    EMAIL("email"), PUSH("push"), SMS("sms");

    private String notificationType;

    private NotificationType(String type){
        this.notificationType = type;
    }

    public String getNotificationType(){
        return notificationType;
    }
}
