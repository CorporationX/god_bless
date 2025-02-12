package school.faang.BJS2_57349;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Email {
    private final String subject;
    @Setter
    private  String body;
    private final boolean isImportant;

    @Override
    public String toString() {
        return "Email{" +
                "subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", isImportant=" + isImportant +
                '}';
    }
}
