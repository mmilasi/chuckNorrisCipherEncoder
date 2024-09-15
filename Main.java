import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            String operation = scanner.nextLine();

            switch (operation) {
                case "encode":
                    System.out.println("Input string:");
                    String inputString = scanner.nextLine();
                    System.out.println("Encoded string:");
                    System.out.println(encodeString(inputString));
                    break;

                case "decode":
                    System.out.println("Input encoded string:");
                    String encodedString = scanner.nextLine();
                    if (isValidEncodedString(encodedString)) {
                        System.out.println("Decoded string:");
                        System.out.println(decodeUnary(encodedString));
                    } else {
                        System.out.println("Encoded string is not valid.");
                    }
                    break;

                case "exit":
                    System.out.println("Bye!");
                    return;

                default:
                    System.out.println("There is no '" + operation + "' operation");
                    break;            }
        }
    }



    //methods section below -------------------------------------------------

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

    public static String decodeUnary(String input) {
        String[] blocks = input.split(" "); //split by space to get blocks of zeros
        StringBuilder binaryString = new StringBuilder();

        //process the blocks in pairs:
        for (int i = 0; i < blocks.length; i += 2) {
            String prefix = blocks[i];    //prefix: either '0' or '00'
            String zeros = blocks[i + 1]; //zeros count
            char bit = (prefix.equals("0")) ? '1' : '0'; //determine the bit: '0' is '1', '00' is '0'
            binaryString.append(String.valueOf(bit).repeat(zeros.length())); //append corresponding bit
        }
        //split the binary string into chunks of 7 bits (since 1 character is 7 bits)
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i += 7) {
            String binaryChar = binaryString.substring(i, Math.min(i + 7, binaryString.length()));
            int charCode = Integer.parseInt(binaryChar, 2); //convert 7-bit binary to decimal (ASCII)
            result.append((char) charCode); //append corresponding character
        }

        return result.toString();
    }

    public static String encodeString(String input) {
        //convert the input string into a binary string (in case of text input)
        StringBuilder binaryString = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            //convert each character to 7-bit binary and append it
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
        return result.toString().trim(); //return result
    }

    public static boolean isValidEncodedString(String input) {
        //check if there is a string containing only 0 or spaces
        if (!input.matches("[ 0]+")) {
            return false;
        }

        String[] blocks = input.split(" ");

        //check if blocks number is even (pairs)
        if (blocks.length % 2 != 0) {
            return false;
        }

        //check if first block of each sequence is '0' or '00'
        for (int i = 0; i < blocks.length; i += 2) {
            if (!(blocks[i].equals("0") || blocks[i].equals("00"))) {
                return false;
            }
        }

        //check if length of binary string is multiple of 7 after decoding
        StringBuilder binaryString = new StringBuilder();
        for (int i = 0; i < blocks.length; i += 2) {
            String prefix = blocks[i];
            String zeros = blocks[i + 1];
            char bit = (prefix.equals("0")) ? '1' : '0';
            binaryString.append(String.valueOf(bit).repeat(zeros.length()));
        }
        return binaryString.length() % 7 == 0;
    }
}
