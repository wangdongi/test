package com.example.designpatterns.singleton;

public class Singleton3 {

    private Singleton3(){}
    public static Singleton3 getInstance(){
        return SingletonInstance.singleton3;
    }
    private static class SingletonInstance{
        private static Singleton3 singleton3=new Singleton3();
    }
}
