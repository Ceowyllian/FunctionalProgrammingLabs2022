package skillonomy;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skillonomy.models.User;


public class CoachTests extends TestCase {

    public static final int amount = 10;
    public static User coach = null;

    @Override
    @BeforeEach
    protected void setUp() throws Exception {
        coach = new User("test", "test");
        for (int i = 0; i < amount; i++) {
            coach.addStudent(new User("test", "test"));
        }
    }

    @Test
    public void test_set_points() {
        coach.setPoints();

        for (var student : coach.students()
                                .keySet()) {
            int points = (int) coach.students()
                                    .get(student);
            assertTrue(points > 0);
        }
    }

    @Test
    public void test_distribute_tokens() {
        coach.addTokens(amount * 5);

        coach.setPoints();
        coach.distributeTokens();

        for (var student : coach.students()
                                .keySet()) {
            double tokens = student.tokens();
            boolean condition = tokens > 0.0;
            assertTrue(condition);
        }
    }
}
