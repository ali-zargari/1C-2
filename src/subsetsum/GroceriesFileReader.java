package subsetsum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A GroceriesFileReader object will only contain one function: readFile(String path)
 * The purpose of this class is to read a Comma Separated text file, and convert its contents
 * to an ArrayList<Double>.
 *
 *
 * @author Ali Zargari
 */


public class GroceriesFileReader{


    /**
     * This function opens the content of a file in directory 'path' using Scanner and File objects.
     * The content of the Comma Separated text file is converted to an ArrayList<Double>, and returned
     * if there are no exception.
     *
     * @param path String containing the directory of the file to be processed.
     */
    public ArrayList<Double> readFile(String path){

        ArrayList<Double> temp = new ArrayList<Double>();
        try {
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNext()) {

                String data = myReader.next();
                temp.add(Double.parseDouble(data.substring(data.indexOf(',')+1)));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File could not be found. Check if the file path is correct.");
            e.printStackTrace();
        }

        return temp;
    }

}
