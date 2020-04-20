package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

    @Test
    public void testPrime() {
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE)); //проверка простого числа
    }

    @Test
    public void testPrimeFast1() {
        Assert.assertTrue(Primes.isPrimeFast1(Integer.MAX_VALUE));
    }

    @Test
    public void testPrimeFast2() {
        Assert.assertTrue(Primes.isPrimeFast2(Integer.MAX_VALUE));
    }

    @Test
    public void testNonPrime() {
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
    }

    @Test(enabled = false)
    public void testPrimeLong() {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(n));
    }

}
