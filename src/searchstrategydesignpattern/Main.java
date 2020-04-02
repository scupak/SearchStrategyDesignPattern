package searchstrategydesignpattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
        
        Main main = new Main();
        main.performsearch(1000, new SequentialSearch(), new Car("brand", "model", "color", 50000000));
        main.performsearch(10000, new SequentialSearch(), new Car("brand", "model", "color", 50000000));
        main.performsearch(100000, new SequentialSearch(), new Car("brand", "model", "color", 50000000));
        main.performsearch(4000000, new SequentialSearch(), new Car("brand", "model", "color", 50000000));
        main.performsearch(10000000, new SequentialSearch(), new Car("brand", "model", "color", 50000000));
      
        System.out.println(".............................................................................................");
        
        main.performsearch(1000, new binarysearch(), new Car("brand", "model", "color", 50000000));
        main.performsearch(10000, new binarysearch(), new Car("brand", "model", "color", 50000000));
        main.performsearch(100000, new binarysearch(), new Car("brand", "model", "color", 50000000));
        main.performsearch(4000000, new binarysearch(), new Car("brand", "model", "color", 50000000));
        main.performsearch(10000000, new binarysearch(), new Car("brand", "model", "color", 50000000));
        
        
         System.out.println(".............................................................................................");
         
         main.hashsearch(1000, new Car("brand", "model", "color", 50000000));
         main.hashsearch(10000, new Car("brand", "model", "color", 50000000));
         main.hashsearch(100000, new Car("brand", "model", "color", 50000000));
         main.hashsearch(4000000, new Car("brand", "model", "color", 50000000));
         main.hashsearch(10000000, new Car("brand", "model", "color", 50000000));
        
    }
    
    
    public void performsearch(int size, ISearchStrategy strategy, Car wanted){
    
         //Performance measurement
        final int SIZE = size;
        List<Car> objects = new ArrayList<>();
        System.out.println("Loading strings into list...");
        
        for (int i = 0; i < SIZE; i++) {
            objects.add(new Car("bwv", "300","blue", i));            
        }
        
       
        
        System.out.println("Done loading...");

        Collections.sort(objects); //lets sort the list (binary search requires that)    
        
         objects.add(wanted); //add it last to get worst case performance time
        
        
        //create a new Searcher object with a search strategy of SequentialSearch
        Searcher s = new Searcher(strategy);
                
        long start = System.nanoTime();
        
        
        int result = s.executeSearch(objects, wanted);       
        //int result = Collections.binarySearch(objects, wanted);
        
        
        long stop = System.nanoTime();
        double elapsedTime = (stop - start) / 1000000.0; //converting from nano to ms
                
        System.out.println("Time elapsed: " + elapsedTime + " ms");        
        System.out.println("Search result "+ strategy.toString() +": index:" + result + " ("+ objects.get(result) + ")");
        
    
    
    
    
    
    }
    
    public void hashsearch(int size,  Car wanted){
      //Performance measurement
        final int SIZE = size;
       HashMap<Integer,Car> carmap = new HashMap<>();
        System.out.println("Loading strings into list...");
        
        for (int i = 0; i < SIZE; i++) {
            carmap.put(i, new Car("bwv", "300","blue", i));
        }
        
       
        
        System.out.println("Done loading...");

     carmap.put(10, wanted);
        
         
        
        
        
                
        long start = System.nanoTime();
        
        
        Car result = carmap.get(10);
        //int result = Collections.binarySearch(objects, wanted);
        
        
        long stop = System.nanoTime();
        double elapsedTime = (stop - start) / 1000000.0; //converting from nano to ms
                
        System.out.println("Time elapsed: " + elapsedTime + " ms");        
        System.out.println("Search result hashmap index:" + result + " ("+ SIZE + ")");
        
    
    
    
    
    }
}
