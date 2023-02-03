package myapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) throws IOException {
        
        Map<String, AppStats> stats =  new HashMap<>();
        AppStats st;

    Path p = Paths.get(args[0]);
            File f = p.toFile();

    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    
    // Discard the header line
    br.readLine();
    
    String line;
    while ((line = br.readLine()) != null) {
            String[] cols = line.split (",");
            String appName = cols[0];
            String category = cols[1];
            String rating = cols[2];
        }

        try{
            rating = Float.parseFloat(col3);
            

        } catch (NumberFormatException ex) {
            continue;
        }

        if (stats.containsKey(category)){
            st = stats.get(category);
            st.evaluate (appName, rating);

        } else {
            st = new AppStats(category);
            stats.put(category);
        }
        st.evaluate(appName, rating);
    }
    for (String cat: stat.keySet()){
        AppStats st = stats.get(cat);
        System.out.printf("Category: %s\n", cat);
        System.out.printf("\tAverage rating: %f\n", (st.getTotalRating()/ st.getCount()));
        System.out.printf("\thighest rating: %s %f\n", st.getHighestAppRating(), st.getHighestApp());
    }
    
}
}
