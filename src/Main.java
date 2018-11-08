import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {


        File file1 = new File("babynames/baby1990.html"); // Will only work with the file baby1990.html


        extractNames(file1);



    }

    static void extractNames(File filename)
    {
        BufferedReader in = null;
        int x = 1;

        try
        {
            in = new BufferedReader(new FileReader(filename));
            String line;
            while((line = in.readLine()) != null)
            {
//                System.out.println(line);
                Matcher match = Pattern.compile("(<tr align=\"right\"><td>[0-9].*</td><td>[A-Z].*</td><td>[A-Z].*</td>)").matcher(line);
                // Need to find the regex to make it work
                while (match.find()) {
                    System.out.printf("%d. ",x); // we can print the numbers like this, this way we could make the regex to find only the names
                    System.out.println(match.group());
                    x++;
                }


//                if(line.matches("[.*]"))
//                {
//                    System.out.println(line);
//                }
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


