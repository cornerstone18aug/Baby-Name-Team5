import java.io.*;

public class Main {

    public static void main(String[] args) {


        File file1 = new File("babynames/baby1990.html");


        extractNames(file1);



    }

    static void extractNames(File filename)
    {
        BufferedReader in = null;

        try
        {
            in = new BufferedReader(new FileReader(filename));
            String line;
            while((line = in.readLine()) != null)
            {
                System.out.println(line);
                if(line.matches("(\\d\\d\\d\\d)"))
                {
                    System.out.println(line);
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


