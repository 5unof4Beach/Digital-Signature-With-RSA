package rsa.DigitalSignature;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class DigitalSignature {
    private String originalMess = "";
    private SHA1 s = new SHA1();
    private RSA r = new RSA();

    public DigitalSignature() {
        
    }
    
    public void setMessage(String ORGINAL_MESS_FILENAME){
        try{
            Scanner sc = new Scanner(new File(ORGINAL_MESS_FILENAME));
            while(sc.hasNextLine()){
                originalMess += sc.nextLine() + " ";
            }
        }
        catch(FileNotFoundException e){
            System.out.println("ko ton tai file nay");
        }
    }
    
    public void messageHashAndSign() throws IOException{
        r.writeKeyToFile();
        
        String hashedMess = s.encryptThisString(originalMess);
        BigInteger encryptedMess = r.encrypt(new BigInteger(hashedMess, 16));
        r.writeEncryptedMessToFile(encryptedMess);
    }
    
    public void messageCheck(String ENCRYPTED_DIGEST_MESS_FILENAME, String PUBLIC_KEY_FILENAME) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        BigInteger decryptedMess = r.decryptWithPublicKey(ENCRYPTED_DIGEST_MESS_FILENAME, PUBLIC_KEY_FILENAME);
        
        BigInteger hashedMess = new BigInteger(s.encryptThisString(originalMess), 16);
        
        if(decryptedMess.equals(hashedMess)){
            System.out.println("Noi dung ven toan");
        }
        else{
            System.out.println("Noi dung ko ven toan");
            System.out.println(decryptedMess);
            System.out.println(hashedMess);
        }
    }

    public String getOriginalMess() {
        return originalMess;
    }
   
}
