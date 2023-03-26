public class Main {
    public static void main(String[] args) {
        boolean result = Validator.validate("test_123", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        if (result) {
            System.out.println("Логин и пароль корректные");
        } else {
            System.out.println("Логини и/или пароль некорректный");
        }

    }
}