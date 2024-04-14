package com.relearn.practice;

import java.util.LinkedList;

public class TrainCompositions {

    private LinkedList<Integer> wagon;

    public TrainCompositions()
    {
        wagon = new LinkedList<Integer>();
    }


    public void attachWagonFromLeft(int wagonId) {

        wagon.addFirst(wagonId);
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public void attachWagonFromRight(int wagonId) {
        wagon.addLast(wagonId);
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public int detachWagonFromLeft() {
        int integer = wagon.removeFirst();
        return integer;
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public int detachWagonFromRight() {
        int node = wagon.removeLast();
        return node;
        //throw new UnsupportedOperationException("Waiting to be implemented.");


    }



    public static void main(String[] args) {
        TrainCompositions train = new TrainCompositions();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}
