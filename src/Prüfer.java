public class Prüfer {
    public static String[] alphabet = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static boolean sudokuPrüfen(String[][] sudoku) {
        boolean reihenOk = sudokuReihenPrüfen(sudoku);
        boolean spaltenOk = sudokuSpaltenPrüfen(sudoku);
        boolean sektorenOk = sudokuSektorenPrüfen(sudoku);

        return reihenOk && spaltenOk && sektorenOk;
    }

    public static boolean sudokuSektorenPrüfen(String[][] sudoku) {
        String[][] fehlendeZahlenProSektor = fehlendeZahlenMatrix();

        for (int reihenZähler = 0; reihenZähler < sudoku.length; reihenZähler++) {
            String[] sudokuReihe = sudoku[reihenZähler];
            for (int spaltenZähler = 0; spaltenZähler < sudokuReihe.length; spaltenZähler++) {
                String zahl = sudokuReihe[spaltenZähler];

                int sektorZähler = sektorNummer(reihenZähler, spaltenZähler);

                String[] fehlendeZahlenInSektor = fehlendeZahlenProSektor[sektorZähler];
                for (int fehlendeZahlenZähler = 0; fehlendeZahlenZähler < fehlendeZahlenInSektor.length; fehlendeZahlenZähler++) {
                    String fehlendeZahl = fehlendeZahlenInSektor[fehlendeZahlenZähler];

                    if (zahl == fehlendeZahl) {
                        fehlendeZahlenProSektor[sektorZähler] = entferneZahl(zahl, fehlendeZahlenInSektor);
                        break;
                    }
                }
            }
        }

        return prüfeFehlendeZahlenMatrix(fehlendeZahlenProSektor);
    }

    public static int sektorNummer(int reihe, int spalte) {
        if (spalte < 3 && reihe < 3) {
            return 0;
        }

        if (spalte < 6 && reihe < 3) {
            return 1;
        }

        if (spalte < 9 && reihe < 3) {
            return 2;
        }

        if (spalte < 3 && reihe < 6) {
            return 3;
        }

        if (spalte < 6 && reihe < 6) {
            return 4;
        }

        if (spalte < 9 && reihe < 6) {
            return 5;
        }

        if (spalte < 3 && reihe < 9) {
            return 6;
        }

        if (spalte < 6 && reihe < 9) {
            return 7;
        }

        if (spalte < 9 && reihe < 9) {
            return 8;
        }

        return -1;
    }

    public static boolean sudokuSpaltenPrüfen(String[][] sudoku) {
        String[][] fehlendeZahlenProSpalte = fehlendeZahlenMatrix();

        for (int reihenZähler = 0; reihenZähler < sudoku.length; reihenZähler++) {
            String[] sudokuReihe = sudoku[reihenZähler];
            for (int spaltenZähler = 0; spaltenZähler < sudokuReihe.length; spaltenZähler++) {
                String zahl = sudokuReihe[spaltenZähler];

                String[] fehlendeZahlenInSpalte = fehlendeZahlenProSpalte[spaltenZähler];
                for (int fehlendeZahlenZähler = 0; fehlendeZahlenZähler < fehlendeZahlenInSpalte.length; fehlendeZahlenZähler++) {
                    String fehlendeZahl = fehlendeZahlenInSpalte[fehlendeZahlenZähler];

                    if (zahl == fehlendeZahl) {
                        fehlendeZahlenProSpalte[spaltenZähler] = entferneZahl(zahl, fehlendeZahlenInSpalte);
                        break;
                    }
                }
            }
        }

        return prüfeFehlendeZahlenMatrix(fehlendeZahlenProSpalte);
    }

    public static String[][] fehlendeZahlenMatrix() {
        return new String[][]{
                alphabet,
                alphabet,
                alphabet,
                alphabet,
                alphabet,
                alphabet,
                alphabet,
                alphabet,
                alphabet
        };
    }

    public static boolean prüfeFehlendeZahlenMatrix(String[][] fehlendeZahlenMatrix) {
        for (int zähler = 0; zähler < fehlendeZahlenMatrix.length; zähler++) {
            if (fehlendeZahlenMatrix[zähler].length > 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean sudokuReihenPrüfen(String[][] sudoku) {
        for (int zähler = 0; zähler < sudoku.length; zähler++) {
            boolean ergbnisReihe = sudokuReihePrüfen(sudoku[zähler]);

            if (ergbnisReihe == false) {
                return false;
            }
        }

        return true;
    }

    public static boolean sudokuReihePrüfen(String[] sudokuReihe) {
        String[] fehlendeZahlen = alphabet;

        for (int zähler = 0; zähler < sudokuReihe.length; zähler++) {
            String sudokuZahl = sudokuReihe[zähler];

            for (int fehlendeZahlenZähler = 0; fehlendeZahlenZähler < fehlendeZahlen.length; fehlendeZahlenZähler++) {
                String fehlendeZahl = fehlendeZahlen[fehlendeZahlenZähler];

                if (sudokuZahl == fehlendeZahl) {
                    fehlendeZahlen = entferneZahl(sudokuZahl, fehlendeZahlen);
                    break;
                }
            }
        }

        boolean ergebnis = fehlendeZahlen.length == 0;

        return ergebnis;
    }

    public static String[] entferneZahl(String sudokuZahl, String[] fehlendeZahlen) {
        if (fehlendeZahlen.length < 1) {
            return fehlendeZahlen;
        }

        int ergebnisZähler = 0;
        String[] ergbenis = new String[fehlendeZahlen.length - 1];
        for (int zähler = 0; zähler < fehlendeZahlen.length; zähler++) {
            String fehlendeZahl = fehlendeZahlen[zähler];
            if (fehlendeZahl != sudokuZahl) {
                if (ergebnisZähler == ergbenis.length) {
                    return fehlendeZahlen;
                }

                ergbenis[ergebnisZähler] = fehlendeZahl;
                ergebnisZähler++;
            }
        }

        return ergbenis;
    }
}
