public class Löser {
    public static String[][] sudokuLösen(String[][] aufgabe) {
        for (int zähler =  0; Prüfer.sudokuPrüfen(aufgabe) != true; zähler++) {
            String[][][] lösungsMatrix = sudokuLösungsMatrixInitialisieren(aufgabe);

            lösungsMatrix = sudokuReihenLösen(lösungsMatrix);
            lösungsMatrix = sudokuSpaltenLösen(lösungsMatrix);
            lösungsMatrix = sudokuSektorenLösen(lösungsMatrix);

            aufgabe = lösungBekommen(lösungsMatrix);

            Drucker.drucken("Schritt "+ zähler);
            Drucker.neueReiheDrucken();
            Drucker.sudokuDrucken(aufgabe);
        }

        return aufgabe;
    }

    private static String[][][] sudokuSektorenLösen(String[][][] lösungsMatrix) {
        for (int reihenZähler = 0; reihenZähler < lösungsMatrix.length; reihenZähler++) {
            String[][] reihe = lösungsMatrix[reihenZähler];
            for (int spaltenZähler = 0; spaltenZähler < reihe.length; spaltenZähler++) {
                String[][] sektor = sudokuSektorBekommen(lösungsMatrix, Prüfer.sektorNummer(reihenZähler, spaltenZähler));

                String[] möglicheLösungen = reihe[spaltenZähler];
                if (möglicheLösungen.length > 1) {
                    lösungsMatrix[reihenZähler][spaltenZähler] = entferneAlleBekanntenZahlen(möglicheLösungen, sektor);
                }
            }
        }

        return lösungsMatrix;
    }

    private static String[][] sudokuSektorBekommen(String[][][] lösungsMatrix, int sektorNummer) {
        String[][] sektor = new String[lösungsMatrix.length][];

        int sektorZähler = 0;
        for (int reihenZähler = 0; reihenZähler < lösungsMatrix.length; reihenZähler++) {
            String[][] reihe = lösungsMatrix[reihenZähler];
            for (int spaltenZähler = 0; spaltenZähler < reihe.length; spaltenZähler++) {
                if (Prüfer.sektorNummer(reihenZähler, spaltenZähler) == sektorNummer) {
                    sektor[sektorZähler] = reihe[spaltenZähler];
                    sektorZähler++;
                }
            }
        }

        return sektor;
    }

    private static String[][][] sudokuSpaltenLösen(String[][][] lösungsMatrix) {
        for (int reihenZähler = 0; reihenZähler < lösungsMatrix.length; reihenZähler++) {
            String[][] reihe = lösungsMatrix[reihenZähler];
            for (int spaltenZähler = 0; spaltenZähler < reihe.length; spaltenZähler++) {
                String[][] spalte = sudokuSpalteBekommen(lösungsMatrix, spaltenZähler);

                String[] möglicheLösungen = reihe[spaltenZähler];
                if (möglicheLösungen.length > 1) {
                    lösungsMatrix[reihenZähler][spaltenZähler] = entferneAlleBekanntenZahlen(möglicheLösungen, spalte);
                }
            }
        }

        return lösungsMatrix;
    }

    private static String[][] sudokuSpalteBekommen(String[][][] lösungsMatrix, int spaltenZähler) {
        String[][] spalte = new String[lösungsMatrix.length][];

        for (int reihenZähler = 0; reihenZähler < lösungsMatrix.length; reihenZähler++) {
            String[][] reihe = lösungsMatrix[reihenZähler];

            spalte[reihenZähler] = reihe[spaltenZähler];
        }

        return spalte;
    }

    private static String[][][] sudokuReihenLösen(String[][][] lösungsMatrix) {
        for (int reihenZähler = 0; reihenZähler < lösungsMatrix.length; reihenZähler++) {
            String[][] reihe = lösungsMatrix[reihenZähler];
            for (int spaltenZähler = 0; spaltenZähler < reihe.length; spaltenZähler++) {
                String[] möglicheLösungen = reihe[spaltenZähler];
                if (möglicheLösungen.length > 1) {
                    lösungsMatrix[reihenZähler][spaltenZähler] = entferneAlleBekanntenZahlen(möglicheLösungen, reihe);
                }
            }
        }

        return lösungsMatrix;
    }

    private static String[][] lösungBekommen(String[][][] lösungsMatrix) {
        String[][] lösung = new String[lösungsMatrix.length][lösungsMatrix.length];

        for (int reihenZähler = 0; reihenZähler < lösungsMatrix.length; reihenZähler++) {
            String[][] reihe = lösungsMatrix[reihenZähler];
            for (int spaltenZähler = 0; spaltenZähler < reihe.length; spaltenZähler++) {
                String[] möglicheLösungen = reihe[spaltenZähler];

                if (möglicheLösungen.length == 1) {
                    lösung[reihenZähler][spaltenZähler] = möglicheLösungen[0];
                } else {
                    lösung[reihenZähler][spaltenZähler] = Programm.leer;
                }
            }
        }

        return lösung;
    }

    private static String[][][] sudokuLösungsMatrixInitialisieren(String[][] aufgabe) {
        String[][][] lösungsMatrix = new String[aufgabe.length][aufgabe.length][];
        for (int reihenZähler = 0; reihenZähler < aufgabe.length; reihenZähler++) {
            String[] reihe = aufgabe[reihenZähler];
            for (int spaltenZähler = 0; spaltenZähler < reihe.length; spaltenZähler++) {
                String zahl = reihe[spaltenZähler];
                if (zahl == Programm.leer) {
                    lösungsMatrix[reihenZähler][spaltenZähler] = Prüfer.alphabet;
                } else {
                    lösungsMatrix[reihenZähler][spaltenZähler] = new String[]{zahl};
                }
            }
        }

        return lösungsMatrix;
    }

    public static String[] entferneAlleBekanntenZahlen(String[] möglicheLösungen, String[][] reihe) {
        for (int zähler = 0; zähler < reihe.length; zähler++) {
            String[] lösungen = reihe[zähler];
            if (lösungen.length == 1) {
                möglicheLösungen = Prüfer.entferneZahl(lösungen[0], möglicheLösungen);
            }
        }
        return möglicheLösungen;
    }
}
