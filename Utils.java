
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class Utils {
    private static Scanner keyboard;

    public Utils() {
    }

    public static void pause(int var0, String var1, int var2) {
        int var3;
        if (var2 > 0) {
            if (var0 > 0) {
                for (var3 = 1; var3 <= var0; ++var3) {
                    System.out.print(" ");
                }
            }

            System.out.println("This is pause #" + var2 + ".");
        }

        if (!var1.equals("")) {
            if (var0 > 0) {
                for (var3 = 1; var3 <= var0; ++var3) {
                    System.out.print(" ");
                }
            }

            System.out.println(var1);
        }

        if (var0 > 0) {
            for (var3 = 1; var3 <= var0; ++var3) {
                System.out.print(" ");
            }
        }

        System.out.print("Press Enter to continue ... ");
        keyboard.nextLine();
        System.out.println();
    }

    public static void pause(int var0, String var1) {
        pause(var0, var1, 0);
    }

    public static void pause(int var0) {
        pause(var0, "", 0);
    }

    public static void pause() {
        pause(0, "", 0);
    }

    public static boolean userSaysYes(String var0) {
        System.out.print(var0 + " (y/[n]) ");
        String var1 = keyboard.nextLine();
        boolean var2;
        if (var1.equals("")) {
            var2 = false;
        } else {
            var2 = var1.equalsIgnoreCase("y");
        }

        return var2;
    }

    public static void main(String[] var0) {
        pause();
        pause(5);
        pause(10, "This is the message ... ");
        pause(15, "This is the message ... ", 3);
        if (userSaysYes("OK to proceed?")) {
            System.out.println("User said yes.");
        } else {
            System.out.println("User said no.");
        }

    }

    static {
        keyboard = new Scanner(System.in);
    }
}
