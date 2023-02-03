package myapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Google {

        public static void main (String[] args) throws IOException {
    
            Path p = Paths.get(args[0]);
            File f = p.toFile();
    
            Map<String, Integer> wordFreq =  new HashMap<>(); // Map requires string + integer for it to work. this is mapped for HashMap. 
            
            
            
            // Open a file as input stream
            InputStream is = new FileInputStream(f); 
            // converst the input stream to a reader byte => char 2 byte
            InputStreamReader isr = new InputStreamReader(is);
            // Read whole lines
            BufferedReader br = new BufferedReader(isr); //decorating the input stream to read it as characters.

            // Setting up as a line.
            
            String line;
            int numWords = 0;
            int rating = 0;
           
       

            while ((line = br.readLine()) != null){        // while there is information in br (buffered line), 
                System.out.printf(">%s\n", line.toUpperCase());
                String[] words = line.split("_"); //remove underline
                
                // numWords += words.length; // count words
                    // Iterate the all the words in the line
                for (String w: words) {
                    String t = w.trim().toLowerCase(); // change the entire passage to lower case
                   
                    if (t.length() <= 0)
                        continue;
                    if (!wordFreq.containsKey(t)){
                        // If word is not in map, initialise the words with freq 1
                        wordFreq.put(t, 0);
                    } else {
                        // if word is in map, the increment the count
                        int i = Arrays.asList(words).indexOf(t);
                        rating = rating + Integer.parseInt(words[i+1]);

                        int c = wordFreq.get(t);
                        wordFreq.put(t, c + 1); //ASSIGNMENT: Clear out the punctuations.
                        wordFreq.put(t, 1);
                    }
                }
            }
           
    
            // Get a list of all the words
            Set<String> words = wordFreq.keySet();
            for (String w: words) {
                int count = wordFreq.get(w);
                System.out.printf(": %s = %d\n", w, count);
            }
    
            System.out.printf("Number of words: %d\n", numWords); // display number of letters.
            System.out.printf("Number of unique words: %d\n", words.size());
            System.out.printf("Fraction of unique words: %d\n", words.size()/(float)numWords);
    
            br.close();
            isr.close();
            is.close();
    
                
            };
        }
        
    
    

