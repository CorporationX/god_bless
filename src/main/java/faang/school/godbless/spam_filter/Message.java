package faang.school.godbless.spam_filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class Message {
    private String message;
    private List<String> messageFilter;
}
