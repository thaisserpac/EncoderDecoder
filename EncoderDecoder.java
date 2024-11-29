//EncoderDecoder.java
//Serpa Chaves:Thais:u34
//Submission 03
//Enconding and Decoding Textfiles

/*
 * Program works as expected
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
/*
 * A class to encode and decode files of plain text, one file per run,
 * and write the encoded/decoded text to an output textfile. The names of
 * the input and output files are both read from the command line
 */

public class EncoderDecoder {
    private String inFileName;
    private String outFileName;
    private Scanner inputFile;
    private PrintWriter outputFile;
    private List<String> originallyDecodedLines;
    private List<String> encodedLines;
    private List<String> originallyEncodedLines;
    private List<String> decodedLines;
    private static String function;

    // Constructor
    public EncoderDecoder(String inFileName,
            String outFileName) throws FileNotFoundException {
        this.inFileName = inFileName;
        this.outFileName = outFileName;
        this.inputFile = new Scanner(new File(inFileName));
        this.outputFile = new PrintWriter(new File(outFileName));
        this.originallyDecodedLines = new ArrayList<>();
        this.encodedLines = new ArrayList<>();
        this.originallyEncodedLines = new ArrayList<>();
        this.decodedLines = new ArrayList<>();
        this.function = function;
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 3) {
            displayOpeningScreenAndProgramInfo();
            return;
        }

