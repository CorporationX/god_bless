package faang.school.godbless.meta;

record Notification(String type, String message) {

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
