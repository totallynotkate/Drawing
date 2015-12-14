import java.util.Scanner;

/* This program reads integer numbers from the console and draws a rectangle with the respective sides.
 * It checks if the input is actually a number and if it's not it asks the user to input correct information.
 * The program keeps running and drawing rectangles until the user prints 'q' to the console.
 * The static method drawRectangle produces the actual output.*/

public class Main {

    public static void drawRectangle(int height, int width){
        drawRectangle(height, width, false);
    }

    //a method to draw a rectangle of the specified size
    public static void drawRectangle(int height, int width, boolean isFull) {
        //the terminal size is limited, so trim ridiculous width numbers
        if (width > 80) {
            System.out.println("Rectangle width is too big, it has been trimmed to 80");
            width = 80;
        }

        if (height <= 0 || width <= 0){
            System.out.println("Wrong input: sides must be bigger than 0");
            return;
        }

        System.out.println(isFull? "Here is a filled in rectangle" : "Here is an empty rectangle");

        //draw the top line full of asterisks
        for (int i = 1; i <= width; i++) {
            System.out.print('*');
        }
        System.out.println();
        //draw the middle lines that start with an asterisk, are empty inside and end with an asterisk
        while (--height > 1) {
            for (int i = 1; i <= width; i++) {
                if (i == 1 || i == width) {
                    System.out.print('*');
                } else {
                    System.out.print(isFull ? '*' : ' ');
                }
            }
            System.out.println();
        }
        //draw the bottom line full of asterisks.
        // if the input length was = 1 our rectangle is a line which is already drawn, hence the check
        if (height == 1) {
            for (int i = 1; i <= width; i++) {
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String scannedInput = null;
        int height = 0;
        int width = 0;

        while (!"q".equals(scannedInput)){
            System.out.println("Enter two sides of the rectangle. The first number is for height," +
                    " the second one is for width. Type q to quit.");
            scannedInput = scanner.next();
            try {
                height = Integer.parseInt(scannedInput);
                scannedInput = scanner.next();
                width = Integer.parseInt(scannedInput);
                drawRectangle(height, width);
                drawRectangle(height, width, true);

            } catch (NumberFormatException num){
                if (!"q".equals(scannedInput)){
                    System.out.println("Wrong input");
                }
            }
        }
    }
}
