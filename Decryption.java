package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Decryption {

    public static Scanner input = new Scanner(System.in);

    public static String Decrypt() throws IOException {
        System.out.print("\nEnter the file's name to decrypt: ");
        String fileName = input.nextLine();
        try {
            String result = "", returnString = "";
            char currentLetter = ' ';
            returnString = new String(Files.readAllBytes(Paths.get("C:\\Users\\justi\\Documents\\" + fileName + ".txt")));

            for (int i = 0; i < returnString.length(); i++ ) {
                switch (returnString.charAt(i)) {
                    case ' ':
                        result += " ";
                        break;
                    case '.':
                        result += ".";
                        break;
                    case '!':
                        result += "!";
                        break;
                    case ',':
                        result += ",";
                        break;
                    case '?':
                        result += "?";
                        break;
                    case '@':
                        result += "@";
                        break;
                    case '#':
                        result += "#";
                        break;
                    case '\'':
                        result += "'";
                        break;
                    default:
                        if (Character.isUpperCase(returnString.charAt(i))) {
                            currentLetter = (char)(((int) returnString.charAt(i) - OpeningMessage.getCipherKey() - 65) % 26 + 65);
                            if (currentLetter < 'A') {
                                currentLetter = (char)(currentLetter - 'a' + 'z' + 1);
                            }
                            result += currentLetter;
                        } else {
                            currentLetter = (char) (((int) returnString.charAt(i) - OpeningMessage.getCipherKey() - 97) % 26 + 97);
                            if (currentLetter < 'a') {
                                currentLetter = (char) (currentLetter - 'A' + 'Z' + 1);
                            }
                            result += currentLetter;
                        }
                        break;
                }
            }
            return result;
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
        return "";
    }
}
