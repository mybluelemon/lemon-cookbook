package org.ice.lemon.service;


import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.Lock;

public class AQSTest {

    private static final long nameOffset;
    private String name="init-name";
    static Unsafe unsafe = reflectGetUnsafe();
    static {
        try {
            nameOffset = unsafe.objectFieldOffset
                    (AQSTest.class.getDeclaredField("name"));
        } catch (Exception ex) { throw new Error(ex); }
    }
    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    public void testUnsafe() {
        String preName = name;
        unsafe.compareAndSwapObject(this, nameOffset, preName, "new-name");
        System.out.println("preName:" + preName);
        System.out.println("name:" + name);
    }

    public static void main(String[] args) {

    }
}
