package com.relearn.practice;

public class UserInput {

    public static class TextInput {
        StringBuilder currval = new StringBuilder();


        public void add(char text){

            currval.append(text);
        }

        public String getValue(){
            return currval.toString();
        }
    }

    public static class NumericInput extends TextInput {
        @Override
        public void add(char text) {
            if (!Character.isLetter(text)) {
                currval.append(text);
            }
        }

    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}



