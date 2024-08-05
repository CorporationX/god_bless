package faang.school.godbless.datacenter.models;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@ToString
public class DataCenter {

    private ArrayList<Server> servers = new ArrayList<>();
}
