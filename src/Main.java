import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {


        File file1 = new File("babynames/baby1990.html");
//        File file2 = new File("babynames/baby1992.html");
//        File file3 = new File("babynames/baby1994.html");
//        File file4 = new File("babynames/baby1996.html");
//        File file5 = new File("babynames/baby1998.html");
//        File file6 = new File("babynames/baby2000.html");
//        File file7 = new File("babynames/baby2002.html");
//        File file8 = new File("babynames/baby2004.html");
//        File file9 = new File("babynames/baby2006.html");
//        File file10 = new File("babynames/baby2008.html");


        extractNames(file1);
//        extractNames(file2);
//        extractNames(file3);
//        extractNames(file4);
//        extractNames(file5);
//        extractNames(file6);
//        extractNames(file7);
//        extractNames(file8);
//        extractNames(file9);
//        extractNames(file10);



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

        try
        {
            in = new BufferedReader(new FileReader(filename));
            String line;
            while((line = in.readLine()) != null)
            {
                Pattern patternYear = Pattern.compile("Popularity\\sin\\s(\\d\\d\\d\\d)");
                Pattern patternRank = Pattern.compile("<td>(\\d+)</td><td>(\\w+)</td>\\<td>(\\w+)</td>");

                Matcher matcherYear = patternYear.matcher(line);
                Matcher matcherRank = patternRank.matcher(line);

                while (matcherYear.find()) {
                    year = matcherYear.group(1).replaceAll("¥¥s", "");
                    System.out.println(year);

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
                    System.out.println(i + " " + map.get(i));
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
        }
    }
}