package faang.school.godbless.the_elk_query_index;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private UUID id;
    private String name;
}
