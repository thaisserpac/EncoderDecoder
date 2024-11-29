
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TextItems {
    private static final String FORTY_EQUALS = "========================================";
    private static final String FORTY_DASHES = "----------------------------------------";
    private static final String FORTY_BANGS = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    private Scanner keyboard;
    private ArrayList<ArrayList<String>> itemList;
    private ArrayList<String> textItem;

    public TextItems() {
        this.keyboard = new Scanner(System.in);
        this.itemList = null;
        System.out.println(
                "\nError:   File name must be supplied when declaring a TextItems object.\nExample: TextItems myTextItems = new TextItems(\"text_item_file.txt\");\nProgram is now terminating.\n");
        this.pause();
        System.exit(0);
    }

    public TextItems(String var1) {
        this.keyboard = new Scanner(System.in);

        try {
            Scanner var2 = new Scanner(new File(var1));
            Throwable var3 = null;

            try {
                String var4;
                for (var4 = var2.nextLine(); !var4.equals("========================================"); var4 = var2
                        .nextLine()) {
                }

                this.itemList = new ArrayList();

                for (var4 = var2.nextLine(); var4 != null
                        && !var4.equals("========================================"); var4 = var2.nextLine()) {
                    this.textItem = new ArrayList();
                    this.textItem.add(new String(var4));

                    for (var4 = var2.nextLine(); !var4.equals("----------------------------------------"); var4 = var2
                            .nextLine()) {
                        this.textItem.add(var4);
                    }

                    this.itemList.add(this.textItem);
                }
            } catch (Throwable var14) {
                var3 = var14;
                throw var14;
            } finally {
                if (var2 != null) {
                    if (var3 != null) {
                        try {
                            var2.close();
                        } catch (Throwable var13) {
                            var3.addSuppressed(var13);
                        }
                    } else {
                        var2.close();
                    }
                }

            }
        } catch (FileNotFoundException var16) {
            pause("Trouble opening input file.\nException message: " + var16.getMessage()
                    + "\nProgram will now terminate.\n");
            System.exit(0);
        } catch (Exception var17) {
            pause("Unanticipated problem reading input file.\nException message: " + var17.getMessage()
                    + "\nProgram will now terminate.\n");
            System.exit(0);
        }

    }

    public TextItems(InputStream var1) {
        this.keyboard = new Scanner(System.in);

        try {
            Scanner var2 = new Scanner(var1);

            String var3;
            for (var3 = var2.nextLine(); !var3.equals("========================================"); var3 = var2
                    .nextLine()) {
            }

            this.itemList = new ArrayList();

            for (var3 = var2.nextLine(); var3 != null
                    && !var3.equals("========================================"); var3 = var2.nextLine()) {
                this.textItem = new ArrayList();
                this.textItem.add(new String(var3));

                for (var3 = var2.nextLine(); !var3.equals("----------------------------------------"); var3 = var2
                        .nextLine()) {
                    this.textItem.add(var3);
                }

                this.itemList.add(this.textItem);
            }
        } catch (NullPointerException var4) {
            pause("Trouble opening input file.\nException message: " + var4.getMessage()
                    + "\nProgram will now terminate.\n");
            System.exit(0);
        } catch (Exception var5) {
            pause("Unanticipated problem reading input file.\nException message: " + var5.getMessage()
                    + "\nProgram will now terminate.\n");
            System.exit(0);
        }

    }

    public void displayItem(String var1) {
        int var2;
        for (var2 = 0; var2 < this.itemList.size()
                && !((String) ((ArrayList) this.itemList.get(var2)).get(0)).equals(var1); ++var2) {
        }

        if (var2 == this.itemList.size()) {
            System.out.println("\nError: <<" + var1 + ">> not found.\n");
            this.pause();
        } else {
            for (int var3 = 1; var3 < ((ArrayList) this.itemList.get(var2)).size(); ++var3) {
                if ("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
                        .equals(((ArrayList) this.itemList.get(var2)).get(var3))) {
                    this.pause();
                } else {
                    System.out.println((String) ((ArrayList) this.itemList.get(var2)).get(var3));
                }
            }

        }
    }

    private void pause() {
        System.out.print("Press Enter to continue ... ");
        this.keyboard.nextLine();
    }

    private static void pause(String var0) {
        System.out.print(var0);
        System.out.print("Press Enter to continue ... ");
        Scanner var1 = new Scanner(System.in);
        var1.nextLine();
    }

    public static void main(String[] var0) {
        System.out.print("\nTesting constructor with file name input.");
        System.out.print("\nEnter the name of a file of text items: ");
        Scanner var3 = new Scanner(System.in);
        String var1 = var3.nextLine();
        TextItems var4 = new TextItems(var1);
        System.out.print("\nEnter the name of a text item: ");

        String var2;
        for (var2 = var3.nextLine(); !var2.equals(""); var2 = var3.nextLine()) {
            var4.displayItem(var2);
            System.out.print("\nEnter the name of a text item: ");
        }

        pause("OK ... no more text item requests.\nProgram now terminating.\n");
        System.out.print("\nTesting constructor with InputStream input.");
        var4 = new TextItems(TextItems.class.getResourceAsStream(var1));
        System.out.print("\nEnter the name of a text item: ");

        for (var2 = var3.nextLine(); !var2.equals(""); var2 = var3.nextLine()) {
            var4.displayItem(var2);
            System.out.print("\nEnter the name of a text item: ");
        }

        pause("OK ... no more text item requests.\nProgram now terminating.\n");
    }
}
