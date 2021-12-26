public class Application {
    private static String[] alphabet = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private static String leer = "_";
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
        sudokuDrucken(lösung22);

        boolean ergebnis = sudokuReihenPrüfen(lösung22);

        drucken(String.valueOf(ergebnis));
    }

    private static boolean sudokuReihenPrüfen(String[][] sudoku){
        for(int zähler = 0; zähler < sudoku.length; zähler++){
            boolean ergbnisReihe= sudokuReihePrüfen(sudoku[zähler]);

            if(ergbnisReihe == false){
                return false;
            }
        }

        return true;
    }

    private static boolean sudokuReihePrüfen(String[] sudokuReihe) {
        String[] fehlendeZahlen = alphabet;

        for(int zähler = 0; zähler < sudokuReihe.length; zähler++){
            String sudokuZahl = sudokuReihe[zähler];

            for (int fehlendeZahlenZähler = 0 ; fehlendeZahlenZähler < fehlendeZahlen.length; fehlendeZahlenZähler++){
                String fehlendeZahl = fehlendeZahlen[fehlendeZahlenZähler];

                if(sudokuZahl == fehlendeZahl){
                    fehlendeZahlen = entferneZahl(sudokuZahl, fehlendeZahlen);
                    break;
                }
            }
        }

        boolean ergebnis = fehlendeZahlen.length == 0;

        return ergebnis;
    }

    private static String[] entferneZahl(String sudokuZahl, String[] fehlendeZahlen){
        if(fehlendeZahlen.length == 0){
            return new String[]{};
        }

        int ergebnisZähler = 0;
        String[] ergbenis = new String[fehlendeZahlen.length -1];
        for (int zähler = 0 ; zähler < fehlendeZahlen.length; zähler++){
            String fehlendeZahl = fehlendeZahlen[zähler];
            if(fehlendeZahl != sudokuZahl){
                ergbenis[ergebnisZähler] = fehlendeZahl;
                ergebnisZähler++;
            }
        }

        return ergbenis;
    }

    private static void sudokuDrucken(String[][] sudoku) {
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

    private static void drucken(String text) {
        System.out.print(text);
    }

    private static void neueReiheDrucken() {
        System.out.println();
    }
}
