package skillonomy;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skillonomy.exceptions.NotEnoughMoneyException;
import skillonomy.exceptions.NotEnoughTokensException;
import skillonomy.models.User;


public class PlatformTests extends TestCase {

    public static final double amount = 0;
    public static User user = null;

    @Override
    @BeforeEach
    protected void setUp() throws Exception {
        user = new User("test", "test");
    }

    @Test
    public void buy_tokens_successfully() {
        double money = user.tokensToMoney(amount);
        user.addMoney(money);

        user.buyTokens(amount);

        assertEquals(amount, user.tokens());
    }

    @Test
    public void fail_buy_tokens_not_enough_money() {
        double money = user.tokensToMoney(amount);
        user.addMoney(money);

        Assertions.assertThrows(
            NotEnoughMoneyException.class,
            () -> user.buyTokens(amount + 1)
        );
    }

    @Test
    public void sell_tokens_successfully() {
        user.addTokens(amount);

        user.sellTokens(amount);

        assertEquals(amount * user.exchangeRate(), user.money());
    }

    @Test
    public void fail_sell_tokens_not_enough_tokens() {
        user.addTokens(amount);

        Assertions.assertThrows(
            NotEnoughTokensException.class,
            () -> user.sellTokens(amount + 1)
        );
    }

    @Test
    public void transfer_money_successfully() {
        user.addMoney(amount);
        User another = new User("Another", "user");

        user.transferMoney(another, amount);

        assertEquals(0.0, user.money());
        assertEquals(amount, another.money());
    }

    @Test
    public void fail_transfer_money_not_enough_money() {
        user.addMoney(amount);
        User another = new User("Another", "user");

        Assertions.assertThrows(
            NotEnoughMoneyException.class,
            () -> user.transferMoney(another, amount + 1)
        );
    }

    @Test
    public void transfer_tokens_successfully() {
        user.addTokens(amount);
        User another = new User("Another", "user");

        user.transferTokens(another, amount);

        assertEquals(0.0, user.tokens());
        assertEquals(amount, another.tokens());
    }

    @Test
    public void fail_transfer_tokens_not_enough_tokens() {
        user.addTokens(amount);
        User another = new User("Another", "user");

        Assertions.assertThrows(
            NotEnoughTokensException.class,
            () -> user.transferTokens(another, amount + 1)
        );
    }
}
