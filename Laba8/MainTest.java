package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void countDay() {
        List<Day> days = new ArrayList<Day>();
        days.add(new Day("Білбіотека 1", "Aдрес1", new Date(2022 - 1900, 05 - 1, 23), 6, 4));
        days.add(new Day("Білбіотека 2", "Aдрес2", new Date(2022 - 1900, 05 - 1, 22), 6, 8));
        assertEquals(2,Main.countDay(days));
    }
}
