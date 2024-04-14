package com.relearn.practice;

import java.util.*;

public class RoutePlanner {
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
        boolean[][] mapVisited = new boolean[mapMatrix.length][mapMatrix[0].length];

        return routeSearch(fromRow, fromColumn, toRow, toColumn,mapMatrix, mapVisited);

    }

    public static boolean routeSearch(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix, boolean[][] mapVisited) {


        if(fromRow < 0 || fromColumn < 0 || fromRow >= mapMatrix.length || fromColumn >= mapMatrix[0].length)
            return false;


        if(mapVisited[fromRow][fromColumn] || !mapMatrix[fromRow][fromColumn]
                || !mapMatrix[toRow][toColumn])
            return false;

        if(fromRow == toRow && fromColumn == toColumn)
            return true;

        mapVisited[fromRow][fromColumn] = true;

        return routeSearch(fromRow-1, fromColumn, toRow, toColumn, mapMatrix, mapVisited)
                || routeSearch(fromRow, fromColumn-1, toRow, toColumn, mapMatrix, mapVisited)
                || routeSearch(fromRow+1, fromColumn, toRow, toColumn, mapMatrix, mapVisited)
                ||routeSearch(fromRow, fromColumn+1, toRow, toColumn, mapMatrix, mapVisited);
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true, false, false, true},
                {true, true, true, true},
                {false, true, false, true}
        };
        System.out.println(routeExists(0, 0, 2, 3, mapMatrix));
    }
}
