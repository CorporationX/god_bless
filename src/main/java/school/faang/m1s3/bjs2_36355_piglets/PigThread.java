package school.faang.m1s3.bjs2_36355_piglets;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PigThread extends Thread{
    private final String pigName;
    private final String material;
}
