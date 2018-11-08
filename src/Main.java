import java.io.*;

public class Main {

    public static void main(String[] args) {

        FileInputStream input = null;
        BufferedReader in = null;
        File sourceFile = new File("babynames/baby1990.html");
        try {
            in = new BufferedReader(new FileReader(sourceFile));
            String line;
            while ((line = in.readLine()) != null) { // -1 means end of the File
                String [] garray = line.split("<td>|</td>");

                for(int i = 1; i < garray.length; i+=2){
                    try{
                        Integer.parseInt(garray[i]);
                        System.out.println(garray[i]);
                        System.out.println(garray[i+2]);
                        System.out.println(garray[i+4]);

                    }catch (Exception e)
                    {
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
