public class Löser {
    public static String[][] sudokuLösen(String[][] aufgabe) {
        String[][][] lösungsMatrix = sudokuLösungsMatrixInitialisieren(aufgabe);

        for (int reihenZähler = 0; reihenZähler < aufgabe.length; reihenZähler++) {
            String[][] reihe = lösungsMatrix[reihenZähler];
            for (int spaltenZähler = 0; spaltenZähler < reihe.length; spaltenZähler++) {
                String[] möglicheLösungen = reihe[spaltenZähler];
                if (möglicheLösungen.length > 1) {
                    lösungsMatrix[reihenZähler][spaltenZähler] = entferneAlleBekanntenZahlen(möglicheLösungen, reihe);
                }
            }
        }

        return aufgabe;
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

    public static String[] sudokuReiheLösen(String[] aufgabe) {
        String[] fehlendeZahlen = Prüfer.alphabet;

        for (int zähler = 0; zähler < aufgabe.length; zähler++) {
            String element = aufgabe[zähler];

            if (element != Programm.leer) {
                fehlendeZahlen = Prüfer.entferneZahl(element, fehlendeZahlen);
            }
        }

        int fehlendeZahlenZähler = 0;
        for (int zähler = 0; zähler < aufgabe.length; zähler++) {
            String element = aufgabe[zähler];

            if (element == Programm.leer) {
                aufgabe[zähler] = fehlendeZahlen[fehlendeZahlenZähler];
                fehlendeZahlenZähler++;
            }
        }

        return aufgabe;
    }
}
