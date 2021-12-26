public class Drucker {
    public static void sudokuDrucken(String[][] sudoku) {
        for (int zähler = 0; zähler < 9; zähler = zähler + 1) {
            sudokuReiheDrucken(sudoku[zähler]);

            if (zähler == 2 || zähler == 5) {
                drucken("=======================");
                neueReiheDrucken();
            }
        }
    }

    public static void sudokuReiheDrucken(String[] sudokuReihe) {
        for (int zähler = 0; zähler < 9; zähler++) {
            drucken(sudokuReihe[zähler]);

            if (zähler == 2 || zähler == 5) {
                drucken(" || ");
            } else {
                if (zähler < 8) {
                    drucken(" ");
                }
            }
        }
        neueReiheDrucken();
    }

    public static void drucken(String text) {
        System.out.print(text);
    }

    public static void neueReiheDrucken() {
        System.out.println();
    }
}
