package util;

public class Calc {
    public static int fact(int i) {
        return i <= 1 ? 1 : i * fact(i - 1);
    }
}
