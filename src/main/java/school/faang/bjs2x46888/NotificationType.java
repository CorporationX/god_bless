package school.faang.bjs2x46888;

public enum NotificationType {
    EMAIL("email"),
    SMS("sms"),
    PUSH("push");
    private final String notificationType;
    NotificationType(String notificationType){
        this.notificationType= notificationType;
    }
    public String getNotificationType(){
        return notificationType;
    }
}
