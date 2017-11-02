import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Script {

	private static final String INPUT = "out\\production\\reverse-words\\B-small-practice.in";
	private static final String OUTPUT = "out\\production\\reverse_words\\B-small-practice.out";
	
	
	public static void main(String[] args) {
		
		String[] strings = getStrings(INPUT);
		writeOutput(OUTPUT,reverseStrings(strings));
		
	}
	private static String[] reverseStrings(String[] strings) {
		String[] newStrings = new String[strings.length];
		int index=0;
		for (String string:strings){
			newStrings[index++] = reverse(string);
		}
		return newStrings;
	}

	private static String reverse(String string) {
		StringBuilder sb = new StringBuilder();
		String[] strings = string.split("\\s+");
		for (int i = strings.length;i>0;i--){
			sb.append(strings[i-1]+" ");
		}
		return sb.toString();
	}



	private static void writeOutput(String filename,String[] strings) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
			int caseNo = 1;
			for (String string : strings){
				bw.write("Case #"+(caseNo++)+": "+string+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	
	private static String[] getStrings(String filename) {
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
		return strings;
	}
}
