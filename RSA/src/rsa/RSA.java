/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rsa;

import java.math.*;
import java.security.SecureRandom;

public class RSA {
    
    private BigInteger e;
    private BigInteger d;
    private BigInteger phiN;
    private BigInteger n;
    
    public RSA(){
        KeyGenerator(2048);
    }
    
    public void KeyGenerator(int bits){
        
    /*  BigInteger(int bitLength, int certainty, Random rand)
      bitLength: Do dai chuoi bit cua BI tra ve
      certainty: Kha nang de so BI duoc tao ra la 1 snt > (1-0.5^certainty) -> certainty cang cao, kha nag BI la snt cang cao
      rand: tap cac bit ngau nhien dung de chon so de dua di ktra tinh nguyen thuy(primality)
      BigInteger t = new BigInteger();       */

        SecureRandom rand = new SecureRandom();
        BigInteger p = new BigInteger(bits, 100, rand);       
        BigInteger q = new BigInteger(bits, 100, rand);
//        BigInteger p = new BigInteger("3");       
//        BigInteger q = new BigInteger("11");
        n = p.multiply(q);
        phiN = phiN(p, q);
        
        boolean generated = false;
        
        while(!generated){
            this.e = new BigInteger(bits, 50, rand);
            if(e.gcd(phiN).equals(BigInteger.ONE) && e.compareTo(phiN) < 0){
                generated = true;
            }
        }
        
//        this.e = new BigInteger("7");
        this.d = e.modInverse(phiN);
    }
    
    public BigInteger phiN(BigInteger p, BigInteger q){
        BigInteger temp1 = p.subtract(BigInteger.ONE);
        BigInteger temp2 = q.subtract(BigInteger.ONE);
        return temp1.multiply(temp2);
    }
    
    public synchronized BigInteger encrypt(BigInteger mess){
//        return mess.modPow(e, n);
        return mess.modPow(d, n);
    }
    
    public synchronized BigInteger decrypt(BigInteger encrypedMess){
//        return encrypedMess.modPow(d, n);
        return encrypedMess.modPow(e, n);
    }
    
    public void print(int n){
        System.out.println(n);       
    }

    public void print(String s){
        System.out.println(s);       
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }

    public BigInteger getPhiN() {
        return phiN;
    }

    public BigInteger getN() {
        return n;
    }
    
}
