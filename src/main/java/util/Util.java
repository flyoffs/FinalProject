package util;

public class Util {

    /**
     * Converts each word in the string to title case.
     *
     * @param strIn The input string.
     * @return The string converted to title case.
     */
    public static String toTitleCase(String strIn) {
        if (strIn == null || strIn.isEmpty()) {
            return strIn;
        }

        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : strIn.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
                titleCase.append(c);
            } else if (nextTitleCase) {
                titleCase.append(Character.toTitleCase(c));
                nextTitleCase = false;
            } else {
                titleCase.append(Character.toLowerCase(c));
            }
        }

        return titleCase.toString();
    }

    public class Student {
        private String studentName;

        public Student(String studentName) {
            this.studentName = Util.toTitleCase(studentName);
        }

        public void setStudentName(String studentName) {
            this.studentName = Util.toTitleCase(studentName);
        }
    }

    public class Department {
        private String departmentName;

        public Department(String departmentName) {
            this.departmentName = Util.toTitleCase(departmentName);
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = Util.toTitleCase(departmentName);
        }
    }

    public class Course {
        private String courseName;

        public Course(String courseName, double credits, Department department) {
            this.courseName = Util.toTitleCase(courseName);
        }

        public void setCourseName(String courseName) {
            this.courseName = Util.toTitleCase(courseName);
        }
    }
}
