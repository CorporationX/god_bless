package com.functional.filter;

@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
