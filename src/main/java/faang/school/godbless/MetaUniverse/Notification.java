package faang.school.godbless.MetaUniverse;

public record Notification(String type, String message) {
    @Override
    public String toString() {
        return "Type is: " + this.type + ", message is: " + this.message;
    }
}
