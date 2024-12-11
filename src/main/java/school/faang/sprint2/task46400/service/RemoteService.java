package school.faang.sprint2.task46400.service;

public class RemoteService {

    public static String wifiCall(String param) {
        if (true) {
            throw new RuntimeException("Service wifiCall(" + param + ") unavailable");
        }
        return "Service wifiCall(" + param + ") successfully called.";
    }

    public static String networkCall(String param) {
        return "Service networkCall(" + param + ") successfully called.";
    }


}
