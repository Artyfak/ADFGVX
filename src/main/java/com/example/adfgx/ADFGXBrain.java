package com.example.adfgx;

public class ADFGXBrain {
    public static final StringBuilder RESULTSB = new StringBuilder();
    private char[][] pole6x6 = new char[6][6];
    private String prvotnytext;
    private String heslo;

    // konštruktor hlavne na naplnenie poľa
    public ADFGXBrain() {
        char[][] grid = new char[6][6];
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        int index = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                // Naplnenie poľa
                if (index < characters.length()) {
                    grid[i][j] = characters.charAt(index);
                    index++;
                }
            }
        }
        this.pole6x6 = grid;

    }

    // geters and seters
    public char[][] getPole6x6() {
        return pole6x6;
    }

    public String getPrvotnytext() {
        return prvotnytext;
    }

    public void setPrvotnytext(String prvotnytext) {
        this.prvotnytext = prvotnytext;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    // funkcia pre výpis poľa ako string
    public static String getGridAsString(char[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n"); // Nový riadok po každom riadku
        }
        return sb.toString(); // Vráti celý reťazec
    }
    // funkcia na normalizovanie textu
    public String normalize() {
        String result = this.prvotnytext;
        result = result.toLowerCase();
        result = result.replaceAll("á", "A");
        result = result.replaceAll("w", "v");
        result = result.replaceAll("ď", "D");
        result = result.replaceAll("č", "C");
        result = result.replaceAll("é", "E");
        result = result.replaceAll("ě", "E");
        result = result.replaceAll("í", "I");
        result = result.replaceAll("ň", "N");
        result = result.replaceAll("ó", "O");
        result = result.replaceAll("ř", "R");
        result = result.replaceAll("š", "S");
        result = result.replaceAll("ť", "T");
        result = result.replaceAll("ú", "U");
        result = result.replaceAll("ů", "U");
        result = result.replaceAll("ý", "Y");
        result = result.replaceAll("ž", "Z");
        result = result.replaceAll("\\p{Punct}", "");
        result = result.replaceAll(" ", "XMEZERX");
//        result = result.replaceAll("1", "XONEX");
//        result = result.replaceAll("2", "XTWOX");
//        result = result.replaceAll("3", "XTHREEX");
//        result = result.replaceAll("4", "XFOURX");
//        result = result.replaceAll("5", "XFIVEX");
//        result = result.replaceAll("6", "XSESTX");
//        result = result.replaceAll("7", "XSEVENX");
//        result = result.replaceAll("0", "XZEROX");
//        result = result.replaceAll("8", "XEIGHTX");
//        result = result.replaceAll("9", "XNINEX");
        result = result.toUpperCase();

        return result;
    }
    // funkcia ktora vrati dvojznak (suradnice adfgvx)
    public String vratZasifrovanyDvojZnak(char character) {
        String result = "";
        String ax = "ADFGVX";
        for (int i = 0; i < pole6x6.length; i++) {
            for (int j = 0; j < pole6x6[i].length; j++) {
                if (pole6x6[i][j] == character) {
                    result = result + ax.charAt(i);
                    result = result + ax.charAt(j);
                    return  result;// Vráti súradnice [riadok, stĺpec]
                }
            }
        }
        return null; // Ak znak nie je nájdený
    }
    // funkcia ktora za pomoci vratZasifrovanyDvojZnak spravuje celú šifru
    public String vratZasifrovanyText(){
        String result ="";
        for (int i = 0; i < normalize().length(); i++) {
            result = result + vratZasifrovanyDvojZnak(normalize().charAt(i));

        }
        return  result;
    }
    // funkcia pridá kazdé 2 znaky medzeru
    public String pridajk2m(String input) {
        String resultSM = "";
        String resultbm = input;
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0 && (i != 0)){
                resultSM = resultSM + " "+ resultbm.charAt(i);
            } else {
                resultSM = resultSM + resultbm.charAt(i);
            }

        }
        return resultSM;
    }
    public double vratpocetstlp(String input) {
        return Math.ceil(vratZasifrovanyText().length() / input.length())+1;
    }

}
