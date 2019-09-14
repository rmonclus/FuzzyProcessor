# FuzzyProcessor
A simple fuzzy logic implementation to use in graphic user interfaces projects.

This package provides a simple fuzzy logic implementation and all the structures that are needed to make it usable. The package handles an ArrayList of (private class) FuzzyElement, which contains an element from a fuzzy set and its edge values. FuzzyProcessor calculates by itself the probability of a number belonging one or another fuzzyElement.

Public classes are FuzzyProcessor, which is the main class of the project, and Solution. At the end of the project I thought of removing the Solution class and making FuzzyProcessor to return a Object[][], having pairs like {String name, Double probability}, but it would be more complicated for the teaching purposes of this project, which is, basicly, a technical solution that must be attached to the GUI that students have to design.

There is another class, FuzzyElement, that is private and contains the different sections of the fuzzy schema. Initially it was a public class, but I found that it would be easier to work with separated atomic arguments instead of instances of a class like FuzzyElement, which can be handled internally.
