import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Script {
	
	private static final char SPACE_CHAR = ' ';
	private static final int KEY_LENGTH = 26;

	private static int key[] = new int[KEY_LENGTH];

	private static final String INPUT = "tongues//src//A-small-practice.in";
	private static final String OUTPUT = "tongues//src//A-small-practice.out";

	private static final int keyAdj = 97;
	
	public static void main(String[] args) {
		
		createKey();
		
		String[] tests = getTests(INPUT);
		String[] results  = new String[tests.length];
		
		for (int i = 0; i<tests.length;i++){
			results[i] = encode(tests[i]);
		}	
		
		writeOutput(OUTPUT, results);

	}

	private static void writeOutput(String filename, String[] tests) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
			int count = 1;
			for (String string:tests){
				
				bw.write("Case #"+count+": "+string+"\r\n");
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createKey() {
		for (int i=0;i<KEY_LENGTH;i++){
			Script.key[i] = -1;
		}
		
		String[] encodedStrings = new String[]{
				"ejp mysljylc kd kxveddknmc re jsicpdrysi",
				"rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd",
				"de kr kd eoya kw aej tysr re ujdr lkgc jv",
				"qz"
		};
		String[]originalStrings = new String[]{
				"our language is impossible to understand",
				"there are twenty six factorial possibilities",
				"so it is okay if you want to just give up",
				"zq"
		};
		for (int test = 0;test<originalStrings.length;test++){
			for (int i = 0; i< originalStrings[test].length();i++){

				int keyPos=(int)encodedStrings[test].charAt(i)-keyAdj;
				int keyValue=(int)originalStrings[test].charAt(i)-keyAdj;
				if (keyPos >= 0 && keyPos < KEY_LENGTH){
					Script.key[keyPos] = keyValue;
				}		
			}
		}

		
	}

	private static String encode(String string) {
		StringBuilder sb = new StringBuilder();
		for (char charAt:string.toCharArray()){
			sb.append(encode(charAt));
		}
		return sb.toString();
	}

	private static Object encode(char charAt) {
		int ascii = (int) charAt;
		
		if (ascii >= keyAdj  && ascii < keyAdj+26 ){
			return (char)(Script.key[(ascii-keyAdj)]+keyAdj);
		}
		return SPACE_CHAR;

	}

	private static String[] getTests(String filename) {
		String[] tests = null;
		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			int noTest = Integer.parseInt(br.readLine());
			tests = new String[noTest];
			for (int i= 0; i<noTest;i++){
				tests[i] = br.readLine();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return tests;
	}

}
