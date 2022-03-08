package rsa.Test;

import rsa.DigitalSignature.DigitalSignature;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;

public class DecryptDemo {
    public static void main(String[] args){
        DigitalSignature d = new DigitalSignature();

        try{
            d.setMessage("message.txt");
            d.messageChecking("encrypted_digest_mess.in", "public_key.in", "message.txt");
//            System.out.println(d.getOriginalMess());
        }
        catch(IOException e){
            System.out.println("Co file ko ton tai");
        }
        catch(ClassNotFoundException e){
            System.out.println("Ko ton tai class");
        }

    }
}
