project folder:
ali-zargari-cs1c-project02/


Brief description of submitted files:

src/subsetsum/FoothillITunes.java
    - Asks the user a preferred duration, and returns a playlist based on the users choice.
    - creates an object of type MillionSongDataSubset, which in turn
      parses a JSON data set with a given file path. The parsed data
      set is stored in an array of SongEntry objects.

src/subsetsum/GroceriesFileReader.java
    - Has a public static function that opens a CSV file and returns the content as an ArrayList<Double>

src/subsetsum/ShoppingBag.java
    - creates an object of type subset sum to find a best possible grocery shopping list within the given budget.

src/subsetsum/SubsetSum.java
    - This class is used for finding subsets with a specific total sum.

src/cs1c/MillionSongData.java
    - One object of class MillionSongDataSubset parses a JSON data set and stores each entry in an array.

src/cs1c/SongEntry.java
    - One object of class SongEntry stores a simplified version of the genre data set from the Million Song Dataset.

src/cs1c/TimeConverter.java
    - Converts duration into a string representation.

resources/groceries.txt
    - A CSV text file that has some grocery items and their prices separated by a comma.

resources/test_inputs.txt
    - A CSV text file exactly like groceries.txt, created for further testing

resources/groceries.txt_proof.mp4
    - Video proof that the program runs when path points to groceries.txt

resources/test_inputs.txt_proof.mp4
    - Video proof that the program runs when path points to test_inputs.txt

resources/PART2_PROOF.mp4
    - Video proof that the program runs part 2 of this assignment

resources/RUN.txt
    - console output of ShoppingBag.java

README.txt
    - description of submitted files