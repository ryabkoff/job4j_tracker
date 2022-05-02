package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PointTest {

    @Test
    public void whenPointOne000AndPointTwo999Then15588() {
        Point one = new Point(0, 0, 0);
        Point two = new Point(9, 9, 9);
        double rsl = one.distance3d(two);
        assertThat(rsl, closeTo(15.588, 0.001));
    }
}