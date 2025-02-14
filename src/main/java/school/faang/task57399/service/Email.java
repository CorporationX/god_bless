package school.faang.task57399.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
