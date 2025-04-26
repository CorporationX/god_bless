package school.faang.gmail_rich_filters;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Email {
    private String subject;
    private String body;
    private Boolean isImportant;
}
