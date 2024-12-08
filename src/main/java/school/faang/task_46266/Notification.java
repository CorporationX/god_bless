package school.faang.task_46266;

public class Notification {
    private String type;
    private String massage;

    public Notification(String type, String massage) {
        this.type = type;
        this.massage = massage;
    }

    public String getType() {
        return type;
    }


    public String getMessage() {
        return massage;
    }
}
