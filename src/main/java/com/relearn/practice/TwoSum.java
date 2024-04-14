package com.relearn.practice;

import java.sql.Array;
import java.util.*;


public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {

        Map<Integer,Integer> map = new HashMap();
        int diff= 0;
        for(int i =0;i<list.length;i++){
            diff = sum-list[i];
           if(map.containsKey(diff)){
               return new int[]{map.get(diff),i};
           }
           map.put(list[i],i);
        }

        //throw new UnsupportedOperationException("Waiting to be implemented.");


        return list;
    }

    /*
    7 - 0 - 3
    9 - 1 - 1
    5 - 2 - 5
    3 - 3 - 7
    5
    1
     */
    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
