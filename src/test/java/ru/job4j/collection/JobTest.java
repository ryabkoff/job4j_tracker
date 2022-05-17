package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorAscByName() {
        Comparator<Job> cmp = new JobAscByName();
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorDescByName() {
        Comparator<Job> cmp = new JobDescByName();
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorAscByPriority() {
        Comparator<Job> cmp = new JobAscByPriority();
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorDescByPriority() {
        Comparator<Job> cmp = new JobDescByPriority();
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorAscByNameAndAscByPrority() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmp.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorAscByNameAndDescByPrority() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmp.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorAscByProrityAndAscByName() {
        Comparator<Job> cmp = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmp.compare(
                new Job("Fix bug", 5),
                new Job("Reboot server", 5)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorAscByProrityAndDescByName() {
        Comparator<Job> cmp = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmp.compare(
                new Job("Fix bug", 5),
                new Job("Reboot server", 5)
        );
        assertThat(rsl, greaterThan(0));
    }
}