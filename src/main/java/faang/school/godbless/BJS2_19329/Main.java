package faang.school.godbless.BJS2_19329;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter(List.of(
                new Server(30, 90, 400),
                new Server(33, 85, 356),
                new Server(45, 92, 484),
                new Server(15, 97, 287)
        ));
    }
}
