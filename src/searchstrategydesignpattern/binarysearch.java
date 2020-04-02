/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchstrategydesignpattern;

import java.util.List;

/**
 *
 * @author anton
 */
public class binarysearch implements ISearchStrategy {

    @Override
    public <T extends Comparable<T>> int doSearch(List<T> objects, T wanted) {
        
        int low = 0; 
        int high = objects.size() -1;
        
        while(low < high){
        
            int m = low / 2 + high / 2;
            
            if(objects.get(m).compareTo(wanted) >= 0){
            
                high = m; 
            
            
            }
            else{
            
                low = m + 1 ;
            
            }
       
        }
        return (objects.get(high).compareTo(wanted) == 0 ? high : (-1));
        
        
        
       
    }
    
    
    
    
}
