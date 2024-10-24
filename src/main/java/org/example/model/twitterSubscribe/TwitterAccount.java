package org.example.model.twitterSubscribe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwitterAccount {
    private String userName;
    private AtomicInteger followers = new AtomicInteger();
}
