package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenAddItemThenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        boolean rsl = tracker.replace(item1.getId(), item2);
        item1 = tracker.findById(item1.getId());
        assertTrue(rsl);
        assertThat(item1.getName(), is(item2.getName()));
        assertThat(item1.getCreated().withNano(0), is(item2.getCreated().withNano(0)));
    }

    @Test
    public void whenAddItemThenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        boolean rsl = tracker.delete(item.getId());
        assertTrue(rsl);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenAddTwoItemsThenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        List<Item> actual = tracker.findAll();
        List<Item> expected = Arrays.asList(item1, item2);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenAddItemThenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        tracker.add(item1);
        List<Item> actual = tracker.findByName(item1.getName());
        List<Item> expected = Arrays.asList(item1);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenAddItemThenFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        tracker.add(item1);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }
}