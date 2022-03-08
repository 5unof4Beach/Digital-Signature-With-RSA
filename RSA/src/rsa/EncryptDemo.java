/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rsa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author suckm
 */
public class EncryptDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        RSA r = new RSA();
        System.out.println("Original Mess: " + r.decryptWithPublicKey("encrypted_mess.in"));
    }
}
