package rsa.DigitalSignature;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//class tinh toan chuoi dai dien

public class SHA1 {

    public SHA1() {
    }
    
    public String encryptThisString(String input)
    {
        try {
            // goi cong cu xu ly thuat toan ham bam SHA1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // goi den phuong thuc digest va tra ve mang cac byte
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Chuyen doi mang cac byte ve mot so BI duong
            BigInteger no = new BigInteger(1, messageDigest);

            // Chuyen thong diep dai dien ve he Hexa
            String hashText = no.toString(16);

            // Add preceding 0s to make it 32 bit
            // Them cac so khong vao dang truoc de dua day so ve dang 32bit
            while (hashText.length() < 32) {
                    hashText = "0" + hashText;
            }

            return hashText;
        }

        catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
        }
    }

}

