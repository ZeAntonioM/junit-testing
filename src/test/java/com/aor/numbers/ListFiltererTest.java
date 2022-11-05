package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {

    @Test
    public void filter() {
        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        ListFilterer filterer = new ListFilterer(filter);
        Mockito.when(filter.accept(2)).thenReturn(false);
        Mockito.when(filter.accept(4)).thenReturn(false);
        Mockito.when(filter.accept(5)).thenReturn(false);
        Mockito.when(filter.accept(6)).thenReturn(true);
        Mockito.when(filter.accept(9)).thenReturn(true);
        List<Integer> list = filterer.filter(Arrays.asList(2,4,5,6,9));
        Assertions.assertEquals(Arrays.asList(6,9), list);
    }

    @Test
    public void Positive() {
        GenericListFilter filter = new PositiveFilter();
        ListFilterer filterer = new ListFilterer(filter);

        List<Integer> list = Arrays.asList(Integer.MIN_VALUE, -2, 0, 4, 1, 5, -256, 10);
        List<Integer> tested = Arrays.asList(4,1,5,10);


        Assertions.assertEquals(tested, filterer.filter(list));
    }

    @Test
    public void Divisible() {
        GenericListFilter filter = new DivisibleByFilter(10);
        ListFilterer filterer = new ListFilterer(filter);

        List<Integer> list = Arrays.asList(5,10,0,20,35);
        List<Integer> tested = Arrays.asList(10, 0, 20);

        Assertions.assertEquals(tested, filterer.filter(list));
    }
}
