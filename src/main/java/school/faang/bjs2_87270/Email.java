package school.faang.bjs2_87270;

public record Email(String subject, String body, boolean isImportant) {

    @Override
    public String toString() {
        return String.format("Тема: %s | Сообщение: %s", subject, body);
    }
}
