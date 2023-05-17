import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program uses recursion to reverse, a set of strings.
 *
 * @author Melody Berhane
 * @version 1.0
 * @since 2023-05-10.
 */
public final class DecToBinConvert {

    /**
    * This is a private constructor used to satisfy the style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private DecToBinConvert() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the main method.
    *
    * @param args Unused.
    */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");

        // Usage of try catch to detect error.
        try {
            // Create FileWriter object to write to file.
            final FileWriter fileWrite = new FileWriter("output.txt");
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fileWrite);

            while (sc.hasNextLine()) {
                // Read line as string.
                final String line = sc.nextLine();
                try {
                    // Parse the input as double.
                    final int newLine = Integer.parseInt(line);

                    // Declare variable.
                    final int aStr = newLine;

                    // Call function.
                    final int binary = DecToBin(aStr);

                    // Converts the binary into a string
                    String numberString = Integer.toString(binary);
                    // Checks if the length of the string is less than 8
                    // If it is then it will add 0 to the left.
                    for (int counter = numberString.length(); counter % 8 != 0;
                        counter++) {
                        numberString = "0" + numberString;
                    }
                    String spacedNumbers = new String();
                    // it will look at how long the string is and add
                    // a space after 4 characters.
                    for (int spaces = 0; spaces < numberString.length();
                        spaces++) {
                        spacedNumbers += numberString.charAt(spaces);
                        if ((spaces + 1) % 4 == 0) {
                            spacedNumbers += " ";
                        }
                    }
                    // Write to console.
                    write.print("The binary of " + aStr);
                    write.println(" is " + spacedNumbers);
                } catch (NumberFormatException error) {
                    // Displays error to user if input is not a valid int.
                    write.println("Error: Invalid, \""
                        + line + "\" is not a valid number.");
                }
            }
            // Closes scanner & writer.
            write.close();
            sc.close();
        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: " + error.getMessage());
        }
    }

    /**
    * This function uses recursion to calculate recursion.
    *
    * @param decNumber passed
    * @return decNumber.
    */
    public static int DecToBin(int decNumber) {
        // Converts the decimal number to binary
        if (decNumber == 0) {
            return 0;
        } else {
            return (decNumber % 2) + 10 * DecToBin(decNumber / 2);
        }
    }
}
