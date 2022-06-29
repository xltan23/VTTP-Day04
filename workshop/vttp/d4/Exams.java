package vttp.d4;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class Exams {

    private Map<String, List<List<Integer>>> dataSet = new HashMap<>();

    public void read(String data) {

        if ((null == data) || (data.trim().length() <= 0)) { 
            return;
        }
        String[] lines = data.split(",");
        String group = removeQuotes(lines[1]);
        String mathScore = removeQuotes(lines[5]);
        String readScore = removeQuotes(lines[6]);
        String writeScore = removeQuotes(lines[7]);

        general(group, toInt(mathScore), toInt(readScore), toInt(writeScore));
        
    }

    public void report() {
        for (String g: dataSet.keySet()) {
            List<List<Integer>> entries = dataSet.get(g); // Obtain list of scores for specific groups  
            float mathAvg = calculateAvg(entries.get(0)); // Obtain only math score column for that specific group
            float readAvg = calculateAvg(entries.get(1)); // Obtain only read score column for that specific group
            float writeAvg = calculateAvg(entries.get(2)); // Obtain only write score column for that specific group
            System.out.printf("%s\n", g.toUpperCase());
            System.out.printf("Math score average: %s\n", mathAvg);
            System.out.printf("Read score average: %s\n", readAvg);
            System.out.printf("Write score average: %s\n", writeAvg);
        }
    }

    private String removeQuotes(String dataPoint) {
        return dataPoint.replaceAll("\"","");
    }

    private Integer toInt(String dataPoint2) {
        return Integer.parseInt(dataPoint2);
    }

    private float calculateAvg(List<Integer> dataPoint3) {
        float total = 0f;
        for (int i = 0; i<dataPoint3.size(); i++) {
            total += dataPoint3.get(i);
        }
        return total/dataPoint3.size(); 
    }

    private void general(String g, int ms, int rs, int ws) {
        dataSet.put(g, scores());

        List<List<Integer>> scoreList = dataSet.get(g); 
        scoreList.get(0).add(ms);
        scoreList.get(1).add(rs);
        scoreList.get(2).add(ws);
    }

    // Creating List of a List of Scores where List of scores contains 3 entries
    private List<List<Integer>> scores() {
        List<List<Integer>> entries = new LinkedList<>();
        for (int i = 0; i<3 ; i++) {
            // LinkedList contains 3 scores where 0 = Math, 1 = Read, 2 = Write
            entries.add(new LinkedList<Integer>()); 
        }
        return entries;
    }   


}