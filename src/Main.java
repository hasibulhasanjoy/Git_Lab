import java.io.*;
import java.util.Date;
import java.util.Random;

public class Main {
    static String readFromFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        InputStreamReader input = new InputStreamReader(fileInputStream);
        BufferedReader reader = new BufferedReader(input);
        String s = reader.readLine();
        return  s;
    }
    static void addToList(String newName) throws IOException {
        FileWriter fileWriter = new FileWriter("input.txt",true);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(newName);
        writer.close();
    }
    static boolean findStudent(String[] list, String key)
    {
        for (String s : list) {
            if (s.trim().toLowerCase().equals(key)) {
                return true;
            }
        }
        return  false;
    }
    public static void main(String[] args) throws IOException {
        if(args[0].equals("all")) {
            String s = readFromFile();
            System.out.println(s);
            String[] names = s.split(",");
            for (String i : names) {
                System.out.println(i.trim());
            }
        } else if (args[0].equals("random")) {
            String s = readFromFile();
            String[] names = s.split(",");
            Random random = new Random();
            int index = random.nextInt(names.length);
            System.out.println(names[index]);
        } else if (args[0].equals("add")) {
            Date date = new Date();
            System.out.println(date);
            String StudentList = readFromFile();
            String newStudent = ", "+args[1];
            System.out.println(newStudent);
            addToList(newStudent);
        } else if (args[0].equals("find")) {
            String s = readFromFile();
            String key = args[1];
            String[] names = s.split(",");
            boolean isFound = findStudent(names,key);
            if(isFound){
                System.out.println("Found Student");
            }
            else {
                System.out.println("Data not Found");
            }
        }
    }
}
