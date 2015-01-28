package com.example.remusdobrican.turapp.challenges;

/**
 * Created by AL on 1/24/2015.
 */
public class Challenge2 extends Challenge{
    private final String myString= "I";

    //redefining the print method
    public	void	print()	{
        System.out.println(myString);
    }

    public String getMyString() {
        return myString;
    }
}
