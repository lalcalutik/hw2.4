public class LoopChecker implements Checker {

    private static final String ALLOWED_CHARACTERS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890_";

    @Override
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        for (char symbol : chars) {
            if (!ALLOWED_CHARACTERS.contains(Character.toString(symbol))) {
                return false;

            }

        }
        return true;
    }
}