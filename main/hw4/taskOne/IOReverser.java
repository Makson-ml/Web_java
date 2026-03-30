package taskOne;
import java.io.*;
public class IOReverser {
public static void reverseFile(String inputPath, String outputPath) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
         BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

        String line;
        while ((line = reader.readLine()) != null) {
            StringBuilder sb = new StringBuilder(line);
            String reversed = sb.reverse().toString();
            writer.write(reversed);
            writer.newLine();
        }
    } catch (FileNotFoundException e) {
        System.out.println("Файл " + e.getMessage() + " не найден!");
    }
}

public static void main(String[] args) {
    try {
        reverseFile("./taskOne/input_with_spaces.txt", "./taskOne/output1.txt");
    } catch (IOException e) {
        System.out.println("Произошла ошибка во время 1 теста: " + e.getMessage());
    }
    try {
        reverseFile("./taskOne/input_with_special_symbols.txt", "./taskOne/output2.txt");
    } catch (IOException e) {
        System.out.println("Произошла ошибка во время 2 теста: " + e.getMessage());
    }
    try {
        reverseFile("./taskOne/input_empty.txt", "./taskOne/output3.txt");
    } catch (IOException e) {
        System.out.println("Произошла ошибка во время 3 теста: " + e.getMessage());
    }
    try {
        reverseFile("./taskOne/input_one_string.txt", "./taskOne/output4.txt");
    } catch (IOException e) {
        System.out.println("Произошла ошибка во время 4 теста: " + e.getMessage());
    }
    try {
        reverseFile("./taskOne/input_many_strings.txt", "./taskOne/output5.txt");
    } catch (IOException e) {
        System.out.println("Произошла ошибка во время 5 теста: " + e.getMessage());
    }
}
}