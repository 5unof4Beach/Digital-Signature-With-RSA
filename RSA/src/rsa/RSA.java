/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rsa;

import java.math.*;
import java.security.SecureRandom;

import java.util.*;


public class RSA {
    public static void main(String[] args) {
        SecureRandom rand = new SecureRandom();
        System.out.println(rand.nextInt());
    }
    public RSA(){
        BigInteger e;
        BigInteger d;
    }
    
    public static void KeyRSA(int bits){
        SecureRandom rand = new SecureRandom();
        rand.toString();
//  BigInteger(int bitLength, int certainty, Random rand)
//  bitLength: Do dai chuoi bit cua BI tra ve
//  certainty: Kha nang de so BI duoc tao ra la 1 snt > (1-0.5^certainty) -> certainty cang cao, kha nag BI la snt cang cao
//  rand: tap cac bit ngau nhien dung de chon so de dua di ktra tinh nguyen thuy(primality)
//        BigInteger t = new BigInteger();       
        BigInteger p = new BigInteger(bits, 100, rand);       
        BigInteger q = new BigInteger(bits, 100, rand);
        BigInteger n = p.multiply(q);
        BigInteger omegaN = omegaN(p, q);
    }
    
    public static BigInteger omegaN(BigInteger p, BigInteger q){
        BigInteger temp1 = p.subtract(BigInteger.ONE);
        BigInteger temp2 = q.subtract(BigInteger.ONE);
        return temp1.multiply(temp2);
    }
    
    public static void print(int n){
        System.out.println(n);       
    }

    public static void print(String s){
        System.out.println(s);       
    }
}
