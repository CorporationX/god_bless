package school.faang.bjs245016;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class ResourceRequest {
    private final double load;
    private UUID serverId;
}
