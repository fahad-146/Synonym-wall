package demogame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class WordBank {
    private HashMap<String, ArrayList<String>> wordMap;

    public WordBank() {
        wordMap = new HashMap<>();
        ArrayList<String> synonyms1 = new ArrayList<>();
        synonyms1.add("rapid");
        synonyms1.add("quick");
        synonyms1.add("speedy");
        synonyms1.add("swift");
        synonyms1.add("expeditious");
        wordMap.put("fast", synonyms1);

        ArrayList<String> synonyms2 = new ArrayList<>();
        synonyms2.add("silent");
        synonyms2.add("hushed");
        synonyms2.add("muted");
        synonyms2.add("inaudible");
        synonyms2.add("soundless");
        wordMap.put("quiet", synonyms2);

        ArrayList<String> synonyms3 = new ArrayList<>();
        synonyms3.add("large");
        synonyms3.add("huge");
        synonyms3.add("immense");
        synonyms3.add("gigantic");
        synonyms3.add("vast");
        wordMap.put("big", synonyms3);

        ArrayList<String> synonyms4 = new ArrayList<>();
        synonyms4.add("angry");
        synonyms4.add("furious");
        synonyms4.add("irate");
        synonyms4.add("livid");
        synonyms4.add("enraged");
        wordMap.put("mad", synonyms4);

        ArrayList<String> synonyms5 = new ArrayList<>();
        synonyms5.add("happy");
        synonyms5.add("joyful");
        synonyms5.add("content");
        synonyms5.add("cheerful");
        synonyms5.add("delighted");
        wordMap.put("glad", synonyms5);

        ArrayList<String> synonyms6 = new ArrayList<>();
        synonyms6.add("sad");
        synonyms6.add("unhappy");
        synonyms6.add("sorrowful");
        synonyms6.add("mournful");
        synonyms6.add("downcast");
        wordMap.put("melancholy", synonyms6);

        ArrayList<String> synonyms7 = new ArrayList<>();
        synonyms7.add("smart");
        synonyms7.add("intelligent");
        synonyms7.add("clever");
        synonyms7.add("bright");
        synonyms7.add("sharp");
        wordMap.put("brilliant", synonyms7);

        ArrayList<String> synonyms8 = new ArrayList<>();
        synonyms8.add("beautiful");
        synonyms8.add("pretty");
        synonyms8.add("gorgeous");
        synonyms8.add("lovely");
        synonyms8.add("stunning");
        wordMap.put("attractive", synonyms8);

        ArrayList<String> synonyms9 = new ArrayList<>();
        synonyms9.add("small");
        synonyms9.add("tiny");
        synonyms9.add("minute");
        synonyms9.add("miniature");
        synonyms9.add("petite");
        wordMap.put("little", synonyms9);

        ArrayList<String> synonyms10 = new ArrayList<>();
        synonyms10.add("brave");
        synonyms10.add("courageous");
        synonyms10.add("fearless");
        synonyms10.add("valiant");
        synonyms10.add("bold");
        wordMap.put("heroic", synonyms10);

        ArrayList<String> synonyms11 = new ArrayList<>();
        synonyms11.add("funny");
        synonyms11.add("humorous");
        synonyms11.add("amusing");
        synonyms11.add("witty");
        synonyms11.add("comical");
        wordMap.put("hilarious", synonyms11);

        ArrayList<String> synonyms12 = new ArrayList<>();
        synonyms12.add("strong");
        synonyms12.add("powerful");
        synonyms12.add("sturdy");
        synonyms12.add("mighty");
        synonyms12.add("robust");
        wordMap.put("forceful", synonyms12);

        ArrayList<String> synonyms13 = new ArrayList<>();
        synonyms13.add("weak");
        synonyms13.add("frail");
        synonyms13.add("feeble");
        synonyms13.add("delicate");
        synonyms13.add("fragile");
        wordMap.put("fragile", synonyms13);

        ArrayList<String> synonyms14 = new ArrayList<>();
        synonyms14.add("dirty");
        synonyms14.add("filthy");
        synonyms14.add("grimy");
        synonyms14.add("unclean");
        synonyms14.add("mucky");
        wordMap.put("messy", synonyms14);

        ArrayList<String> synonyms15 = new ArrayList<>();
        synonyms15.add("clean");
        synonyms15.add("spotless");
        synonyms15.add("immaculate");
        synonyms15.add("pristine");
        synonyms15.add("tidy");
        wordMap.put("neat", synonyms15);

        ArrayList<String> synonyms16 = new ArrayList<>();
        synonyms16.add("tired");
        synonyms16.add("exhausted");
        synonyms16.add("weary");
        synonyms16.add("fatigued");
        synonyms16.add("worn-out");
        wordMap.put("sleepy", synonyms16);

        ArrayList<String> synonyms17 = new ArrayList<>();
        synonyms17.add("hungry");
        synonyms17.add("starving");
        synonyms17.add("famished");
        synonyms17.add("ravenous");
        synonyms17.add("peckish");
        wordMap.put("starved", synonyms17);

        ArrayList<String> synonyms18 = new ArrayList<>();
        synonyms18.add("old");
        synonyms18.add("aged");
        synonyms18.add("ancient");
        synonyms18.add("elderly");
        synonyms18.add("venerable");
        wordMap.put("antique", synonyms18);

        ArrayList<String> synonyms19 = new ArrayList<>();
        synonyms19.add("young");
        synonyms19.add("youthful");
        synonyms19.add("juvenile");
        synonyms19.add("adolescent");
        synonyms19.add("teenage");
        wordMap.put("teen", synonyms19);

        ArrayList<String> synonyms20 = new ArrayList<>();
        synonyms20.add("easy");
        synonyms20.add("simple");
        synonyms20.add("effortless");
        synonyms20.add("straightforward");
        synonyms20.add("uncomplicated");
        wordMap.put("smooth", synonyms20);

        // more word to add in future
    }

    public HashMap<String, ArrayList<String>> getWordMap() {
        return wordMap;
    }

    public String getRandomWord() {
        Object[] keys = wordMap.keySet().toArray();
        Random random = new Random();
        return (String) keys[random.nextInt(keys.length)];
    }
}

