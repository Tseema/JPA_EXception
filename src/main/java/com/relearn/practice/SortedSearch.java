package com.relearn.practice;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntPredicate;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int count = 0;
       /* IntPredicate pr = nbr -> nbr < lessThan;
         count = (int) Arrays.stream(sortedArray).filter(pr).count();
        System.out.println(count);
*/
       int first = 0,last =sortedArray.length -1, mid = (first+last)/2;
       if(lessThan==sortedArray[mid]){
           return 1;
       }

        while(first < last){
               if( lessThan < sortedArray[mid]){
                   count++;
                   last=mid-1;
               }
                if(  lessThan > sortedArray[mid]){
                    first=mid+1;
                    count++;
                }
            mid=(first+last)/2;
        }
        if(  lessThan > sortedArray[mid]){
            count =count+ mid;
        }

        return count;
        // throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3,4, 5, 7,8 }, 6));
    }
}
