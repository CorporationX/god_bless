package faang.school.godbless.thread.mice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private List<Food> foods;
    private boolean isDone;
}
