package faang.school.godbless.stream_api2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FriendWalkingNode {
    private String name;
    private String source;
    private int depth;
}
