import java.util.*;

public class main {
    public static void main(String[] args) {
        List<String> phrases = new ArrayList<String>();  
        phrases.add("doesn't coding");
        phrases.add("where you find men");
        phrases.add("coding rock");
        phrases.add("you see men loving women");
        List<String> output = buildList(phrases);
        System.out.println(output);
    }
    private static List<String> buildList(List<String> phrases) {
        List<String> generatedList = new ArrayList<String>();
        for (int i = 0; i < (phrases.size()/2) ; i++) {
            String[] wordslist = phrases.get(i).split("\\s+");
            String wordToFind = wordslist[wordslist.length-1];
            System.out.println("word to find: "+ wordToFind);
            String builder = "";
            int current = phrases.size() - 1;
            boolean found = false;
            while (!found && current > i) {
                System.out.println("word: " +wordToFind+ " searching: "+phrases.get(current));
                String[] currentWords = phrases.get(current).split("\\s+");
                boolean inList = false;
                for (String word : currentWords) {
                    System.out.println("word: "+word);
                    if (inList) {
                        found = true;
                        builder += " " + word;
                        System.out.println("current builder: "+builder);
                    } else {
                        System.out.println(inList = (word.contains(wordToFind)));
                    }
                }
                current--;
            }
            if (found) {
                System.out.println(phrases.get(i) + builder);
                generatedList.add(phrases.get(i) + builder);
            }
        }
        return generatedList;
    }
}
