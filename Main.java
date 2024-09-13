import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();
        System.out.println("The result:");

        //converting the input string into a binary string
        StringBuilder binaryString = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            //converting each character to 7-bit binary and appending it
            String binaryChar = String.format("%7s", Integer.toBinaryString(input.charAt(i))).replace(" ", "0");
            binaryString.append(binaryChar);
        }

        //applying chuck norris unary encoding on the binary string
        StringBuilder result = new StringBuilder();
        char currentBit = binaryString.charAt(0); //starting with first bit
        int count = 0; //consecutive bits count

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == currentBit) {
                count++; //if current bit matches the previous one, increase count
            } else {
                result.append(encodeUnary(currentBit, count)).append(" ");
                currentBit = binaryString.charAt(i);
                count = 1; //if not, encode previous group of bits and reset for the new one
            }
        }

        result.append(encodeUnary(currentBit, count)); // encode last group of bits
        System.out.println(result.toString().trim()); //output result
    }

    public static String encodeUnary(char bit, int count) {
        StringBuilder encoded = new StringBuilder();
        if (bit == '1') {
            encoded.append("0 "); //because '1' group starts with '0'
        } else {
            encoded.append("00 "); //because '0' group starts with '00'
        }
        for (int i = 0; i < count; i++) {
            encoded.append("0"); //add number of zeros for the number of consecutive bits
        }
        return encoded.toString();
    }
}
