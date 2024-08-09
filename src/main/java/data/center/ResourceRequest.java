package data.center;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class ResourceRequest {
    private final long id = System.nanoTime();;
    private final double load;
}
