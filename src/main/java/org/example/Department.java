package org.example;

import java.util.Objects;

public class Department {
    private static int nextId;
    private String departmentId;
    private String departmentName;

    public Department(String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentId = "D" + String.format("%02d", nextId++);
            this.departmentName = departmentName;
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    public static boolean validateDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }
        for (char c : departmentName.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(departmentName, that.departmentName);
    }

    public static int getNextId() {
        return nextId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public static void setNextId(int nextId) {
        Department.nextId = nextId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
