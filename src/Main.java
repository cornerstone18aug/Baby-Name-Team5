import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        for (String i: args) {
            File file = new File(i);
            extractNames(file);
        }

        File file1 = new File("babynames/baby1990.html");


    }

    static void extractNames(File filename)
    {
        BufferedReader in = null;
        String year = null;
        String rank = null;
        String maleName = null;
        String femaleName = null;
        String text = null;
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> mapfemalename = new HashMap<>();
        ArrayList<String> names = new ArrayList<>();
        BufferedWriter out = null;

        try
        {
            in = new BufferedReader(new FileReader(filename));
            out = new BufferedWriter(new FileWriter(filename+ ".summary"));
            String line;
            while((line = in.readLine()) != null)
            {
                Pattern patternYear = Pattern.compile("Popularity\\sin\\s(\\d\\d\\d\\d)");
                Pattern patternRank = Pattern.compile("<td>(\\d+)</td><td>(\\w+)</td>\\<td>(\\w+)</td>");

                Matcher matcherYear = patternYear.matcher(line);
                Matcher matcherRank = patternRank.matcher(line);

                while (matcherYear.find()) {
                    year = matcherYear.group(1).replaceAll("¥¥s", "");
                    out.write(year);
                }

                while (matcherRank.find()) {
                    rank = matcherRank.group(1).replaceAll("¥¥s", "");
                    maleName = matcherRank.group(2).replaceAll("¥¥s", "");
                    femaleName = matcherRank.group(3).replaceAll("¥¥s", "");
                    if (maleName != null)
                    {
                        names.add(maleName);
                        names.add(femaleName);
                        map.put(maleName, rank);
                        mapfemalename.put(femaleName, rank);
                    }
                }
                Collections.sort(names, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });

            }
            for (String i: names)
            {
                if(map.containsKey(i))
                {
                    out.write("\n"+ i + " " + map.get(i));
                }
            }
        }
        catch(Exception e)
        {

        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}