        function = args[0];
        String inputFileName = args[1];
        String outputFileName = args[2];
        try {
            if (function.equals("e")) {
                EncoderDecoder encoder = new EncoderDecoder(inputFileName,
                        outputFileName);

                encoder.readPlainText(inputFileName);
                encoder.encodePlainText();
                encoder.writeOutputFile();
                encoder.closeOpenedFiles();
                System.out.println("");
                System.out.println("The input file " + inputFileName +
                        " has been encoded");
                System.out.println("and output to the file " + outputFileName
                        + ".");
                System.out.println("");
                Utils.pause();
            } else if (function.equals("d")) {
                EncoderDecoder decoder = new EncoderDecoder(inputFileName,
                        outputFileName);

                decoder.readEncodedText();
                decoder.decodeEncodedText();
                decoder.writeOutputFile();
                decoder.closeOpenedFiles();
                System.out.println("");
                System.out.println("The input file " + inputFileName +
                        " has been decoded");
                System.out.println("and output to the file " + outputFileName
                        + ".");
                System.out.println("");
                Utils.pause();

            } else {
                System.out.println("");
                System.out.println("Bad first parameter.");
                System.out.println("Program now terminating.");
                System.out.println("");
                Utils.pause();
                System.exit(1);

            }
        } catch (FileNotFoundException e) {
            System.out.println("");
            System.out.println("Problem opening input file "
                    + inputFileName + ".");
            System.out.println("Program now terminating.");
            System.out.println("");
            Utils.pause();
            System.exit(1);
        }
    }

    /*
     * This method reads the lines of plain text from an input file into
     * this Decoder object. Displays a message, followed by a pause, if the
     * input file of plain text contains a line longer than the maximum of
     * 72 characters
     */

    public void readPlainText(String inputFileName) {
        int lineNum = 0;
        while (inputFile.hasNextLine()) {
            String line = inputFile.nextLine();

            lineNum++;
            if (line.length() > 72) {
                System.out.println("");
                System.out.println("Line " + lineNum + " of input file " +
                        inFileName + " exceeds maximum length" +
                        "of 72 characters.");
                System.out.println("Program now terminating.");
                Utils.pause();
                System.exit(1);
            }

            originallyDecodedLines.add(line);
        }

    }

    /*
     * This method reads the lines of encoded text from an input file into
     * this Decoder object.
     **/
    public void readEncodedText() {
        while (inputFile.hasNextLine()) {
            originallyEncodedLines.add(inputFile.nextLine());
        }
    }

    /*
     * This method encodes the lines of plain text stored in this encoder
     * object "in place". That is, each line of plain text is replaced
     * by its corresponding line of encoded text.
     */
    public void encodePlainText() {
        // generating random shift value
        int shiftValue = (int) (Math.random() * 94) + 1;

        for (int i = 0; i < originallyDecodedLines.size(); i++) {
            // padding lines to 72 characters
            StringBuilder paddedLine = new StringBuilder(originallyDecodedLines.get(i));
            while (paddedLine.length() < 72) {
                char randomCharacter = (char) (Math.random() * 95 + 32);
                paddedLine.append(randomCharacter);
            }

            // encoding padded line
            StringBuilder encodingLine = new StringBuilder();
            for (int j = 0; j < paddedLine.length(); j++) {
                char originalChar = paddedLine.charAt(j);
                int shiftedChar = (int) (originalChar) + shiftValue;

                // dealing with wrap around chars
                if (shiftedChar > 126) {
                    shiftedChar -= 95;
                }
                encodingLine.append((char) shiftedChar);
            }
            // adding last 4 characters
            int originalLength = originallyDecodedLines.get(i).length();
            encodingLine.append((char) (70 - (shiftValue / 10)));
            encodingLine.append((char) (90 - (originalLength / 10)));
            encodingLine.append((char) (70 + (shiftValue % 10)));
            encodingLine.append((char) (90 + (originalLength % 10)));
            encodedLines.add(encodingLine.toString());
        }
    }

    /*
     * This method decodes the lines of encoded text stored in this Decoder
     * object "in place". That is, each line of encoded text is replaced by
     * its corresponding line of (decoded) plain text.
     **/
    public void decodeEncodedText() {
        for (int i = 0; i < originallyEncodedLines.size(); i++) {
            String encodedLine = originallyEncodedLines.get(i);

            // Find shift
            int tensDigitOfShift = 70 - encodedLine.charAt(72);
            int unitsDigitOfShift = encodedLine.charAt(74) - 70;
            int shift = tensDigitOfShift * 10 + unitsDigitOfShift;

            // find original line length
            int tensDigitLength = 90 - encodedLine.charAt(73);
            int unitsDigitLength = encodedLine.charAt(75) - 90;
            int originalLength = tensDigitLength * 10 + unitsDigitLength;

            // Decode original words
            StringBuilder decodedLine = new StringBuilder();
            for (int j = 0; j < 72; j++) {
                char encodedChar = encodedLine.charAt(j);
                int charValue = (int) encodedChar;
                int decodedValue = charValue - shift;

                // For when the value needs to loop around
                if (decodedValue < 32) {
                    decodedValue += 95;
                }
                decodedLine.append((char) decodedValue);
            }
            // Trim line to original length
            decodedLines.add(decodedLine.substring(0, originalLength));
        }
    }

    /*
     * This method write all lines of (encoded or decoded) text to
     * an output file.
     */

    public void writeOutputFile() {
        if (function.equals("e")) {
            for (int i = 0; i < encodedLines.size(); i++) {
                outputFile.println(encodedLines.get(i));
            }
        }
        if (function.equals("d")) {
            for (int i = 0; i < decodedLines.size(); i++) {
                outputFile.println(decodedLines.get(i));
            }

        }
    }

    /*
     * This method close both the input file and the output file.
     **/
    public void closeOpenedFiles() {
        inputFile.close();
        outputFile.close();
    }

    public static void displayOpeningScreenAndProgramInfo() {

        OpeningScreen openingScreen = new OpeningScreen(
                "Serpa Chaves:Thais:A00462622:u34",
                "Submission 03",
                "Encoding and Decoding Textfiles");
        openingScreen.display();

        try {
            TextItems textItem = new TextItems(
                    EncoderDecoder.class.getResourceAsStream("EncoderDecoder.txt"));
            textItem.displayItem("ProgramInfo");
        } catch (NullPointerException e) {
            System.out.println("Could not open file EncoderDecoder.txt.");
            System.out.println("Program now terminating.");
            System.exit(1);
        }
    }

}
