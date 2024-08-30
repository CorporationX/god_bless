package com.multithreading.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Сreation {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        Potion strength = new Potion("strength");
        Potion agility = new Potion("agility");
        Potion intelligence = new Potion("intelligence");

        List<Potion> potions = Arrays.asList(strength, agility, intelligence);

        System.out.println(optionOne(potions, atomicInteger));

    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Error {}", e.getMessage());
            }
            potion.setRequiredIngredients(RANDOM.nextInt(1, 4));
            return potion.getRequiredIngredients();
        });
    }

    public static int optionOne(List<Potion> potions, AtomicInteger atomicInteger) {

        List<CompletableFuture<Integer>> futures = potions
                .stream()
                .map(Сreation::gatherIngredients)
                .toList();

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(f -> {
                    futures.forEach(count -> {
                        try {
                            atomicInteger.addAndGet(count.get());
                            log.info("Count = {}", count.get());
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                    });
                    return atomicInteger.get();
                }).join();
    }
}
