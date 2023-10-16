# Word-Composition-Problem

Overview:

This Java program is designed to find the longest and second longest compounded words from a list of alphabetically sorted words provided in a text file. A compounded word is defined as one that can be constructed by concatenating shorter words also found in the same file.

##Execution Steps:

1. Run the program in java installed system
2. Place the input text file (e.g., Input_01.txt) in the same directory as the Java code. or you can paste the path of the txt file.
3. Compile and Run the code.
    
The program will process the input file, find the longest and second longest compounded words, and display the results along with the time taken to process the file in milliseconds.


##Design Decisions and Approach:

1. Trie Data Structure: The program uses a Trie data structure to efficiently store and search for words. This allows for fast retrieval and validation of compounded words.

2. File Input: The program reads the input word list from a text file, line by line. It first populates the Trie with all words and then iterates through the list to find compounded words.

3. Recursive Search: To identify compounded words, a recursive search function is employed, which checks if a word can be divided into two valid words.

4. Efficient Search: The program ensures that it doesn't unnecessarily repeat search operations, making use of the Trie to improve efficiency.
