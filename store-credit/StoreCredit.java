package cj_store_credit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class StoreCredit{
	
	private static final String output = "src//cj_store_credit//A-large-practice.out";
	private static final String input = "src//cj_store_credit//A-large-practice.in";;

	public static void main(String...args){
		Input[] inputs = readInputs(input);
		writeOutput(output, inputs);
		
	}

	public static void writeOutput(String outputFileName, Input[] inputs){
        File file = new File(outputFileName);
		try (BufferedWriter out = new BufferedWriter(new FileWriter(file))){
			int caseNumber = 0;
			for(Input input:inputs){
				out.write(input.toString(caseNumber++)+System.lineSeparator());
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static Input[] readInputs(String filename){
		Input[] inputs = null;
		try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
			String line;
			int testCount = 0;
			inputs = new Input[Integer.parseInt(in.readLine())];
			while ((line = in.readLine()) != null) {
				
				inputs[testCount++] = new Input(Integer.parseInt(line),
										Integer.parseInt(in.readLine()),
										line = in.readLine());
				//testCount++;
			}
		} catch (FileNotFoundException ex) {
				System.out.println("File " + filename + " does not exist.");
		} catch (IOException ex) {
				ex.printStackTrace();
		}
		return inputs;	
	}
}

class Input {
	
	private int credit;
	private int[] prices;
	
	public Input(int credit, int items, String prices) {
		this.credit = credit;
		setPrices(prices);		
	}

	private String getResult() {
		TreeSet<Integer> tree = new TreeSet<>();
		
		// create tree
		for (int price:prices){
			if (price<credit){
				tree.add(price);
			}
		}
		for (int itemOne:tree){
			int itemTwo = credit - itemOne;
			int a =-1;
			int b =-1;
			if (tree.contains(itemTwo)){
				int index = 0;
				for (int price:prices){
					if (itemTwo==price && a<0){
						a = index+1;
					}
					if (itemOne == price  && b<0 && a-1!= index){
						b = index+1;
					}
					if (a>0 && b>0){
						return (a<b)?a+" "+b:b+" "+a;
					}
					index++;
				}
			}
		}
		return null;
	}
	
	public String toString(int caseNumber){
		return "Case #"+(caseNumber+1)+": " + getResult();		
	}
	
	public void setPrices(String string) {
		String[] prices = string.split(" ");
		int count = 0;
		this.prices = new int[prices.length];
		for (String price : prices){
			this.prices[count++] = Integer.parseInt(price);
		}
	}
}
