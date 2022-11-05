package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PositiveFilterTest {

    @Test
    public void Positive() {
        PositiveFilter filter = new PositiveFilter();
        Assertions.assertTrue(filter.accept(150));
    }

    @Test
    public void Zero() {
        PositiveFilter filter = new PositiveFilter();
        Assertions.assertFalse(filter.accept(0));
    }

    @Test
    public void Negative() {
        PositiveFilter filter = new PositiveFilter();
        Assertions.assertFalse(filter.accept(-150));
    }
}
