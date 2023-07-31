import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredUnderLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 1500;
        boolean registered = false;
        long expected = 15;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndAmountZero() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 0;
        boolean registered = true;
        long expected = 0;

        //вызываем целевой метод
        long actual = service.calculate(amount, registered);

        //производим проверку (сравниваем ожидаемый и фактический)
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndAmountZero() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 0;
        boolean registered = false;
        long expected = 0;

        //вызываем целевой метод
        long actual = service.calculate(amount, registered);

        //производим проверку (сравниваем ожидаемый и фактический)
        Assertions.assertEquals(expected, actual);
    }

}
