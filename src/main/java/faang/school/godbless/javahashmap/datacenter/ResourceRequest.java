package faang.school.godbless.javahashmap.datacenter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResourceRequest {
    // будет использоваться, когда к нашему дата-центру приходит запрос на выделение ресурса
    private double load;
}
