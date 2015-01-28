package com.example.remusdobrican.turapp.challenges;

/**
 * Created by AL on 1/24/2015.
 */

import	java.util.List;
import	java.util.ArrayList;
import java.util.Random;

public class CompositeChallenge extends Challenge {

    private	List<Challenge>	challengeList	=	new	ArrayList<Challenge>(); //Collection	of	child	challenges
    private String finalMystery; // contains the string for the final mystery

    //Prints the entire list of challenges
    public	void	print()	{
        for	(Challenge	myChallenge: challengeList)	{
            myChallenge.print();
        }
    }
    //Adds	the	graphic	to	the	composition.
    public	void	add(Challenge challenge)	{
        challengeList.add(challenge);
        finalMystery += challenge;
    }
    //Removes	the	graphic	from	the	composition.
    public	void	remove(Challenge challenge)	{
        challengeList.remove(challenge);
    }

    // gets a challenge from the challengeList in random order and then removes it from the list
    public Challenge getRandomChallenge(){
        Random rd = new Random();
        Challenge challenge = challengeList.get(rd.nextInt(challengeList.size()));
        this.remove(challenge);
        return challenge;
    }

    public String getFinalMystery() {
        return finalMystery;
    }
}
