package gmail.rich.filters;

public record Email(
        String subject,
        String body,
        boolean isImportant) {
}
