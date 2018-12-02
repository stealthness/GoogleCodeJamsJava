import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Script {

	private static final String inputFile = "src\\C-small-practice.in";
	private static final String outputFile = "src\\C-small-practice.out";

	public static void main(String[] args) {	
		createOutput(getCodeStrings(getStrings(inputFile)), outputFile);	
	}

	private static void createOutput(String[] strings, String filename) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
			for (String string:strings){
				bw.write(string+"\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static String[] getCodeStrings(String[] input) {
		String[] strings = new String[input.length];
		for (int i=0;i<input.length;i++){
			strings[i] = encode(input[i],i+1);
		}
		return strings;
	}

	private static String encode(String string,int number) {
		StringBuilder sb = new StringBuilder();
		char previous = string.charAt(0);
		for (int i=0;i<string.length();i++){
			char current = string.charAt(i);
			sb.append(encodeChar(string.charAt(i)));
			if (i>0 && previous == current ){
				sb.append(" ");
			}
			previous = current;
		}
		return "case #"+number+": "+sb.toString();
	}

	private static String encodeChar(char charAt) {

		Map<Integer,String> map = new HashMap<>();
		map.put((int)'a', "2");			map.put((int)'p', "7");
		map.put((int)'b', "22");		map.put((int)'q', "77");
		map.put((int)'c', "222");		map.put((int)'r', "777");
		map.put((int)'d', "3");			map.put((int)'s', "7777");
		map.put((int)'e', "33");		map.put((int)'t', "8");
		map.put((int)'f', "333");		map.put((int)'u', "88");
		map.put((int)'g', "4");			map.put((int)'v', "888");
		map.put((int)'h', "44");		map.put((int)'x', "99");
		map.put((int)'i', "444");		map.put((int)'y', "999");
		map.put((int)'j', "5");			map.put((int)'z', "9999");
		map.put((int)'k', "55");		map.put((int)' ', "0");
		map.put((int)'l', "555");		map.put((int)'w', "9");
		map.put((int)'m', "6");		
		map.put((int)'n', "66");		
		map.put((int)'o', "666");
		

		return map.get((int)charAt);
		
	}

	private static String[] getStrings(String filename) {
		String[] strings = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			
			int noTests = Integer.parseInt(br.readLine());
			strings = new String[noTests];
			for (int i=0;i<noTests;i++){
				strings[i] = br.readLine();
			}
//			for (String string:strings){
//				string = br.readLine();
//			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return strings;
	}
	
	

}
