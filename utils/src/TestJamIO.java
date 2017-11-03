import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Stephen West on 02/11/2017.
 */
public class TestJamIO {

    public static void main(String[] args) {


        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        System.out.println("Test JamIO");

        String filename = "utils\\TestJam.in";
        String[] strings = null;

        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            int noTests = Integer.parseInt(br.readLine());
            strings = new String[noTests];
            for (int i= 0;i<noTests;i++){
                strings[i] = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        JamIO.readInput(filename);
    }
}
