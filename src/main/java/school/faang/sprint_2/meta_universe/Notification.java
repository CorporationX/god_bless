package school.faang.sprint_2.meta_universe;

public record Notification(String type, String message){
    public Notification{
        if (type.isEmpty()) {
            throw new IllegalArgumentException("Нет типа сообщения");
        }
    }
}
