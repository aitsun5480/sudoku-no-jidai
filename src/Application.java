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

        sudokuDrucken(sudoku);
    }

    private static void sudokuDrucken(String[][] sudoku){
        for (int zähler = 0; zähler < 9; zähler = zähler + 1) {
            sudokuReiheDrucken(sudoku[zähler]);

            if (zähler == 2 || zähler == 5) {
                drucken("=======================");
                neueReiheDrucken();
            }
        }
    }

    private static void sudokuReiheDrucken(String[] sudokuReihe) {
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

    private static void drucken(String text){
        System.out.print(text);
    }

    private static void neueReiheDrucken(){
        System.out.println();
    }
}
