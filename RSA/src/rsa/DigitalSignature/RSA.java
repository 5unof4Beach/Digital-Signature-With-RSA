/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rsa.DigitalSignature;

import java.io.*;
import java.math.*;
import java.security.SecureRandom;
import java.util.Vector;

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

        n = p.multiply(q);
        phiN = phiN(p, q);
        
        boolean generated = false;
        
        while(!generated){
            this.e = new BigInteger(bits, 50, rand);
            if(e.gcd(phiN).equals(BigInteger.ONE) && e.compareTo(phiN) < 0){
                generated = true;
            }
        }
        
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
    
    public synchronized BigInteger decryptWithPublicKey(String ENCRYPTED_DIGEST_MESS_FILENAME, String PUBLIC_KEY_FILENAME) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILENAME));
        Vector<BigInteger> pubicKey = (Vector<BigInteger>) ois.readObject();

        ois = new ObjectInputStream(new FileInputStream(ENCRYPTED_DIGEST_MESS_FILENAME));
        BigInteger encrypedMess = (BigInteger) ois.readObject();

        ois.close();
        return encrypedMess.modPow(pubicKey.get(0), pubicKey.get(1));
    }

    public void writeKeyToFile() throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream("public_key.in");
        ObjectOutputStream ois = new ObjectOutputStream(fos);
        Vector<BigInteger> pubicKey = new Vector<>();

        pubicKey.add(this.e);
        pubicKey.add(this.n);
        ois.writeObject(pubicKey);
        ois.close();
    }
    
    public void writeEncryptedMessToFile(BigInteger encryptedMess) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream("encrypted_digest_mess.in");
        ObjectOutputStream ois = new ObjectOutputStream(fos);
        ois.writeObject(encryptedMess);
        ois.close();
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
