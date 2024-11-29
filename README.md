This program encodes a plain-text file and writes the encoded form of that     
file out to a second (output) file. Or, it decodes a previously-encoded        
file and writes the plain-text form of the file out to an output file.

The program takes three command-line parameters:

1. The first command-line parameter must be either the single character 'e'    
   to indicate that the input file contains plain text to be encoded, or the   
   single character 'd' to indicate that the input file contains encoded text  
   to be decoded. Note that this input character must be given in lower case.  
2. The second command-line parameter must be the name of the input file.       
3. The third command-line parameter must be the name of the output file.       

If either file is not located in the current directory, the full path to the   
file may be included with the file name.

The program performs the following error checking:
- It checks to make sure the first input parameter is either 'e' or 'd'.       
- It checks that the input and output files can be opened.
- It checks that no line in a file to be encoded has length > 72 characters.   
If any check fails, a suitable message is displayed, followed by a pause,      
after which the program terminates.
