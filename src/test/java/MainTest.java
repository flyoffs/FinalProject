import org.junit.jupiter.api.Test;

public class MainTest {

    public class AssignmentTest {

        @Test
        public void testCalcAssignmentAvg() {
            Assignment assignment = new Assignment("Math", 0.4, 100);
            assignment.getScores().addAll(Arrays.asList(80, 90, 100));
            assignment.calcAssignmentAvg();
            Assertions.assertEquals(90.0, assignment.getAssignmentAverage(), "The calculated average should be 90.0");
        }
    }

    public class AssignmentTest {

        @Test
        public void testIsAssignmentsTotalWeightValid() {
            Course course = new Course("Science", 4, new Department("D01", "Biology"));
            course.addAssignment("Test 1", 0.5, 100);
            course.addAssignment("Test 2", 0.5, 100);
            Assertions.assertTrue(course.isAssignmentWeightValid());
            Assertions.assertFalse(course.addAssignment("Test 3", 0.1, 100));  // This should fail as total weight would exceed 1.0
        }
    }

    public class CourseTest {

        @Test
        public void testCalcStudentsAverage() {
            Course course = new Course("Math", 3, new Department("D02", "Mathematics"));
            Student student1 = new Student("John Doe");
            Student student2 = new Student("Jane Doe");
            course.registerStudent(student1);
            course.registerStudent(student2);
            course.addAssignment("Quiz", 0.5, 100);
            course.addAssignment("Final", 0.5, 100);

            // Set scores manually for testing
            course.getAssignments().get(0).getScores().set(0, 80);  // Quiz scores for John
            course.getAssignments().get(0).getScores().set(1, 90);  // Quiz scores for Jane
            course.getAssignments().get(1).getScores().set(0, 70);  // Final scores for John
            course.getAssignments().get(1).getScores().set(1, 85);  // Final scores for Jane

            int[] averages = course.calcStudentsAverage();
            Assertions.assertEquals(75, averages[0]);
            Assertions.assertEquals(87, averages[1]);
        }
    }

    public class UtilTest {

        @Test
        public void testToTitleCase() {
            String input = "muhammad chaudhry";
            String expected = "Muhammad Chaudhry";
            String result = Util.toTitleCase(input);
            Assertions.assertEquals(expected, result);

            input = "hello world";
            expected = "Hello World";
            result = Util.toTitleCase(input);
            Assertions.assertEquals(expected, result);
        }
    }
}
