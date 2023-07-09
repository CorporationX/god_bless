package faang.school.godbless.kxnvg.zoom;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;

public class Conference {

    private String information;
    private static final int MEMBER_COUNT = 10;
    @Getter
    private final CyclicBarrier BARRIER = new CyclicBarrier(MEMBER_COUNT, this::startStreaming);

    public Conference(String information) {
        this.information = information;
    }

    @SneakyThrows
    public void startStreaming() {
        System.out.println("Онлайн-конференция началась");
    }
}
