package school.faang.functional_interfaces_lambdas.gmail_rich_filters_bjs2_87262;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Email {
    private String subject;
    @Setter
    private String body;
    private Boolean isImportant;

}