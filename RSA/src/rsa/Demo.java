
package rsa;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.*;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        RSA r = new RSA();
        r.writeKeyToFile();
        
        BigInteger mess = new BigInteger(new Scanner(System.in).nextLine());
        
        System.out.printf("public key: (%s, %s)\n",r.getN().toString(), r.getE().toString());
        System.out.printf("private key: (%s, %s)\n",r.getN().toString(), r.getD().toString());
        
        System.out.println("mess: " + mess);
        
        BigInteger encryptedMess = r.encrypt(mess);
        r.writeEncryptedMessToFile(encryptedMess);
        
        System.out.println("EncryptedMess: " + encryptedMess);
        
        System.out.println("DecryptedMess: " + r.decrypt(encryptedMess));
    }
}
