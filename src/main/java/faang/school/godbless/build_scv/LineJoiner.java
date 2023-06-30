package faang.school.godbless.build_scv;

import java.util.List;

@FunctionalInterface
public interface LineJoiner<T> {
    T join(List<T> line);
}
