package com.divya.spring.datajpa.project4;

public class ConvertToHexNumber {

    public static void main(String[] args)
    {
        // Input string
        String str = args[0];
        if(str == null) {
            System.out.println("Need input to check");
            return;
        }
        try {
            Integer convert = Integer.parseInt(args[0]);
            System.out.println("Hex number for a given integer "+convert*(2*convert - 1));
        }catch (NumberFormatException numberFormatException){
            System.out.println("Can only take integer as input");
        }
    }
}
