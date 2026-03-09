import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public static class Chat {
    static void run() {
        Scanner input = new Scanner(System.in);
        ArrayList<String> inps = new ArrayList<String>();
        while (true) {
            System.out.print("Sentence: ");
            String sentence = input.nextLine();
            if (sentence.equals("STOP")) {
                break;
            }
            String[] parts = sentence.split(" ");
            inps.addAll(Arrays.asList(parts)); // suggestion from inteellij autoreplace

        }
        System.out.println("Chat Report:");
        System.out.println("You used " + inps.size() + " words.");
        System.out.println("You used " + countUniqueWords(inps) + " words.");
        System.out.println("You used 'the'' " + getTheCount(inps) + " words.");
        System.out.println("'" + getLongestWord(inps) + "' was the longest word.");
        System.out.print("All words are ");
        if (!areAllWordsLowercase(inps)) {
            System.out.print("not ");
        }
        System.out.println("lowercase.");
        System.out.println("Condensed Chat History: ");
        ArrayList<String> uniqueList = new ArrayList<String>();
        for (String word : inps) {
            if (!uniqueList.contains(word)) {
                uniqueList.add(word);
                if (word.length() > 3) {
                    System.out.println(word);
                }
            }
        }
    }

    public static String getLongestWord(ArrayList<String> words) {
        String l = "";
        for (String word : words) {
            if (word.length() > l.length()) {
                l = word;
            }
        }
        return l;
    }

    public static int getTheCount(ArrayList<String> words) {
        int c = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase("the")) {
                c++;
            }
        }
        return c;
    }

    public static boolean areAllWordsLowercase(ArrayList<String> words) {
        for (String word : words) {
            if (!word.equals(word.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public static int countUniqueWords(ArrayList<String> words) {
        ArrayList<String> unique = new ArrayList<String>();
        for (String word : words) {
            String lower = word.toLowerCase();
            boolean f = false;
            for (String s : unique) {
                if (s.equals(lower)) {
                    f = true;
                    break;
                }
            }
            if (!f) {
                unique.add(lower);
            }
        }
        return unique.size();
    }
}


public static void main(String[] args) {
    Chat.run();
}
