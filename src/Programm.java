public class Programm {
    public static String leer = "_";
    private static String[][] aufgabe31 = new String[][]{
            new String[]{leer, leer, leer, leer, leer, leer, leer, "3", leer},
            new String[]{leer, "4", "9", "5", leer, leer, "1", leer, leer},
            new String[]{"3", leer, leer, "4", leer, leer, leer, leer, leer},
            new String[]{"2", leer, leer, leer, leer, leer, leer, "9", leer},
            new String[]{"6", leer, leer, leer, "8", leer, leer, leer, "5"},
            new String[]{leer, leer, "5", "9", "6", leer, leer, leer, "2"},
            new String[]{leer, leer, leer, leer, leer, "1", "8", leer, leer},
            new String[]{leer, leer, leer, leer, leer, leer, "9", "5", leer},
            new String[]{leer, leer, "6", leer, leer, "2", leer, leer, leer},
    };

    private static String[][] lösung22 = new String[][]{
            new String[]{"2", "5", "7", "9", "3", "6", "1", "4", "8"},
            new String[]{"6", "3", "8", "1", "4", "7", "2", "5", "9"},
            new String[]{"4", "1", "9", "2", "8", "5", "3", "7", "6"},
            new String[]{"7", "6", "5", "4", "2", "9", "8", "3", "1"},
            new String[]{"3", "8", "4", "6", "7", "1", "5", "9", "2"},
            new String[]{"9", "2", "1", "8", "5", "3", "7", "6", "4"},
            new String[]{"5", "4", "2", "3", "6", "8", "9", "1", "7"},
            new String[]{"8", "9", "3", "7", "1", "4", "6", "2", "5"},
            new String[]{"1", "7", "6", "5", "9", "2", "4", "8", "3"},
    };

    public static void main(String[] args) {
        String[] lösung = Löser.sudokuReiheLösen(aufgabe31[0]);

        Drucker.sudokuReiheDrucken(lösung);
    }
}
