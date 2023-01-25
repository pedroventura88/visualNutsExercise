package com.test.visual.nuts.exercise1;

import com.test.visual.nuts.GenerateData;
import com.test.visual.nuts.exercise1.impl.PrintNumbersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class PrintNumbersServiceImplTest {

    @Mock
    private GenerateData generateData = new GenerateData();

    @InjectMocks
    private PrintNumbersService service = new PrintNumbersServiceImpl(generateData);

    @Test
    public void should_print_the_word_Nuts_14_times_if_the_list_is_from_1_to_101() {
        List<Integer> numbers = IntStream.range(1, 101).boxed().collect(Collectors.toList());
        lenient().when(generateData.getIntegers()).thenReturn(numbers);
        doReturn(numbers).when(generateData).getIntegers();
        Long numberOfNuts = service.processNumbers()
                .stream()
                .filter(value -> "nuts".equalsIgnoreCase(String.valueOf(value)))
                .count();

        assertEquals(14, numberOfNuts.intValue());
    }

    @Test
    public void should_print_the_word_Visual_27_times_if_the_list_is_from_1_to_101() {
        List<Integer> numbers = IntStream.range(1, 101).boxed().collect(Collectors.toList());
        lenient().when(generateData.getIntegers()).thenReturn(numbers);
        doReturn(numbers).when(generateData).getIntegers();
        Long numberOfNuts = service.processNumbers()
                .stream()
                .filter(value -> "visual".equalsIgnoreCase(String.valueOf(value)))
                .count();

        assertEquals(27, numberOfNuts.intValue());
    }

    @Test
    public void should_print_the_word_VisualNuts_6_times_if_the_list_is_from_1_to_101() {
        List<Integer> numbers = IntStream.range(1, 101).boxed().collect(Collectors.toList());
        lenient().when(generateData.getIntegers()).thenReturn(numbers);
        doReturn(numbers).when(generateData).getIntegers();
        Long numberOfNuts = service.processNumbers()
                .stream()
                .filter(value -> "visual nuts".equalsIgnoreCase(String.valueOf(value)))
                .count();

        assertEquals(6, numberOfNuts.intValue());
    }

    @Test
    public void should_print_the_word_VisualNuts_33_times_if_the_list_is_from_1_to_501() {
        List<Integer> numbers = IntStream.range(1, 501).boxed().collect(Collectors.toList());
        lenient().when(generateData.getIntegers()).thenReturn(numbers);
        doReturn(numbers).when(generateData).getIntegers();
        Long numberOfVisualNuts = service.processNumbers()
                .stream()
                .filter(value -> "visual nuts".equalsIgnoreCase(String.valueOf(value)))
                .count();

        assertEquals(33, numberOfVisualNuts.intValue());
    }
}
