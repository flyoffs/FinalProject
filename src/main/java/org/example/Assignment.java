package org.example;

import java.util.ArrayList;

public class Assignment {
    private static int nextId = 1;
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private ArrayList<Integer> scores;

    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentId = "A" + nextId++;
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
        this.scores = new ArrayList<>();
    }

    public void calcAssignmentAvg() {
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        assignmentAverage = scores.isEmpty() ? 0 : sum / scores.size();
    }

    public void generateRandomScore(int studentCount) {
        scores.clear();  // Clear existing scores before generating new ones
        for (int i = 0; i < studentCount; i++) {
            int randomFactor = (int) (Math.random() * 11);  // Random number between 0 and 10
            int score;
            if (randomFactor == 0) {
                score = (int) (Math.random() * 60);  // Score between 0 and 59
            } else if (randomFactor <= 2) {
                score = 60 + (int) (Math.random() * 10);  // Score between 60 and 69
            } else if (randomFactor <= 4) {
                score = 70 + (int) (Math.random() * 10);  // Score between 70 and 79
            } else if (randomFactor <= 8) {
                score = 80 + (int) (Math.random() * 10);  // Score between 80 and 89
            } else {
                score = 90 + (int) (Math.random() * 11);  // Score between 90 and 100
            }
            scores.add(score);
        }
        calcAssignmentAvg();
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", maxScore=" + maxScore +
                ", assignmentAverage=" + assignmentAverage +
                ", scores=" + scores +
                '}';
    }

    public static int getNextId() {
        return nextId;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public double getAssignmentAverage() {
        return assignmentAverage;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public static void setNextId(int nextId) {
        Assignment.nextId = nextId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public void setAssignmentAverage(double assignmentAverage) {
        this.assignmentAverage = assignmentAverage;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }
}
