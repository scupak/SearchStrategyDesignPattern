package searchstrategydesignpattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author spangsberg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Performance measurement
        final int SIZE = 80_000_000;
        List<String> objects = new ArrayList<>();
        System.out.println("Loading strings into list...");
        
        for (int i = 0; i < SIZE; i++) {
            objects.add(new String("A string #" + i));            
        }
        String wanted = "The string I'm looking for";
        objects.add(wanted); //add it last to get worst case performance time
        
        System.out.println("Done loading...");

        Collections.sort(objects); //lets sort the list (binary search requires that)    
        
        //create a new Searcher object with a search strategy of SequentialSearch
        Searcher s = new Searcher(new SequentialSearch());
                
        long start = System.nanoTime();
        
        
        int result = s.executeSearch(objects, wanted);       
        //int result = Collections.binarySearch(objects, wanted);
        
        
        long stop = System.nanoTime();
        double elapsedTime = (stop - start) / 1000000.0; //converting from nano to ms
                
        System.out.println("Time elapsed: " + elapsedTime + " ms");        
        System.out.println("Search result (Sequential Search): index:" + result + " ("+ objects.get(result) + ")");
        
        //FIXME: change strategy to binary search and re-test
    }
}
