package com.company;

import java.io.IOException;
import java.util.Scanner;

public class OpeningMessage {

    public static Scanner input = new Scanner(System.in);
    private static int cipherKey;
    private static String message, encryption;

    public static void setEncryption() {
        System.out.print("\nDo you wish to encrypt or decrypt a message? ");
        encryption = input.nextLine().toLowerCase();
    }
    public static void setCipherKey() {
        System.out.print("\nEnter the Key number (1-52): ");
        cipherKey = input.nextInt();
        input.nextLine();
        if (cipherKey < 1 || cipherKey > 52) {
            setCipherKey();
        }
    }
    public static void setMessage() {
        if (encryption.equals("decrypt")) {
            return;
        }
        System.out.print("\nEnter your message: ");
        message = input.nextLine();
    }

    public static String getEncryption() {return encryption;}
    public static int getCipherKey() {return cipherKey;}
    public static String getMessage() {return message;}

    public static void cipherSetting() throws IOException {
        if (getEncryption().equals("decrypt")) {
            System.out.println("\nYour decrypted message is: \n" + Decryption.Decrypt());
        } else if (getEncryption().equals("encrypt")) {
            System.out.println("\n\nYour encrypted message is: \n" + Encryption.Encrypt());
        }
    }
}
