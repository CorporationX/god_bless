package school.faang.datacenter.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResourceRequest {
    private final double load;
}