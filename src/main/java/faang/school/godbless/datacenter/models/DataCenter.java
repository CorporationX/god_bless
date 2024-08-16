package faang.school.godbless.datacenter.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@ToString
public class DataCenter {

    private final ArrayList<Server> servers = new ArrayList<>();
}
