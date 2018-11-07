import java.io.*;

public class Main {

    public static void main(String[] args) {

        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist.");
            System.exit(1);
        }

//        File targetFile = new File(args[1]);
//        if (targetFile.exists()) {
//            System.out.println("Target file " + args[1] + " already exists.");
//        }

        // create an input stream
        BufferedInputStream input = null;
//        BufferedOutputStream output = null;
        try {
            input = new BufferedInputStream(new FileInputStream(sourceFile));
         //   output = new BufferedOutputStream(new FileOutputStream(targetFile));
//            System.out.println("The file " + args[0] + " has " + input.available() + " bytes.");

            // continuously read a byte from input and write it to output.
            int line;
           while ((line = input.read()) != -1 ) {
//               output.write(line);
               System.out.println(line);
          }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            if (output != null) {
//                try {
//                    output.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

}
