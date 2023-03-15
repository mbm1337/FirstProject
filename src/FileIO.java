import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    File file;
    Scanner scan;

    public ArrayList<String> readFileData(String path) {
        file = new File(path);
        ArrayList<String> data = new ArrayList<>();
        try {
            scan = new Scanner(file);

            scan.nextLine(); //Ignore header in csv file

            while (scan.hasNextLine()) {

                String line = scan.nextLine();
                data.add(line);


            }
        } catch (FileNotFoundException e) {
            System.out.println("This file was not found.");

        }
        return data;

    }

    public void saveData(String path,ArrayList<Customer> customers) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write("name,balance \n");
            for(Customer c : customers){
                writer.write(c.getName()+","+c.getAccount().getBalance()+"\n");

            }

            writer.close();


        }catch (IOException e){

        }
    }
}
