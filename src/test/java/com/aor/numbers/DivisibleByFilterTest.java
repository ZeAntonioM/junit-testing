package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisibleByFilterTest {

    @Test
    public void DivisibleTrue() {
        List<Integer> list = Arrays.asList(2,4,6,8,10, -2, -4, 0);
        DivisibleByFilter filter = new DivisibleByFilter(2);

        for (int i: list) {
            Assertions.assertTrue(filter.accept(i));
        }
    }

    @Test
    public void DivisibleFalse() {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, -5, -15);
        DivisibleByFilter filter = new DivisibleByFilter(2);

        for (int i: list) {
            Assertions.assertFalse(filter.accept(i));
        }
    }

}

