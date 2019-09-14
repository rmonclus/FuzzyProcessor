/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzyprocessor;

/**
 * This class provides a Solution, which is a fuzzy element where the given number may belong
 * and the probability of belonging to it.
 * 
 * @author rmonclus
 * @version 1.0.0
 */
public class Solution {
    
    private String name;
    private double probability;

    public Solution(String name, double probability) {
        this.name = name;
        this.probability = probability;
    }

    /**
     * 
     * @return The name of the solution
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return The probability of the solution
     */
    public double getProbability() {
        return probability;
    }
    
    
    
}
