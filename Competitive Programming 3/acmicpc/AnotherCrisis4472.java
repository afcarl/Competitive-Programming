package acmicpc;
import java.util.*;
import java.math.*;
import java.io.*;
public class AnotherCrisis4472 {
	
	static ArrayList<ArrayList<Integer>> adj;			
	static double t;
		
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ln;
		
		while( !(ln = br.readLine() ).equals("0 0"))
		{
			String[] sp = ln.split(" ");
			int n = Integer.parseInt(sp[0]); t = Double.parseDouble(sp[1]);
			String[] hier = br.readLine().split(" ");
			adj = new ArrayList<ArrayList<Integer>>();
			adj.add(new ArrayList<Integer>());
			for (int i = 0; i < hier.length; i++) 
			{
				adj.add(new ArrayList<Integer>());
				adj.get(Integer.parseInt(hier[i])).add(i+1);
			}
			
			System.out.println(minWorkers(0));
		}
	}
	
	public static int minWorkers(int node)
	{
		if(node == 0 && adj.get(node).size() == 0) return 0;
		else if (adj.get(node).size() == 0) return 1;
		
		long needChild =  (long) Math.ceil(t / 100 * adj.get(node).size());
		int sum = 0;
		ArrayList<Integer> childMinWork = new ArrayList<Integer>();
		for (int i = 0; i < adj.get(node).size(); i++) {
			childMinWork.add(minWorkers(adj.get(node).get(i)));
		}
		Collections.sort(childMinWork);
		for(int i = 0; i < needChild; i++) sum+= childMinWork.get(i);
		
		
		return sum;
		
	}
}