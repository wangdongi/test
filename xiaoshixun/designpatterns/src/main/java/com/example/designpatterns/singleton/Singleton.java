package com.example.designpatterns.singleton;

public class Singleton {

    /**
     * 饿汉式(静态常量)
     */
    /*private static Singleton singleton=new Singleton();

    private Singleton() {
    }
    public static Singleton getInstance(){
        return singleton;
    }*/

    /**
     * 饿汉式（静态代码块）
     */
    /*private static Singleton singleton;
    private Singleton(){}
    static {
        singleton=new Singleton();
    }
    public static Singleton getInstance(){
        return singleton;
    }*/

    /*
    * 懒汉式
    * */

    /*private static Singleton singleton;
    private Singleton(){
    }
    public static Singleton getInstance(){
        if (singleton == null){
            singleton=new Singleton();
        }
        return singleton;
    }*/

    /*
    * 懒汉式（同步方法）
    * */
    /*private static Singleton singleton;
    private Singleton(){}
    public static synchronized Singleton getInstace(){
        if (singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }*/

    /*
    * 懒汉式（同步代码块）
    * */
    /*private static Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        if (singleton==null){
            synchronized (Singleton.class){
                singleton=new Singleton();
            }
        }
        return singleton;
    }*/

    /*
    *双重检验
    * */
   /* private static Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }*/

   /*
   * 静态内部类
   * */
   /*private Singleton(){}
   public static Singleton getInstance(){
       return SingletonInstance.singleton;
   }
   private static class SingletonInstance{
       private static Singleton singleton=new Singleton();
   }*/
}
