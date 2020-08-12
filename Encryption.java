package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryption {

    public static Scanner input = new Scanner(System.in);
    public static String Encrypt() throws IOException {
        String result = "";
        char currentLetter = ' ';
        for (int i = 0; i < OpeningMessage.getMessage().length(); i++) {
            switch (OpeningMessage.getMessage().charAt(i)) {
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
                    if (Character.isUpperCase(OpeningMessage.getMessage().charAt(i))) {
                        currentLetter = (char) (((int) OpeningMessage.getMessage().charAt(i) + OpeningMessage.getCipherKey() - 65) % 26 + 65);
                        if (currentLetter > 'Z') {
                            currentLetter = (char) (currentLetter + 'a' - 'z' - 1);
                        }
                        result += currentLetter;
                    } else {
                        currentLetter = (char) (((int) OpeningMessage.getMessage().charAt(i) + OpeningMessage.getCipherKey() - 97) % 26 + 97);
                        if (currentLetter > 'z') {
                            currentLetter = (char) (currentLetter + 'A' - 'Z' - 1);
                        }
                        result += currentLetter;
                    }
                    break;
            }
            }
            System.out.print("Enter a name for the encrypted file: ");
            String fileName = input.nextLine();
            FileWriter writer = new FileWriter("C:\\Users\\justi\\Documents\\" + fileName + ".txt", true);
            for (int j = 0; j < result.length(); j++) {
                writer.write(result.charAt(j));
            }
            writer.close();
            return result;
        }
    }