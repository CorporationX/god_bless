package school.faang.mattersoftheheart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chat {
    private User firstUser;
    private User secondUser;
}