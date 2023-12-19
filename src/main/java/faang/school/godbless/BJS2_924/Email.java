package faang.school.godbless.BJS2_924;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public String toString(){
        return getSubject();
    }
}
