package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Course {
    private static int nextId = 1;
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;

    public Course(String courseName, double credits, Department department) {
        this.courseId = "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    public boolean isAssignmentWeightValid() {
        return assignments.stream().mapToDouble(Assignment::getWeight).sum() == 1.0;
    }

    public boolean registerStudent(Student student) {
        if (!registeredStudents.contains(student)) {
            registeredStudents.add(student);
            finalScores.add(null);
            for (Assignment assignment : assignments) {
                assignment.getScores().add(null);
            }
            return true;
        }
        return false;
    }

    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        if (assignments.stream().mapToDouble(Assignment::getWeight).sum() + weight <= 1.0) {
            Assignment newAssignment = new Assignment(assignmentName, weight, maxScore);
            assignments.add(newAssignment);
            for (Student student : registeredStudents) {
                newAssignment.getScores().add(null);
            }
            return true;
        }
        return false;
    }

    public void generateScores() {
        for (Assignment assignment : assignments) {
            for (int i = 0; i < registeredStudents.size(); i++) {
                int score = (int) (Math.random() * (assignment.getMaxScore() + 1));
                assignment.getScores().set(i, score);
            }
            assignment.calcAssignmentAvg();
        }
        calcStudentsAverage();
    }

    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];
        for (int i = 0; i < registeredStudents.size(); i++) {
            double totalWeightedScore = 0;
            for (Assignment assignment : assignments) {
                if (assignment.getScores().get(i) != null) {
                    totalWeightedScore += assignment.getScores().get(i) * assignment.getWeight();
                }
            }
            finalScores.set(i, totalWeightedScore);
            averages[i] = (int) totalWeightedScore;
        }
        return averages;
    }

    public void displayScores() {
        System.out.println("Course: " + courseName + " (" + courseId + ")");
        System.out.print("                    ");
        for (Assignment assignment : assignments) {
            System.out.print(assignment.getAssignmentName() + "   ");
        }
        System.out.println("Final Score");
        for (int i = 0; i < registeredStudents.size(); i++) {
            System.out.print(registeredStudents.get(i).getStudentName() + "          ");
            for (Assignment assignment : assignments) {
                System.out.print(assignment.getScores().get(i) + "             ");
            }
            System.out.println(finalScores.get(i));
        }
    }

    public String toSimplifiedString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", departmentName='" + department.getDepartmentName() + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department.getDepartmentName() +
                ", assignments=" + assignments.size() +
                ", registeredStudents=" + registeredStudents.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Double.compare(credits, course.credits) == 0 &&
                Objects.equals(courseId, course.courseId) &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(department, course.department) &&
                Objects.equals(assignments, course.assignments) &&
                Objects.equals(registeredStudents, course.registeredStudents) &&
                Objects.equals(finalScores, course.finalScores);
    }

    public static int getNextId() {
        return nextId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getCredits() {
        return credits;
    }

    public Department getDepartment() {
        return department;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public ArrayList<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public ArrayList<Double> getFinalScores() {
        return finalScores;
    }

    public static void setNextId(int nextId) {
        Course.nextId = nextId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public void setRegisteredStudents(ArrayList<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public void setFinalScores(ArrayList<Double> finalScores) {
        this.finalScores = finalScores;
    }
}
