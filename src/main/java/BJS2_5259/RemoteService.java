package BJS2_5259;

public class RemoteService {
    public String call(boolean param) throws IllegalArgumentException {
        if (!param) {
            throw new IllegalArgumentException("DEFAULT");
        }
        return "Доступ разрешен";
    }
}
