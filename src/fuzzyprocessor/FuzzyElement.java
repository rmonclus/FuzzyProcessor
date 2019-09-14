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

class FuzzyElement {
    
    private String name;
    private int minValue;
    private int maxValue;

    public FuzzyElement(String name, int minValue, int maxValue) throws Exception {
        
        if (minValue > maxValue)
            throw new Exception("Value range is wrong. Minimmum value MUST be lower or equal to maximmum value.");
        
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public String getName() {
        return name;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }    
    
    public String toString() {
        return name + ": " + minValue + "-" + maxValue;
    }
    
    public int getLeftPeakValue() {
        int average = (maxValue + minValue) / 2;
        int leftGap = (average - minValue);
        return minValue + leftGap / 2;
    }
    
    public int getRightPeakValue() {
        int average = (maxValue + minValue) / 2;
        int leftGap = (maxValue - average);
        return maxValue - leftGap / 2;
    }    
    
}
