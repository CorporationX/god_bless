package faang.school.godbless.greatexception;

import lombok.Data;

@Data
public class RemoteService {
    public String call(Integer param) {
        return param.toString();
    }
}
