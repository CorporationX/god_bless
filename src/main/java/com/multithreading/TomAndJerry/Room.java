package com.multithreading.TomAndJerry;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Room {
    private List<Food> foodList = new ArrayList<>();
}
