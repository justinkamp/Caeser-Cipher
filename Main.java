package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        //Determining whether to encrypt or decrypt
        OpeningMessage.setEncryption();
        //Determining how many spaces to move the cipher over
        OpeningMessage.setCipherKey();
        //Setting the message to either encrypt or decrypt
        OpeningMessage.setMessage();
        //Running through the encryption or decryption process
        OpeningMessage.cipherSetting();
    }
}
