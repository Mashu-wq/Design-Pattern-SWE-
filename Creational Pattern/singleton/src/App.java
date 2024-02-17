/*package whatever //do not write package name here */
/*
 * To implement the Singleton Pattern, we will need to:

- Define a class with a private constructor, so that no other class can instantiate it.
- Declare a static variable of the same type as the class and create an instance of the class in the variable.
- Declare a static method that returns the instance of the class.
 */
import java.io.*;
class Singleton {
    // static class
    private static Singleton instance;
    private Singleton()
    {
        System.out.println("Singleton is Instantiated.");
    }
    public static Singleton getInstance()
    {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
    public static void doSomething()
    {
        System.out.println("Somethong is Done.");
    }
}
 
class GFG {
    public static void App(String[] args)
    {
        Singleton.getInstance().doSomething();
    }
}

/*Different ways to implement singleton method design pattern
 * Method 1. Classic implementation || make getInstance() static to implement singleton method design pattern
 * // Classical Java implementation of singleton
// design pattern
class Singleton {
    private static Singleton obj;
 
    // private constructor to force use of
    // getInstance() to create Singleton object
    private Singleton() {}
 
    public static Singleton getInstance()
    {
        if (obj == null)
            obj = new Singleton();
        return obj;
    }
}
Method 2 || Make getInstance() synchronized to implement Singleton Method Design Pattern
// Thread Synchronized Java implementation of
// singleton design pattern
class Singleton {
    private static Singleton obj;
    private Singleton() {}
 
    // Only one thread can execute this at a time
    public static synchronized Singleton getInstance()
    {
        if (obj == null)
            obj = new Singleton();
        return obj;
    }
}
Method 3 – Eager Instantiation || Static initializer based implementation of singleton design pattern
// Static initializer based Java implementation of
// singleton design pattern
class Singleton {
    private static Singleton obj = new Singleton();
    private Singleton() {}
 
    public static Singleton getInstance() { return obj; }
}

Method 4 – Most Efficient || Use “Double Checked Locking” to implement singleton design pattern
// Double Checked Locking based Java implementation of
// singleton design pattern
class Singleton {
    private static volatile Singleton obj = null;
    private Singleton() {}
 
    public static Singleton getInstance()
    {
        if (obj == null) {
            // To make thread safe
            synchronized (Singleton.class)
            {
                // check again as multiple threads
                // can reach above step
                if (obj == null)
                    obj = new Singleton();
            }
        }
        return obj;
    }
}
 */