import java.util.*;
public class main {
    public static void main(String[] args) {
        List<String> phrases = new ArrayList<String>();  
        phrases.add("doesn't coding");
        phrases.add("where you find men");
        phrases.add("coding rocks");
        phrases.add("you see men loving women");
        List<String> output = buildList(phrases);
        System.out.println(output);
    }
    private static List<String> buildList(List<String> phrases) {
        List<String> generatedList = new ArrayList<String>();
        
        //get the first word to find
        int indexOfWord = 0;
        String wordToFind = phrases.get(indexOfWord).split("\\s+")[phrases.get(indexOfWord).split("\\s+").length-1];
        int current = phrases.size() - 1;
        // strCache.append(phrases.get(indexOfWord));
        generatedList = buildListRec(phrases, generatedList, wordToFind, current, indexOfWord);


        return generatedList;
    }

    private static List<String> buildListRec(List<String> phrases, List<String> genList,String wTf,int current,int index) {
        StringBuilder strCache = new StringBuilder();
        boolean found = false;
        strCache.append(phrases.get(index));
        System.out.println("word: " +wTf+ " searching: "+phrases.get(current));
        strCache.append(phrases.get(current));
        int srtIndex = strCache.indexOf(phrases.get(current).split("\\s+")[0]);
        if (strCache.indexOf(wTf, srtIndex) > 0) {
            System.out.println("word was found");
            found = true;
            //delete from the first word of the phrase untill the index of the reoccurence
            strCache.delete(srtIndex, strCache.indexOf(wTf, srtIndex)+wTf.length());
        } else {
            System.out.println("word was not found");
            strCache.delete(strCache.indexOf(phrases.get(current).split("\\s+")[0], srtIndex), strCache.length());
        }
        if (current > index) {
            current--;
            if (found) {
                genList.add(strCache.toString());
                index++;
                current = phrases.size()-1;
                wTf = phrases.get(index).split("\\s+")[phrases.get(index).split("\\s+").length-1];
            } 
            if (index < phrases.size()) {
                buildListRec(phrases, genList, wTf, current, index);
            }
        }
        return genList;
    }
}
