package org.example;

public class math {
    public int add(int a,int b){
        return a+b;
    }
    public boolean isPrime(Number x) throws Exception{
        if (x instanceof Double || x instanceof Float) throw new Exception();
        long n=x.longValue();
        if (n < 2) {
            throw new IllegalArgumentException("error");
        }
        if (n > 1000000000000L) {
            throw new IllegalArgumentException("error");
        }

        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;


    }


}