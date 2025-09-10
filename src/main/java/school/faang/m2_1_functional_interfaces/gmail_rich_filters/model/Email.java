package school.faang.m2_1_functional_interfaces.gmail_rich_filters.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Email {
    private final String subject;
    private String body;
    private final boolean isImportant;
}
