public class Application {
    public static void main(String[] args) {
        String leer = "_";

        String[][] sudoku = new String[][]{
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

        for (int zähler = 0; zähler < 9; zähler = zähler + 1) {
            sudokuReiheDrucken(sudoku[zähler]);

            if (zähler == 2 || zähler == 5) {
                System.out.println("=======================");
            }
        }
    }

    private static void sudokuReiheDrucken(String[] sudokuReihe) {
        for (int zähler = 0; zähler < 9; zähler++) {
            System.out.print(sudokuReihe[zähler]);

            if (zähler == 2 || zähler == 5) {
                System.out.print(" || ");
            } else {
                if (zähler < 8) {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }
}
