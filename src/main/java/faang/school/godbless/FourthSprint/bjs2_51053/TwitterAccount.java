package faang.school.godbless.FourthSprint.bjs2_51053;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Getter
@Setter
public class TwitterAccount {
    private final String userName;
    private AtomicInteger followers = new AtomicInteger(0);
}
