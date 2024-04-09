package handleErrors;

import lombok.Data;

@Data
public class RemoteService {
    public String call(Integer parameter) {
        return parameter.toString();
    }
}
