import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RotateMain {
	

		private static final String INPUT = "out\\production\\rotate\\A-small-practice.in";
		private static final String OUTPUT = "out\\production\\rotate\\A-small-practice.out";

	public static void main(String[] args) {

		Test[] tests = createTests(INPUT);
		
		for (int i = 0;i <tests.length;i++){
			tests[i].dropANdRotate();
			System.out.println(toString(tests[i].getLines()));
			if (checkWin(tests[i])){
				System.out.println("winner");
			}else{
				tests[i].rotate();
				if (checkWin(tests[i])){
					System.out.println("winner");
				} else{
					System.out.println("no winner\n\n\n");
				}
				
			}
		}

		
		

		

	}
	
	
	private static boolean checkWin(Test test) {
		boolean result = false;
		for (Line line:test.lines){
			result = result || line.isWinK("B");
			result = result || line.isWinK("R");
		}
		return result;
	}


	public static Line[] getLines(Test test){
		return test.getLines();
	}
	
	public static Test[] createTests(String fileName){
		Test[] tests = null;
		
		int noTests;
			
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			noTests = Integer.parseInt(br.readLine());
			tests = new Test[noTests];
			for (int count = 0;count<noTests;count++ ){
				tests[count] = readTest(br); 
			}
		} catch (IOException e) {
			System.err.println(fileName+" not found");
			e.printStackTrace();
		}
		return tests;
	}
	
	// currently wrong, prints out sideways
	public static String toString(Line[] lines){
		StringBuilder sb = new StringBuilder();
		for (Line line:lines){
			sb.append(line.toString()+ "\n");
		}
		return sb.toString();	
	}

	public static Test readTest(BufferedReader br ) throws IOException{
		String[] details = br.readLine().split(" ");
		int size = Integer.parseInt(details[0]);
		String[] lines = new String[size];
		int winK = Integer.parseInt(details[1]);
		for (int i=0;i<size;i++){
			lines[i] = br.readLine();
		}
		
		return new Test(lines,winK);
	}
}
/**
 * Is an Array of Tiles that is line on the table, up, down, diagonally
 * @author swest03
 *
 */
class Line{
	String line;
	int winK;
	
	public Line(String line, int winK){
		this.line = line;
		this.winK = winK;
	}
	
	public Line drop(){
		int length = line.length();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i=0;i<length;i++){
			if (line.charAt(i) == '.'){
				count++;
			} else{
				sb.append(line.charAt(i));
			}
		}
		for (int j=0;j<count;j++){
			sb.append(".");
		}
		return new Line(sb.toString(),winK);
	}
	
	public boolean isWinK(String color){
		String string = "";
		for (int i = 0;i <winK;i++){
			string = string + color;
		}
		return line.contains(string);
	}
	
	public String toString(){
		return line;
	}
}

class Test{
	Line[] lines;
	final int length;
	final int winK;
	
	Test(String[] lines, int winK){	
		this.length = lines.length;
		this.winK = winK;
		this.lines = new Line[length];
		for (int i = 0;i<length;i++){
			this.lines[i] = new Line(lines[i],winK);
		}
	}
	
	public void drop(){
		for (int i = 0; i<lines.length;i++){
			lines[i] = lines[i].drop();
		}
	}
	
	public void dropANdRotate(){
		drop();
		rotate();
	}

	public void rotate() {
		
		Line newLines[] = new Line[length];
		// more efficient is swapping
		for (int i = 0;i<length;i++){
			StringBuilder sb = new StringBuilder();
			for (int j = 0;j<length;j++){
				sb.append(lines[j].toString().charAt(i));
			}
			newLines[length-i-1] = new Line(sb.toString(),winK);
		}
		lines = newLines;		
	}

	public Line[] getLines() {
		return lines;
	}

	public int getWinK() {
		return winK;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (Line line:lines){
			sb.append(line.toString()+"\n");
		}
		return sb.toString();
	}
}


