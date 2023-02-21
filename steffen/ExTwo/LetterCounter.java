package ExTwo;
public  class LetterCounter {
    public static void letterCountExcersize(String string) {
        printNumberOfLetters(string.length());
    }

    private static void printNumberOfLetters(int num) {
        if(num == 1) {
            System.out.println("\n\nThis word has " + num + " letter");
        } else {
            System.out.println("\n\nThis word has " + num + " letters");
        }
    }
}
