package vttp.d4;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class Exams {

    private Map<String, List<List<Integer>>> dataSet = new HashMap<>();
    private List<List<Integer>> AList = new LinkedList<>();
    private List<List<Integer>> BList = new LinkedList<>();
    private List<List<Integer>> CList = new LinkedList<>();
    private List<List<Integer>> DList = new LinkedList<>();
    private List<List<Integer>> EList = new LinkedList<>();

    public void initializeList() {
        for (int i = 0; i<3 ; i++) {
            // LinkedList contains 3 scores where 0 = Math, 1 = Read, 2 = Write
            AList.add(new LinkedList<Integer>()); 
            BList.add(new LinkedList<Integer>()); 
            CList.add(new LinkedList<Integer>()); 
            DList.add(new LinkedList<Integer>()); 
            EList.add(new LinkedList<Integer>()); 
        }
    }

    public void read(String data) {

        if ((null == data) || (data.trim().length() <= 0)) { 
            return;
        }
        // Data parsing
        String[] lines = data.split(",");
        String group = removeQuotes(lines[1]);
        String mathScore = removeQuotes(lines[5]);
        String readScore = removeQuotes(lines[6]);
        String writeScore = removeQuotes(lines[7]);
        // Every line of data is passed into the dataSet
        // general(group, toInt(mathScore), toInt(readScore), toInt(writeScore));

        if (group.equals("group A")) {
            // Add 1 entry to Group A
            AList.get(0).add(toInt(mathScore));
            AList.get(1).add(toInt(readScore));
            AList.get(2).add(toInt(writeScore));
        } else if (group.equals("group B")) {
            // Add 1 entry to Group B            
            BList.get(0).add(toInt(mathScore));
            BList.get(1).add(toInt(readScore));
            BList.get(2).add(toInt(writeScore));
        } else if (group.equals("group C"))  {
            // Add 1 entry to Group C  
            CList.get(0).add(toInt(mathScore));
            CList.get(1).add(toInt(readScore));
            CList.get(2).add(toInt(writeScore));
        } else if (group.equals("group D")) {
            // Add 1 entry to Group D  
            DList.get(0).add(toInt(mathScore));
            DList.get(1).add(toInt(readScore));
            DList.get(2).add(toInt(writeScore));
        } else if (group.equals("group E")) {
            // Add 1 entry to Group E  
            EList.get(0).add(toInt(mathScore));
            EList.get(1).add(toInt(readScore));
            EList.get(2).add(toInt(writeScore));
        }
    }

    public void createDataset() {
        dataSet.put("GROUP A", AList);
        dataSet.put("GROUP B", BList);
        dataSet.put("GROUP C", CList);
        dataSet.put("GROUP D", DList);
        dataSet.put("GROUP E", EList);

        for (String g: dataSet.keySet()) {
            System.out.printf("%s size: %d\n",g, dataSet.get(g).get(0).size());
        }
    }

    public void report() {
        for (String g: dataSet.keySet()) {
            // Obtain List of the List of scores for specific groups
            List<List<Integer>> entries = dataSet.get(g);  
            float mathAvg = calculateAvg(entries.get(0)); // Obtain only math score column for that specific group
            float readAvg = calculateAvg(entries.get(1)); // Obtain only read score column for that specific group
            float writeAvg = calculateAvg(entries.get(2)); // Obtain only write score column for that specific group
            System.out.printf("%s\n", g);
            System.out.printf("Math score average: %s\n", mathAvg);
            System.out.printf("Read score average: %s\n", readAvg);
            System.out.printf("Write score average: %s\n", writeAvg);
        }
    }

    private String removeQuotes(String dataPoint) {
        return dataPoint.replaceAll("\"","");
    }

    private Integer toInt(String score) {
        return Integer.parseInt(score);
    }

    private float calculateAvg(List<Integer> scoreList) {
        float total = 0f;
        for (int i = 0; i<scoreList.size(); i++) {
            total += scoreList.get(i);
        }
        return total/scoreList.size(); 
    }

    // private void general(String g, int ms, int rs, int ws) {
    //     // Create an empty Map<String, List<List<Integer>>>
    //     // Key is defined as group name, Value is defined by the List of a List of scores
    //     dataSet.put(g, scores());
    //     // Populate the each List entry with List of scores
    //     List<List<Integer>> scoreList = dataSet.get(g); 
    //     scoreList.get(0).add(ms);
    //     scoreList.get(1).add(rs);
    //     scoreList.get(2).add(ws);
    // }

    // // Create List of a List of Scores where List of scores contains 3 entries
    // private List<List<Integer>> scores() {
    //     List<List<Integer>> entries = new LinkedList<>();
    //     for (int i = 0; i<3 ; i++) {
    //         // LinkedList contains 3 scores where 0 = Math, 1 = Read, 2 = Write
    //         entries.add(new LinkedList<Integer>()); 
    //     }
    //     return entries;
    // }   

}