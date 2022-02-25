package Day4;

import java.io.*;

public class ThreadAssignment extends Thread {
    //To create producer and consumer as threads
    //Shared variable
    public static int x = 0;//checks if all lines are read
    public static int j = 0;//variable to switch between threads based upon its value
    public static String line;
    public static String s;

    public ThreadAssignment(String threadName) {     //Constuctor
        super(threadName);      //Call to constructor of Thread class
    }

    public void run() {

        while (x != -1)
        {
            if (Thread.currentThread().getName().contains("Reader")) {
                if (x != -1&&j==0)
                {
                    j=1;
                    String fileName = "/Users/simengfeng/Downloads/Assignment4/input.txt";

                    try {
                        // FileReader reads text files in the default encoding.
                        FileReader fileReader =
                                new FileReader(fileName);

                        // Always wrap FileReader in BufferedReader.
                        BufferedReader bufferedReader =
                                new BufferedReader(fileReader);

                        for (int check = 0; check <= x; check++) {

                            line = bufferedReader.readLine();
                            if(line != null) {
                                //if(line.length() > 0) {
                                    int sum = getSum(line);
                                    line += " " + sum;
                                //}
                            }
                        }
                        if (line == null) {
                            x = -1;
                        } else {
                            System.out.println(line);
                            x++;
                        }


                        // Always close files.
                        bufferedReader.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println(
                                "Unable to open file '"
                                        + fileName + "'");
                    } catch (IOException ex) {
                        System.out.println(
                                "Error reading file '"
                                        + fileName + "'");
                        // Or we could just do this:
                        // ex.printStackTrace();

                    }
                }

                yield();
            }else if (Thread.currentThread().getName().contains("writer")) {
                    if (x != -1 && line != null && j == 1) {
                        j = 0;

                        String fileName = "/Users/simengfeng/Downloads/Assignment4/output.txt";

                        try {
                            // Assume default encoding.
                            FileWriter fileWriter =
                                    new FileWriter(fileName, true);

                            // Always wrap FileWriter in BufferedWriter.
                            BufferedWriter bufferedWriter =
                                    new BufferedWriter(fileWriter);

                            // Note that write() does not automatically
                            // append a newline character.
                            if(!line.contains("0")) {
                                bufferedWriter.write(line);
                                //bufferedWriter.write(" " + s);
                                bufferedWriter.newLine();
                            }
                            //System.out.println("y");
                            // Always close files.
                            bufferedWriter.close();
                        } catch (IOException ex) {
                            System.out.println(
                                    "Error writing to file '"
                                            + fileName + "'");
                            // Or we could just do this:
                            // ex.printStackTrace();
                        }
                    }
                    Thread.yield();
                } else {
                }
            }
        }

    public static void main(String[] args) {

        ThreadAssignment reader = new ThreadAssignment("Reader");
        ThreadAssignment writer = new ThreadAssignment("writer");

        reader.start();
        writer.start();


    }

    public static int getSum(String line){
        int sum = 0;
        String operation = "+";
        line.trim();
        String[] arr = line.split(" ");
        for (String m : arr) {
            if (m.equals("+")) {
                operation = "+";
            } else if (m.equals("-")) {
                operation = "-";
            }
            if (isNumeric(m)) {
                if (operation.equals("+")) {
                    sum += Integer.parseInt(m);
                } else {
                    sum -= Integer.parseInt(m);
                }
            }
        }
        return sum;
    }

    public static boolean isNumeric(String string) {
        int intValue;

        if(string == null || string.equals("")) {
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
}
