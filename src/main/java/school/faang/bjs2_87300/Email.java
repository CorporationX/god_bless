package school.faang.bjs2_87300;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@AllArgsConstructor
@Getter
@ToString
public class Email {
    private Subjects subject;
    @Setter private String body;
    private boolean isImportant;
    private LocalTime emailTime;
}
