package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class FuncTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Func function = new Func();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        Func function = new Func();
        List<Double> result = function.diapason(1, 5, x -> 2 * x * x + 1);
        List<Double> expected = Arrays.asList(3D, 9D, 19D, 33D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenLinearResults() {
        Func function = new Func();
        List<Double> result = function.diapason(1, 5, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(3D, 9D, 27D, 81D);
        assertThat(result, is(expected));
    }
}