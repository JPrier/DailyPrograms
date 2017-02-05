package dailyJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* The Challenge: (((3))) is an expression with too many parentheses.
 * 
 * The rule for "too many parentheses" around part of an expression is that if 
 * removing matching parentheses around a section of text still leaves that section 
 * enclosed by parentheses, then those parentheses should be removed as extraneous.
 *
 * (3) is the proper stripping of extra parentheses in above example.
 *
 * ((a((bc)(de)))f) does not have any extra parentheses. 
 *
 * Removing any matching set of parentheses does not leave a "single" parenthesesed group that was previously 
 * enclosed by the parentheses in question.
 */

//TODO: Why the hell is this in a class...go to bed dumbass
public class TooMany {
	private static String tooMany(String e){
		List<List<Integer>> pair = findPar(e);
		//TODO: This method is not properly collecting pairs to filter
		List<Integer> pars = new ArrayList<>();
		System.out.println(pair.toString());
		for(int i=0; i<pair.size(); i++){
			if (pair.size() - 1> i && (pair.get(i).get(0) == pair.get(i + 1).get(0) - 1 || pair.get(i).get(0) == pair.get(i + 1).get(0) + 1) && 
					(pair.get(i).get(1) == pair.get(i + 1).get(1) - 1 || pair.get(i).get(1) == pair.get(i + 1).get(1) + 1)){
				pars.add(pair.get(i).get(0));
				pars.add(pair.get(i).get(1));
			}
			if (pair.get(i).get(0) == pair.get(i).get(1) - 1){
				pars.add(pair.get(i).get(0));
				pars.add(pair.get(i).get(1));
			}
		}
		return filterExp(pars, e);
	}
	private static String filterExp(List<Integer> p, String e){
		int j = 0;
		StringBuilder sb = new StringBuilder(e);
		System.out.println(p.toString());
		for(int i = 0; i < p.size(); i++){
			sb.deleteCharAt(p.get(i) - j);
			j++;
		}
		return sb.toString();
	}
	//TODO: I think findPar is not collecting parentheses indices correctly
	private static List<List<Integer>> findPar(String e){
		List<List<Integer>> pairs = new ArrayList<>();
		int j =0;
		for (int i = 0;i < e.length();i++){
			if (e.charAt(i) == '('){
				List<Integer> temp = new ArrayList<>();
				temp.add(0, i);
				j++;
				pairs.add(temp);
			} if (e.charAt(i) == ')'){
				pairs.get(j-1).add(i);
				j--;
			}
		}
		return pairs;
	}
	
	
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter an expression: ");
		String e = reader.next();
		reader.close();
		System.out.println(tooMany(e));
	}
}
