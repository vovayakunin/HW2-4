package myexceptions;

public class Main {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";

    public static void main(String[] args) {
        try {
            check("vov4ik", "123","123");
            System.out.println("провека пройдена");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("содержание логина неверна");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("размер логина не должен быть 20");
        }
        if (!password.matches(REGEX)) {
            throw new WrongPasswordException("содержание пароля неверна");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("размер пароля не должен быть 20");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("пароли не совпадают");
        }
    }
}