package skillonomy;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skillonomy.exceptions.NotEnoughTokensException;
import skillonomy.models.User;


public class StudentTests extends TestCase {

    public static final int amount = 5;
    public static final double tuitionFee = 4.0;
    public static User student = null;

    @Override
    @BeforeEach
    protected void setUp() throws Exception {
        student = new User("test", "test");
        for (int i = 0; i < amount; i++) {
            student.addCoach(
                new User("test", "test"),
                tuitionFee
            );
        }
    }

    @Test
    public void test_pay_tuition_fee() {
        double money = amount * tuitionFee;
        double tokens = student.moneyToTokens(money) + 1.0;
        student.addTokens(tokens);

        student.payTuitionFee();

        for (var coach : student.teachers()
                                .keySet()) {
            assertTrue(coach.money() > 0.0);
        }
    }

    @Test
    public void test_fail_pay_not_enough_tokens() {
        double money = amount * tuitionFee;
        double tokens = student.moneyToTokens(money) - 1.0;
        student.addTokens(tokens);

        Assertions.assertThrows(
            NotEnoughTokensException.class,
            () -> student.payTuitionFee()
        );
    }
}
