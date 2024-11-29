#my_tests_partial.sh
clear
echo Testing run with no command-line input
read -p "(Pause from testing script) Press Enter to continue ... "
java -jar EncoderDecoder.jar
read -p "(Pause from testing script) Press Enter to continue ... "

clear
echo Testing s4_badinput.txt with more than 72 character in a line
read -p "(Pause from testing script) Press Enter to continue ... "
java -jar EncoderDecoder.jar e s4_badinput.txt s4.enc
read -p "(Pause from testing script) Press Enter to continue ... "

clear
echo Testing run with input s1_hello.txt and output s1_hello.enc
read -p "(Pause from testing script) Press Enter to continue ... "
java -jar EncoderDecoder.jar e s1_hello.txt s1_hello.enc
java -jar EncoderDecoder.jar d s1_hello.enc s1.txt
read -p "(Pause from testing script) Press Enter to continue ... "
clear
echo Comparing encoded then encoded file s1.txt with orinal s1_hello.txt 
diff s1_hello.txt s1.txt
echo
echo Differences in the files, if any, are shown immediately above
read -p "(Pause from testing script) Press Enter to continue ... "

clear
echo Testing run with input s2_sometext.txt and output s2_sometext.enc
read -p "(Pause from testing script) Press Enter to continue ... "
java -jar EncoderDecoder.jar e s2_sometext.txt s2_sometext.enc
java -jar EncoderDecoder.jar d s2_sometext.enc s2.txt
read -p "(Pause from testing script) Press Enter to continue ... "
clear
echo Comparing encoded then decoded file s2.txt with original s2_sometext.txt
diff s2.txt s2_sometext.txt
echo
echo Differences in the files, if any, are shown immediately above
read -p "(Pause from testing script) Press Enter to continue ... "

clear
echo Testing run with input s3_gettysburg.txt and output s3_gettysburg.enc
read -p "(Pause from testing script) Press Enter to continue ... "
java -jar EncoderDecoder.jar e s3_gettysburg.txt s3_gettysburg.enc
java -jar EncoderDecoder.jar d s3_gettysburg.enc s3.txt
read -p "(Pause from testing script) Press Enter to continue ... "
clear
echo Comparing encoded then decoded file s3.txt with original s3_gettysburg.txt
diff s3.txt s3_gettysburg.txt
echo
echo Differences in the files, if any, are shown immediately above
read -p "(Pause from testing script) Press Enter to continue ... "

clear
echo Testing run with input file not found
read -p "(Pause from testing script) Press enter to continue ... "
java -jar EncoderDecoder.jar e badinputname.txt badinputname.enc
read -p "(Pause from testing script) Press Enter to continue ... "

clear
echo Testing run with wrong first parameter
read -p "(Pause from testing script) Press enter to continue ... "
java -jar EncoderDecoder.jar j s1_hello.txt s1_hello.enc
read -p "(Pause from testing script) Press enter to continue ... "

clear
echo Now testing the source code file Encoder.java for TABs ... 
read -p "(Pause from testing script) Press Enter to continue ... "
/home/course_ps/u00/public/utilities/find_tabs Encoder.java
read -p "(Pause from testing script) Press Enter to continue ... "

clear
echo Now testing the source code file Encoder.java for long lines ... 
read -p "(Pause from testing script) Press Enter to continue ... "
/home/course_ps/u00/public/utilities/find_long_lines Encoder.java
read -p "(Pause from testing script) Press Enter to continue ... "

