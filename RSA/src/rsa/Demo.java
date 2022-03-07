
package rsa;

import java.math.BigInteger;

public class Demo {
    public static void main(String[] args) {
        RSA r = new RSA();
        BigInteger mess = new BigInteger("21346567");
        
        System.out.printf("public key: (%s, %s)\n",r.getN().toString(), r.getE().toString());
        System.out.printf("private key: (%s, %s)\n",r.getN().toString(), r.getD().toString());
        
//        System.out.println(r.getOmegaN().toString());
        
        System.out.println("mess: " + mess);
        
        BigInteger encryptedMess = r.encrypt(mess);
        
        System.out.println("EncryptedMess: " + encryptedMess.toString());
        
        System.out.println("DecryptedMess: " + r.decrypt(encryptedMess).toString());
    }
}
