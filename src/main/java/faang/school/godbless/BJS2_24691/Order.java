package faang.school.godbless.BJS2_24691;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Order {
    private final long id;
    private Status status;
}
