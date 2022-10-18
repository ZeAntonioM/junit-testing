package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import org.mockito.Mockito;


public class ListDeduplicatorTest {

    List<Integer> list, expected;

    @BeforeEach
    public void helper(){
        list = Arrays.asList(1,2,4,2,5);
        expected = Arrays.asList(1,2,4,5);
    }


    @Test
    public void deduplicate() {
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4, 5));
        List<Integer> distinct = deduplicator.deduplicate(list);
        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void bug_deduplicate_8726() {
        List<Integer> list = Arrays.asList(1,2,4,2);
        expected = Arrays.asList(1,2,4);

        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        List<Integer> distinct = deduplicator.deduplicate(list);
        Assertions.assertEquals(expected, distinct);
    }
}
