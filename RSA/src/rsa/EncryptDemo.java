package rsa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;

public class EncryptDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        RSA r = new RSA();
        BigInteger mess = r.decryptWithPublicKey("encrypted_mess.in", "public_key.in");
        System.out.println("Original Mess: " + mess);
    }
}
