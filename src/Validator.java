import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Validator {

    private Validator() {

    }

    public static boolean validate(String login, String password, String confirmPassword) {

        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static void check(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Длина логина не должна превышать 20 символов.");
        }
        if (Objects.isNull(password) || password.length() >= 20) {
            throw new WrongPasswordException("Пароль не должен превышать 19 символов.");
        }
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли должны совпадать.");
        }
        Checker checker = ThreadLocalRandom.current().nextBoolean() ?
                new LoopChecker() :
                new RegexChecker();

        if(!checker.isValid(login)) {
            throw new WrongLoginException("Логин содержит некорректные символы");
        }
        if(!checker.isValid(login)) {
            throw new WrongLoginException("Пароль содержит некорректные символы");
        }

    }
}
