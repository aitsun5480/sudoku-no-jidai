public class Löser {
    public static String[][] sudokuLösen(String[][] aufgabe) {
        return aufgabe;
    }

    public static String[] sudokuReiheLösen(String[] aufgabe){
        String[] fehlendeZahlen = Prüfer.alphabet;

        for(int zähler = 0; zähler < aufgabe.length; zähler++){
            String element = aufgabe[zähler];

            if (element != Programm.leer){
                fehlendeZahlen = Prüfer.entferneZahl(element, fehlendeZahlen);
            }
        }

        int fehlendeZahlenZähler =0;
        for(int zähler = 0; zähler < aufgabe.length; zähler++){
            String element = aufgabe[zähler];

            if (element == Programm.leer){
                aufgabe[zähler] = fehlendeZahlen[fehlendeZahlenZähler];
                fehlendeZahlenZähler++;
            }
        }

        return aufgabe;
    }
}
