/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzyprocessor;

/**
 *
 * @author rubisco
 */
public class Solution {
    
    private String name;
    private double probability;

    public Solution(String name, double probability) {
        this.name = name;
        this.probability = probability;
    }

    public String getName() {
        return name;
    }

    public double getProbability() {
        return probability;
    }
    
    
    
}
