package faang.school.godbless.practice_stream_2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pair<T> {
    private T a;
    private T b;
}