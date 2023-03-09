package org.example;

import java.util.Arrays;

/**
 * @author Oksana Borisenko
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MyArrayList<Integer> test1 = new MyArrayList<>();
        test1.add(1);
        test1.add(2);
        test1.add(3);
        test1.add(4);
        test1.add(1);
        test1.add(2);
        test1.add(3);
        test1.add(4);
        System.out.println(test1);
        System.out.println("_________");
        System.out.println(test1.get(2));
        System.out.println("_________");
        test1.add(1,2);
        System.out.println(test1);
        test1.remove(2);
        System.out.println("_________");
        System.out.println(test1);
        System.out.println("_________");
        System.out.println(test1.isExists(2));
        System.out.println("_________");
        test1.quickSort((x, y) -> x - y);
        System.out.println(test1);
        System.out.println("_________");
        test1.removeAll();
        System.out.println(test1);
        System.out.println("_________");



        MyArrayList<String> test2 = new MyArrayList<>();
        test2.add("aaa");
        test2.add("bbb");
        test2.add("ccc");
        test2.add("aaa");
        test2.add("bbb");
        test2.add("ccc");
        System.out.println(test2);
        System.out.println("_________");
        System.out.println(test2.get("aaa"));
        System.out.println("_________");
        test2.add(1,"ok");
        System.out.println(test2);
        test2.remove("aaa");
        System.out.println("_________");
        System.out.println(test2);
        System.out.println("_________");
        System.out.println(test2.isExists("aaa"));
        System.out.println("_________");
        test2.quickSort((x, y) -> x.compareTo(y));
        System.out.println(test2);
        System.out.println("_________");
        test2.removeAll();
        System.out.println(test2);
    }
}
