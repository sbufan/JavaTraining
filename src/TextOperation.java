import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextOperation {
    private static String wordSeparator = "(\\s+|(\\.|,|!|\\?|:|;|\")\\s*)";

    //- знайти перше унікальне слово
    public static String getUniqueWord(String input) {
        Map<String, Integer> wordCount = getWordsCount(input);
        String[] words = getWords(input);
        for (String word : words) {
            if (wordCount.get(word).equals(1)) {
                return word;
            }
        }
        return "There is no unique word";
    }

    //-у кожному реченні замінити найкоротше слово найдовшим словом
    public static String replaceWord(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = input.trim().split("(\\.|!|\\?)");
        for (String sentence : split) {
            List<String> shortestAndLongestWords = getShortestAndLongestWords(getWords(sentence));
            sentence = " " + sentence + " ";
            stringBuilder.append(sentence.replaceAll(wordSeparator + shortestAndLongestWords.get(0) + wordSeparator,
                    "$1" + shortestAndLongestWords.get(1) + "$3").trim());
            stringBuilder.append(". ");
        }

        return stringBuilder.toString();
    }

    //-вивести слова і їх кількість в тексті
    public static void printWordsCount(String input) {
        Map<String, Integer> wordCount = getWordsCount(input);

        for (String word : wordCount.keySet()) {
            System.out.println(word + " " + wordCount.get(word));
        }
    }

    private static Map<String, Integer> getWordsCount(String input) {
        Map<String, Integer> wordCount = new HashMap<>();

        String[] split = getWords(input);

        for (String word : split) {
            Integer currentCount = wordCount.get(word);
            wordCount.put(word, currentCount == null ? 1 : currentCount + 1);
        }

        return wordCount;
    }

    private static String[] getWords(String input) {
        return input.trim().split(wordSeparator);
    }

    private static List<String> getShortestAndLongestWords(String[] words) {
        String shortest = words[0];
        String longest = words[0];
        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word;
            } else if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return Arrays.asList(shortest, longest);
    }
}
