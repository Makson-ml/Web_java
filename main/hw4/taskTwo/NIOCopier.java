package taskTwo;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class NIOCopier {
    public static void copyFile(String sourceFile, String destFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileChannel sourceChannel = fis.getChannel();
             FileOutputStream fos = new FileOutputStream(destFile);
             FileChannel destChannel = fos.getChannel()) {
            
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (sourceChannel.read(buffer) != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    destChannel.write(buffer);
                }
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + e.getMessage() + " не найден!");
        }
    }

    public static void main(String[] args) {
        try {
            String sourceFile = "./taskTwo/input_with_spaces.txt";
            String outFile = "./taskTwo/output1.txt";
            copyFile(sourceFile, outFile);
            long size1 = new File(sourceFile).length();
            long size2 = new File(outFile).length();
            if (size1 != size2) {
                System.out.println("Тест 1 не пройден! Размер не совпадает! Ожидается: " + size1 + ", Получено: " + size2);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время 1 теста: " + e.getMessage());
        }

        try {
            String sourceFile = "./taskTwo/input_with_special_symbols.txt";
            String outFile = "./taskTwo/output2.txt";
            copyFile(sourceFile, outFile);
            long size1 = new File(sourceFile).length();
            long size2 = new File(outFile).length();
            if (size1 != size2) {
                System.out.println("Тест 2 не пройден! Размер не совпадает! Ожидается: " + size1 + ", Получено: " + size2);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время 2 теста: " + e.getMessage());
        }

        try {
            String sourceFile = "./taskTwo/input_empty.txt";
            String outFile = "./taskTwo/output3.txt";
            copyFile(sourceFile, outFile);
            long size1 = new File(sourceFile).length();
            long size2 = new File(outFile).length();
            if (size1 != size2) {
                System.out.println("Тест 3 не пройден! Размер не совпадает! Ожидается: " + size1 + ", Получено: " + size2);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время 3 теста: " + e.getMessage());
        }

        try {
            String sourceFile = "./taskTwo/input_one_string.txt";
            String outFile = "./taskTwo/output4.txt";
            copyFile(sourceFile, outFile);
            long size1 = new File(sourceFile).length();
            long size2 = new File(outFile).length();
            if (size1 != size2) {
                System.out.println("Тест 4 не пройден! Размер не совпадает! Ожидается: " + size1 + ", Получено: " + size2);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время 4 теста: " + e.getMessage());
        }

        try {
            String sourceFile = "./taskTwo/input_many_strings.txt";
            String outFile = "./taskTwo/output5.txt";
            copyFile(sourceFile, outFile);
            long size1 = new File(sourceFile).length();
            long size2 = new File(outFile).length();
            if (size1 != size2) {
                System.out.println("Тест 5 не пройден! Размер не совпадает! Ожидается: " + size1 + ", Получено: " + size2);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время 5 теста: " + e.getMessage());
        }

        try {
            String sourceFile = "./taskTwo/java.webp";
            String outFile = "./taskTwo/output6.webp";
            copyFile(sourceFile, outFile);
            long size1 = new File(sourceFile).length();
            long size2 = new File(outFile).length();
            if (size1 != size2) {
                System.out.println("Тест 6 не пройден! Размер не совпадает! Ожидается: " + size1 + ", Получено: " + size2);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время 6 теста: " + e.getMessage());
        }

        try {
            String sourceFile = "./taskTwo/java.png";
            String outFile = "./taskTwo/output7.png";
            copyFile(sourceFile, outFile);
            long size1 = new File(sourceFile).length();
            long size2 = new File(outFile).length();
            if (size1 != size2) {
                System.out.println("Тест 7 не пройден! Размер не совпадает! Ожидается: " + size1 + ", Получено: " + size2);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время 7 теста: " + e.getMessage());
        }
    }
}