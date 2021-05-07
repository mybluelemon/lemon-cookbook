package org.ice.lemon.service;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Lemon implements  Cloneable{

    public int value = 1;
    private Lemon(){
        System.out.println("constructor...");
    }

    private static class SingleHolder{
        private final static Lemon instance = new Lemon();
    }
    public static Lemon getInstance(){
return SingleHolder.instance;
    }

    public static void main(String[] args) throws CloneNotSupportedException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Lemon lemon1 = Lemon.getInstance();
        Lemon lemon2 =  Lemon.getInstance();
        System.out.println(lemon1 == lemon2);
        Lemon lemon3 =(Lemon) lemon1.clone();
        System.out.println(lemon3 == lemon1);
        Class aClass = Unsafe.class;
        Constructor constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Unsafe unsafe = (Unsafe)constructor.newInstance();
        Lemon lemon5  = (Lemon)unsafe.allocateInstance(Lemon.class);
        System.out.println(lemon5.value);
    }
}
