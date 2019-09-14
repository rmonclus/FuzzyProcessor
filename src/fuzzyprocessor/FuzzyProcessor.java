/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzyprocessor;

import java.util.ArrayList;

/**
 * FuzzyProcessor. This class provides a simple fuzzy logic implementation. It
 handles an ArrayList of FuzzyElement, which contains an element from a fuzzy
 set and its edge values. This class calculates the probability of a FuzzyProcessor
 belonging one or another fuzzy element by itself.
 *
 * @author rmonclus
 *
 * @version 1.0.0
 *
 *
 */
public class FuzzyProcessor {

    private ArrayList<FuzzyElement> elements;

    public FuzzyProcessor() {
        elements = new ArrayList<>();
    }

    /**
     * Creates a new FuzzyElement and inserts it into the ArrayList of
 FuzzyProcessor.
     *
     * @param name The name of the fuzzy element.
     * @param minValue The lower edge of the fuzzy element.
     * @param maxValue The highest edfe of the fuzzy element.
     * @throws Exception in case minValue is greater than maxValue.
     */
    public void insert(String name, int minValue, int maxValue) throws Exception {
        int pos = getPos(minValue);
        if (pos == -1) {
            elements.add(new FuzzyElement(name, minValue, maxValue));
        } else {
            elements.add(pos, new FuzzyElement(name, minValue, maxValue));
        }
    }


    private int getPos(int minValue) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getMaxValue() > minValue) {
                return i + 1;
            }
        }

        return -1;
    }

    /**
     * Shows the content of the ArrayList of elements of the fuzzy set. 
     */
    public void show() {
        for (FuzzyElement s : elements) {
            System.out.println(s);
        }
    }

    /**
     * Determines which fuzzy element the FuzzyProcessor belongs to. 
     * 
     * @param value The FuzzyProcessor we want to now which fuzzy element belongs to.
     * @return ArrayList of Solution
     */
    public ArrayList<Solution> belongsTo(int value) {

        ArrayList<FuzzyElement> candidates = new ArrayList<>();
        for (FuzzyElement s : elements) {
            if (value >= s.getMinValue() && value <= s.getMaxValue()) {
                candidates.add(s);
            }
        }

        if (candidates.size() == 0) {
            return null;
        }

        ArrayList<Solution> solution = new ArrayList<>();

        if (candidates.size() == 1) {
            System.out.println(">>> CASE 1");
            solution.add(new Solution(candidates.get(0).getName(), 1));
        } else if (value < candidates.get(1).getMinValue()) {
            System.out.println(">>> CASE 2");
            solution.add(new Solution(candidates.get(0).getName(), 1));
        } else if (value > candidates.get(0).getMaxValue()) {
            System.out.println(">>> CASE 3");
            solution.add(new Solution(candidates.get(1).getName(), 1));
        } else { //candidates.size SHOULD be 2. Else there must be an error
            double a = candidates.get(1).getMinValue() - 1;
            double b = candidates.get(0).getMaxValue() + 1;
            double probability = 1 - ((a - value) / (a - b));

            if (probability == 1) {
                solution.add(new Solution(candidates.get(0).getName(), 1));
            } else if (probability == 0) {
                solution.add(new Solution(candidates.get(1).getName(), 1));
            } else {
                System.out.println("> " + a + " " + b + " " + value + " " + probability);
                solution.add(new Solution(candidates.get(0).getName(), probability));
                solution.add(new Solution(candidates.get(1).getName(), 1 - probability));
            }

        }

        return solution;
    }

}
