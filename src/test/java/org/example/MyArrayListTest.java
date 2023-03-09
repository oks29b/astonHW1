package org.example;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * @author Oksana Borisenko
 *
 */
public class MyArrayListTest {
    @Test
    public void testAddSizeAndGet() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add(0, "mix");


        assertEquals(4, list.sizeList());
        assertEquals(0, list.get("mix"));
        assertEquals(1, list.get("apple"));
        assertEquals(2, list.get("banana"));
    }

    @Test
    public void testIsEmpty() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        assertEquals(false, list.isEmpty());
    }

    @Test
    public void testIsExists() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        assertEquals(true, list.isExists("apple"));
    }

    @Test
    public void testRemove() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        list.remove("banana");

        assertEquals(2, list.sizeList());
        assertEquals(0, list.get("apple"));
        assertEquals(1, list.get("cherry"));
    }

    @Test
    public void testRemoveAll() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        list.removeAll();

        assertEquals(0, list.sizeList());
    }

    @Test
    public void testQuickSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(9);

        list.quickSort((x, y) -> x-y);

        assertEquals(5, list.sizeList());
        assertEquals(0, (int) list.get(1));
        assertEquals(1, (int) list.get(3));
        assertEquals(2, (int) list.get(4));
        assertEquals(3, (int) list.get(5));
        assertEquals(4, (int) list.get(9));
    }

    /**
     * Testing private method with reflection
     * @throws Exception
     */
    @Test
    public void testSwap() throws Exception {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Test1");
        list.add("Test2");

        Method swapMethod = MyArrayList.class.getDeclaredMethod("swap", int.class, int.class);
        swapMethod.setAccessible(true);
        swapMethod.invoke(list, 0, 1);

        assertEquals(0, list.get("Test2"));
        assertEquals(1, list.get("Test1"));
    }
}
