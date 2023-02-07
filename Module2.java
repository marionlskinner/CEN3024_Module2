//Buddy Skinner
//Feb 06 2023
//CEN 3024

//Write a text analyzer that reads a file and outputs statistics about that file. 
//It should output the word frequencies of all words in the file, sorted by the most frequently used word. 
//The output should be a set of pairs, each pair containing a word and how many times it occurred in the file.

package CEN3024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Module2 {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Lauren Daniel\\eclipse-workspace\\Module2_CEN3024\\src\\CEN3024\\theraven.txt";
        //I hosted the file from my local computer.

        // This will create a HashMap to store the word frequencies
        HashMap<String, Integer> wordFrequencies = new HashMap<>();

        // This will read the file and store the word frequencies
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // This will split the line into words
                String[] words = line.split("\\W+");

                // This will iterate over the words and update their frequencies
                for (String word : words) {
                    word = word.toLowerCase();
                    if (wordFrequencies.containsKey(word)) {
                        wordFrequencies.put(word, wordFrequencies.get(word) + 1);
                    } else {
                        wordFrequencies.put(word, 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // This will sort the word frequencies in descending order
        Map<String, Integer> sortedWordFrequencies = wordFrequencies.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));

        // This will print the sorted word frequencies
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : sortedWordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}



