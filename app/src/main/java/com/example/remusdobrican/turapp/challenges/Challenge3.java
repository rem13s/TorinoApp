package com.example.remusdobrican.turapp.challenges;

/**
 * Created by AL on 1/24/2015.
 */
public class Challenge3 extends Challenge{
    private final String myString= "A";

    //redefining the print method
    public	void	print()	{
        System.out.println(myString);
    }

    public String getMyString() {
        return myString;
    }
}
