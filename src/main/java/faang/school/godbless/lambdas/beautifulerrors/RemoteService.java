package faang.school.godbless.lambdas.beautifulerrors;

public class RemoteService {

    public String call(String param) throws Exception {
        if(!param.equals("0")) {
            return "Successful call";
        }
        throw new Exception("Service is unavailable!");
    }

}
