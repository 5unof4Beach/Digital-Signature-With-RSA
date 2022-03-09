
package rsa.Test;

import rsa.DigitalSignature.DigitalSignature;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        DigitalSignature d = new DigitalSignature();
        d.setMessage("message.txt");
//        System.out.println(d.getOriginalMess());
        d.messageHashAndSign();
    }
}
