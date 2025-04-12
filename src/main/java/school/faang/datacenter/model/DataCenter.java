package school.faang.datacenter.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class DataCenter {
    private final List<Server> servers;
}