package Primero_DAM.Practica5.Ejercicio2;

public class ConsoleColors {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static String colorize(String text, String color) {
        return color + text + RESET;
    }

    public static String red(String text) {
        return colorize(text, RED);
    }

    public static String green(String text) {
        return colorize(text, GREEN);
    }

    public static String yellow(String text) {
        return colorize(text, YELLOW);
    }

}

