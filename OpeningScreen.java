
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class OpeningScreen {
    private int numberOfBlankLinesBefore;
    private int numberOfBlankLinesAfter;
    private int numberOfSpacesToIndent;
    private String firstLine;
    private String secondLine;
    private String thirdLine;

    public OpeningScreen() {
        this("Lastname:Firstname:A00123456:csc34101", "Submission ??", "Constructors for the OpeningScreen Class", 16,
                11, 11);
    }

    public OpeningScreen(String var1, String var2, String var3) {
        this(var1, var2, var3, 16, 11, 11);
    }

    public OpeningScreen(String var1, String var2, String var3, int var4) {
        this(var1, var2, var3, var4, 11, 11);
    }

    public OpeningScreen(String var1, String var2, String var3, int var4, int var5, int var6) {
        this.firstLine = var1;
        this.secondLine = var2;
        this.thirdLine = var3;
        this.numberOfSpacesToIndent = var4;
        this.numberOfBlankLinesBefore = var5;
        this.numberOfBlankLinesAfter = var6;
    }

    public void display() {
        for (int var1 = 1; var1 <= this.numberOfBlankLinesBefore; ++var1) {
            System.out.println();
        }

        String var3 = "";

        int var2;
        for (var2 = 1; var2 <= this.numberOfSpacesToIndent; ++var2) {
            var3 = var3 + " ";
        }

        System.out.println(var3 + this.firstLine);
        System.out.println(var3 + this.secondLine);
        System.out.println(var3 + this.thirdLine);

        for (var2 = 1; var2 <= this.numberOfBlankLinesAfter; ++var2) {
            System.out.println();
        }

        this.pause();
    }

    private void pause() {
        Scanner var1 = new Scanner(System.in);
        System.out.print("Press Enter to continue ... ");
        var1.nextLine();
    }
}
