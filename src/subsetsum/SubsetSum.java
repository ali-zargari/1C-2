package subsetsum;

import cs1c.SongEntry;
import java.util.ArrayList;


/**
 * This class is used for finding subsets with a specific total sum.
 *
 * SubsetSum class has 2 functions: findSubset(ArrayList<Double> shoppingList, double budget)
 * and findSubsetOfSongs(ArrayList<SongEntry> songList, double duration). This class and both of its static functions are
 * used by ShoppingBag.java, and FootHillITunesStore.java in order to show appropriate items that a user could buy,
 * with a given budget. The functions are all public.
 *
 *
 * @author Ali Zargari
 */

public class SubsetSum {



    /**
     * This function finds all possible subsets of the ArrayList shoppingList, where the sum of all elements is less than or equal to
     * the 'budget' parameter. It returns an ArrayList<Double> that contains the optimal subset that is closest to 'budget'
     *
     * @param shoppingList	contains a list of item prices to be used for finding the most optimal subset.
     * @param budget the upper limit of the sum of all elements that are in the final subset to be returned.
     */
    public static ArrayList<Double> findSubset(ArrayList<Double> shoppingList, double budget) {

        //Temporary storage to keep the subsets being processed
        ArrayList<Double> temp = new ArrayList<Double>();

        //Holds the second closest result according to given budget
        ArrayList<Double> closestSubset = new ArrayList<Double>();

        //Holds the sum of the subset being processed
        double sum = 0;

        //Holds the difference between 'budget' and the current 'sum'
        double diff = budget;

        //Find the total sum of all elements in 'shoppingList', and return all shopping items
        //if the budget is greater than or equal to it.
        for(int i = 0; i < shoppingList.size(); i++){
            sum += shoppingList.get(i);
        }
        if (sum <= budget){
            return shoppingList;
        }

        //This algorithm makes use of bitwise operators to count through the list and create the needed subsets.
        //Number of subsets in a set is given by 2^size, which is the upper bound of the outer loop
        for (int i = 0; i < Math.pow(2, shoppingList.size()); i++) {

            // reinitialize for new iteration
            sum = 0;
            temp.clear();

            //this loop makes use of bitwise operators to make sure that all of the subsets are counted.
            //bitwise operators are helpful here, as the elements in the set correspond to bits in binary numbers.
            for (int j = 0; j < shoppingList.size(); j++) {
                if((i & (1 << j)) > 0){
                    temp.add(shoppingList.get(j));
                    sum += shoppingList.get(j);
                    if(sum == budget){
                        return temp;
                    }
                }
            }

            //If the total sum of the iterated subset does not equal 'budget', then update 'diff'
            //and remember the current subset as 'closestSubset'.
            //Useful for when there is no exact match found by the search, and we need a second best result.
            if(Math.abs(sum - budget) < diff && (budget-sum) > 0){
                diff = Math.abs(sum - budget);
                closestSubset = (ArrayList<Double>) temp.clone();
            }
        }
        return closestSubset;
    }

    /**
     * This function finds all possible subsets of the ArrayList songList, where the total duration of all songs in it is less than or equal to
     * the 'duration' parameter. It returns an ArrayList<SongEntry> containing a subset where total duration is less than the 'duration' parameter.
     *
     * @param songList	contains a list of SongEntry objects to be used for finding the most optimal subset.
     * @param duration the upper limit of the sum of all elements that are in the final subset to be returned.
     */
    public static ArrayList<SongEntry> findSubsetOfSongs(ArrayList<SongEntry> songList, double duration) {
        //Temporary storage to keep the subsets being processed
        ArrayList<SongEntry> temp = new ArrayList<SongEntry>();

        //Holds the second closest result according to given budget
        ArrayList<SongEntry> closestSubset = new ArrayList<SongEntry>();

        //counts the number of subsets iterated
        int subCount = 0;

        //Holds the sum of the subset being processed
        double sum = 0;

        //Holds shortest song duration.
        double minDuration = songList.get(0).getDuration();

        //Holds the difference between 'duration' and the current 'sum'
        double diff = duration;

        //Find the total duration in 'songList', and return all songs
        //if the duration is greater than or equal to it. If duration is less than
        // the shortest song, return empty list.
        for(int i = 0; i < songList.size(); i++){
            if(songList.get(i).getDuration() < minDuration){
                minDuration = songList.get(i).getDuration();
            }
            sum += songList.get(i).getDuration();
        }
        if (sum <= duration){
            return songList;
        }

        if(minDuration > duration){
            return temp;
        }

        //This algorithm makes use of bitwise operators to count through the list and create the needed subsets.
        //Number of subsets in a set is given by 2^size, which is the upper bound of the outer loop
        for (int i = 0; i < Math.pow(2, songList.size()); i++) {

            // reinitialize for new iteration
            sum = 0;
            temp.clear();

            //this loop makes use of bitwise operators to make sure that all of the subsets are counted.
            //bitwise operators are helpful here, as the elements in the set correspond to bits in binary numbers.
            for (int j = 0; j < songList.size(); j++) {
                if((i & (1 << j)) > 0){
                    temp.add(songList.get(j));
                    sum += songList.get(j).getDuration();
                    if(sum == duration){
                        System.out.println("Number of subsets created: " + subCount);
                        return temp;
                    }

                }

            }

            //Subset created.
            subCount++;

            //If the total sum of the iterated subset does not equal 'duration', then update 'diff'
            //and remember the current subset as 'closestSubset'.
            //Useful for when there is no exact match found by the search, and we need a second best result.
            if(Math.abs(sum - duration) < diff && (duration-sum) > 0){
                diff = Math.abs(sum - duration);
                closestSubset = (ArrayList<SongEntry>) temp.clone();
            }

        }
        return closestSubset;
    }


}
