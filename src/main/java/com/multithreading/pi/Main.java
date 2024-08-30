package com.multithreading.pi;

public class Main {
    public static void main(String[] args) {

        int countPoint = 10000;
        int radius = 1;

        Сalculation сalculation = new Сalculation(countPoint, radius);
        System.out.println(сalculation.getNumberPi());

    }
}
