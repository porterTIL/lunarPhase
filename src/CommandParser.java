import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class CommandParser {
    private CommandParser(){}

    // static Map actionWords = new HashMap(JsonImporter.parseDictionary());

    // private static StringBuilder listValidItems(){
    // StringBuilder actionTargetWords = new StringBuilder();
    // for (String item : Inventory.items){
    //    actionTargetWords.append(item);
    //        }
    //        for (String item : Map.currentLocation.items){
    //                  actionTargetWords.append(item);
    //        }
    //        return actionTargetWords;
    //    }

    static String parse(String request){
    //        listValidItems();
        request = request.toUpperCase();
        request = findSynonyms(request);    // we have to find and replace synonyms before we filter out articles and prepositions because some action word synonyms contain prepositions (ex: "get a load of...")
        request = findActionPairs(request);
        return request;
    }

    static private String findSynonyms(String request){
        // "leave" was in both "drop" and "go", it's been removed from the JSON for now
        try {
            ObjectMapper mapper = new ObjectMapper();
            // TODO: give relative path
            // ObjectMapper.readValue takes File src and Class<T> valueType arguments, we want to a Map of our JSON
            // The ObjectMapper is putting the value field into an ArrayList, so we set our map to expect an ArrayList
            Map<String, ArrayList<String>> map = mapper.readValue(Paths.get("C:\\StudentWork\\IntmJ\\workspace\\lunarPhase\\src\\actionWords.json").toFile(), Map.class);
            for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()){ // for each key-value pair in our new map
                for (String word : entry.getValue()){   // for each word in the value ArrayList
                    if (request.contains(word)){    // check to see if our request string contains that word
                        request = request.replaceAll(word, entry.getKey()); // and replace it with the key word
                    }
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return request;
    }

    // strip out unnecessary words -> articles (the, a, an), prepositions (to, at, of, between), pronouns
    // anything after an action word and before the next action word should be an actionFocus
    // returns action and actionTarget pairs
    private static String findActionPairs(String request){
        // consider conjunctions (and, but, so)
        // consider negations (without, not)
        // if you use the word my, can we replace that with inventory?

            // TODO: file path should be relative
            File garbageWordsFile = new File("C:\\StudentWork\\IntmJ\\workspace\\lunarPhase\\src\\garbageWords.txt");
            try (BufferedReader garbageFeed = new BufferedReader(new FileReader(garbageWordsFile))) {   // the BufferedReader wraps around the FileReader to make file reads more efficient
                String garbageWord;
                while ((garbageWord = garbageFeed.readLine()) != null) {
                    request = request.replaceAll("\\b" + garbageWord.toUpperCase() + "\\b", ""); // the regex looks for the garbageWord with word delimeters on either side of it ex: preventing toga from removing to
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return request;
    }
}