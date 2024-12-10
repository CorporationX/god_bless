package school.faang.bjs245028.model;


import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class DataCenter {
    private List<Server> servers;
}