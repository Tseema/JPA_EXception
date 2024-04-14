package com.relearn.practice;

import java.util.Arrays;

import java.util.stream.Stream;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {

        return Stream.concat(Arrays.stream(names1), Arrays.stream(names2)).distinct().toArray(String[]::new);



      /*  Set<String> arr1 = new HashSet<>();
        for (String elm:names1
             ) {
            if(!arr1.contains(elm)){
                arr1.add(elm);
            }
        }

        for (String elm:names2
        ) {
            if(!arr1.contains(elm)){
                arr1.add(elm);
            }
        }
        System.out.println(arr1);
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        String[] y = arr1.toArray(new String[0]);
        for (String elm:y
             ) {
            System.out.println(elm);
        }
        return y;
*/

    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}