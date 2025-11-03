package DFA;

import java.util.Scanner;

public class DFA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String input = scanner.nextLine();

        if (isAccepted(input)) {
            System.out.println("Accepted: The string ends with '01'.");
        } else {
            System.out.println("Rejected: The string does not end with '01'.");
        }

        scanner.close();
    }

    public static boolean isAccepted(String input) {
        int state = 0;

        for (char ch : input.toCharArray()) {
            if (ch != '0' && ch != '1') {
                System.out.println("Invalid input: Only binary digits (0 and 1) are allowed.");
                return false;
            }

            switch (state) {
                case 0:
                    if (ch == '0') state = 1;
                    else state = 0;
                    break;

                case 1:
                    if (ch == '0') state = 1;
                    else state = 2;
                    break;

                case 2:
                    if (ch == '0') state = 1;
                    else state = 0;
                    break;
            }
        }

        return state == 2;
    }
}
