package school.faang.meta;

public class Notification implements NotificationI {
    String type;
    String massage;

    public Notification(String type, String massage) {
        this.type = type;
        this.massage = massage;
    }

    public String getType() {
        return type;
    }

    public String getMassage() {
        return massage;
    }

    @Override
    public String getMessage() {
        return massage;
    }
}
