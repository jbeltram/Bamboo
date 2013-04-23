import java.util.ArrayList;
import java.util.Random;

//import org.apache.commons.math3.distribution.ZipfDistribution;


public class TestBed {
	public static void main(String [] args){
		TestBed tb = new TestBed();
		double[] times = new double[2];

		tb.removeIncremental( 10000, 10);
//		tb.removeRandom(10000, 10000, 10);
		
		times = tb.removeIncremental( 1000, 5);
		System.out.println(times[0] + "\n" + times[1]);
		System.out.println();
		times = tb.removeIncremental( 5000, 5);
		System.out.println(times[0] + "\n" + times[1]);
		System.out.println();
		times = tb.removeIncremental( 10000, 5);
		System.out.println(times[0] + "\n" + times[1]);
		System.out.println();
		
//		times = tb.removeRandom(10000, 1000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		times = tb.removeRandom(10000, 5000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		times = tb.removeRandom(10000, 10000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
		
		
//		tb.buildTreeRandom(10000,10);
//		times = tb.buildTreeRandom(1000,5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		times = tb.buildTreeRandom(5000,5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		times = tb.buildTreeRandom(10000,5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
		
//		tb.buildTreeIncremental(10000,10);
//		times = tb.buildTreeIncremental(1000,5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		times = tb.buildTreeIncremental(5000,5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		times = tb.buildTreeIncremental(10000,5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
		

//		times = tb.searchDistributionRefresh(1000, 10000, 1000, 10);
//		System.out.println("Search performances for zipf distributions");
//		//Search tree size = 1,000, number of searches 10,000
//		times = tb.searchDistributionRefresh(1000, 10000, 1000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		
//		//Search tree size = 50,000, number of searches 100,000
//		times = tb.searchDistributionRefresh(1000, 25000, 1000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		
//		//Search tree size = 50,000, number of searches 500,000
//		times = tb.searchDistributionRefresh(1000, 50000, 1000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		
//		//Search tree size = 50,000, number of searches 1,000,000
//		times = tb.searchDistributionRefresh(1000, 100000, 1000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		
//		//Search tree size = 250,000, number of searches 10,000
//		times = tb.searchDistributionRefresh(10000, 10000, 10000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		
//		//Search tree size = 250,000, number of searches 100,000
//		times = tb.searchDistributionRefresh(10000, 25000, 10000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		
//		//Search tree size = 250,000, number of searches 500,000
//		times = tb.searchDistributionRefresh(10000, 50000, 10000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		
//		//Search tree size = 250,000, number of searches 1,000,000
//		times = tb.searchDistributionRefresh(10000, 100000, 10000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		
		
//		times = tb.searchRandomRefresh(500, 10000, 500, 10);
//		
//		System.out.println("Search performances for random distributions");
//		//Search tree size = 500, number of searches 10,000
//		times = tb.searchRandomRefresh(500, 10000, 500, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//
//		//Search tree size = 500, number of searches 25,000
//		times = tb.searchRandomRefresh(500, 25000, 500, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//
//		//Search tree size = 500, number of searches 50,000
//		times = tb.searchRandomRefresh(500, 50000, 500, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//
//		//Search tree size = 500, number of searches 100,000
//		times = tb.searchRandomRefresh(500, 100000, 500, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		
//		//Search tree size = 1000, number of searches 10,000
//		times = tb.searchRandomRefresh(1000, 10000, 1000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//
//		//Search tree size = 1000, number of searches 25,000
//		times = tb.searchRandomRefresh(1000, 25000, 1000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//
//		//Search tree size = 1000, number of searches 50,000
//		times = tb.searchRandomRefresh(1000, 50000, 1000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//
//		//Search tree size = 1000, number of searches 100,000
//		times = tb.searchRandomRefresh(1000, 100000, 1000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		
//		//Search tree size = 5000, number of searches 10,000
//		times = tb.searchRandomRefresh(5000, 10000, 5000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//
//		//Search tree size = 5000, number of searches 25,000
//		times = tb.searchRandomRefresh(5000, 25000, 5000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//
//		//Search tree size = 5000, number of searches 50,000
//		times = tb.searchRandomRefresh(5000, 50000, 5000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//
//		//Search tree size = 5000, number of searches 100,000
//		times = tb.searchRandomRefresh(5000, 100000, 5000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//		
//		//Search tree size = 10000, number of searches 10,000
//		times = tb.searchRandomRefresh(10000, 10000, 10000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//
//		//Search tree size = 10000, number of searches 25,000
//		times = tb.searchRandomRefresh(10000, 25000, 10000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//
//		//Search tree size = 10000, number of searches 50,000
//		times = tb.searchRandomRefresh(10000, 50000, 10000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
//
//		//Search tree size = 10000, number of searches 100,000
//		times = tb.searchRandomRefresh(10000, 100000, 10000, 5);
//		System.out.println(times[0] + "\n" + times[1]);
//		System.out.println();
	}
	
	double[] removeIncremental(int size, int numRuns){
		SplayTree<Integer> st;
		BiasedEnergyBalancedTree<Integer> bt;
		
		long t1;
		long t2;
		Random r = new Random();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int num = 0;
		
		double[] times = new double[2];
		double[] ebtTimes = new double[numRuns];
		double[] splayTimes = new double[numRuns];
		for(int k = 0; k < numRuns; k++){
			st = new SplayTree<Integer>();
			bt = new BiasedEnergyBalancedTree<Integer>();
			
			nums.clear();
			for(int i = 0; i < 10000; i++){
				num = r.nextInt(10000);
				while(nums.contains(num))
					num = r.nextInt(10000);
				nums.add(num);
			}
			
			for(int i = 0; i < 10000; i ++){
				st.add(nums.get(i));
				bt.insert(nums.get(i));
			}
			
			t1 = System.nanoTime();
			for(int i = 0; i < size; i++){
				st.remove(i);
			}
			t2 = System.nanoTime();
			splayTimes[k] = (double)((t2-t1)/1000000);
			
			t1 = System.nanoTime();
			for(int i = 0; i < size; i++){
				bt.removeTest(i);
			}
			t2 = System.nanoTime();
			ebtTimes[k] = (double)((t2-t1)/1000000);
		}
		
		double average = 0;
		for(double i : splayTimes){
			average += i;
		}
		average = average/splayTimes.length;
		times[0] = average;
		
		average = 0;
		for(double i : ebtTimes){
			average += i;
		}
		average = average/ebtTimes.length;
		times[1] = average;
		
		return times;
	}
	
	double[] removeRandom(int treesize, int size, int numRuns){
		SplayTree<Integer> st;
		BiasedEnergyBalancedTree<Integer> bt;
		
		long t1;
		long t2;
		Random r = new Random();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int num = 0;
		
		double[] times = new double[2];
		double[] ebtTimes = new double[numRuns];
		double[] splayTimes = new double[numRuns];
		for(int k = 0; k < numRuns; k++){
			st = new SplayTree<Integer>();
			bt = new BiasedEnergyBalancedTree<Integer>();
			
			nums.clear();
			for(int i = 0; i < treesize; i++){
				num = r.nextInt(treesize);
				while(nums.contains(num))
					num = r.nextInt(treesize);
				nums.add(num);
			}
			
			for(int i = 0; i < treesize; i ++){
				st.add(nums.get(i));
				bt.insert(nums.get(i));
			}
			
			nums.clear();
			for(int i = 0; i < size; i++){
				num = r.nextInt(size);
				while(nums.contains(num))
					num = r.nextInt(size);
				nums.add(num);
			}
			
			t1 = System.nanoTime();
			for(int i = 0; i < size; i++){
				st.remove(nums.get(i));
			}
			t2 = System.nanoTime();
			splayTimes[k] = (double)((t2-t1)/1000000);
			
			t1 = System.nanoTime();
			for(int i = 0; i < size; i++){
				bt.removeTest(i);
			}
			t2 = System.nanoTime();
			ebtTimes[k] = (double)((t2-t1)/1000000);
		}
		
		double average = 0;
		for(double i : splayTimes){
			average += i;
		}
		average = average/splayTimes.length;
		times[0] = average;
		
		average = 0;
		for(double i : ebtTimes){
			average += i;
		}
		average = average/ebtTimes.length;
		times[1] = average;
		
		return times;
	}
	
	double[] searchDistributionRefresh(int range, int numValues, int size, int numRuns){
		
		double[] averageTimes = new double[2];
		double[] splayTimes = new double[numRuns];
		double[] ebtTimes = new double[numRuns];
		
		//SplayTree<Integer> st;
		//BiasedEnergyBalancedTree<Integer> bt;
		
		zipfGenerator zipf;
		ArrayList<Integer> values = new ArrayList<Integer>();
		long t1;
		long t2;
		
		for(int i = 0; i < numRuns; i++){
			SplayTree<Integer> st = new SplayTree<Integer>();
			for(int k = 0; k < size; k++){
				st.add(k);
			}
			BiasedEnergyBalancedTree<Integer> bt = new BiasedEnergyBalancedTree<Integer>();
			for(int n = 0; n < size; n++){
				bt.insert(n);
			}
			
			zipf = new zipfGenerator(range, 1.5);
			values.clear();
			for(int j=0;j < numValues; j++){
				values.add(zipf.next());
			}
			
			t1 = System.nanoTime();
			for(int k = 0; k < values.size(); k++){
				st.find(values.get(k));
			}
			t2 = System.nanoTime();
			splayTimes[i] = ((double)(t2-t1)/1000000);
			
			t1 = System.nanoTime();
			for(int k = 0; k < values.size(); k++){
				bt.search(values.get(k));
			}
			t2 = System.nanoTime();
			ebtTimes[i] = (double)((t2-t1)/1000000);
		}
		
		double average = 0;
		for(double i : splayTimes){
			average += i;
		}
		average = average/splayTimes.length;
		averageTimes[0] = average;
		
		average = 0;
		for(double i : ebtTimes){
			average += i;
		}
		average = average/ebtTimes.length;
		averageTimes[1] = average;
		
		return averageTimes;
	}
	
	double[] searchRandomRefresh(int range, int numValues, int size, int numRuns){
		Random r = new Random();
	
		double[] averageTimes = new double[2];
		double[] splayTimes = new double[numRuns];
		double[] ebtTimes = new double[numRuns];
		
		SplayTree<Integer> st;
		BiasedEnergyBalancedTree<Integer> bt;
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		long t1;
		long t2;
		
		for(int i = 0; i < numRuns; i++){
			st = new SplayTree<Integer>();
			for(int k = 0; k < size; k++){
				st.add(k);
			}
			bt = new BiasedEnergyBalancedTree<Integer>();
			int n = 0;
			for(n = 0; n < size-1; n++){
				bt.insert(n);
			}
			
			values.clear();
			for(int j=0;j < numValues; j++){
				values.add(r.nextInt(range));
			}
			
			t1 = System.nanoTime();
			for(int k = 0; k < values.size(); k++){
				st.find(values.get(k));
			}
			t2 = System.nanoTime();
			splayTimes[i] = (double)((t2-t1)/1000000);
			
			t1 = System.nanoTime();
			for(int k = 0; k < values.size(); k++){
				bt.search(values.get(k));
			}
			t2 = System.nanoTime();
			ebtTimes[i] = (double)((t2-t1)/1000000);
		}
		
		double average = 0;
		for(double i : splayTimes){
			average += i;
		}
		average = average/splayTimes.length;
		averageTimes[0] = average;
		
		average = 0;
		for(double i : ebtTimes){
			average += i;
		}
		average = average/ebtTimes.length;
		averageTimes[1] = average;
		
		return averageTimes;
	}
	
	double[] buildTreeIncremental(int size, int numRuns){
		BiasedEnergyBalancedTree<Integer> bt;
		SplayTree<Integer> st;
		long t1;
		long t2;
		
		double[] times = new double[numRuns];
		double[] ebtTimes = new double[numRuns];
		double[] splayTimes = new double[numRuns];
		for(int k = 0; k < numRuns; k++){
			bt = new BiasedEnergyBalancedTree<Integer>();
			st = new SplayTree<Integer>();
			t1 = System.nanoTime();
			for(int i = 0; i < size; i++){
				st.add(i);
			}
			t2 = System.nanoTime();
			splayTimes[k] = (double)((t2-t1)/1000000);
			
			t1 = System.nanoTime();
			for(int i = 0; i < size; i++){
				bt.insert(i);
			}
			t2 = System.nanoTime();
			ebtTimes[k] = (double)((t2-t1)/1000000);
		}
		
		double average = 0;
		for(double i : splayTimes){
			average += i;
		}
		average = average/splayTimes.length;
		times[0] = average;
		
		average = 0;
		for(double i : ebtTimes){
			average += i;
		}
		average = average/ebtTimes.length;
		times[1] = average;
		
		return times;
	}
	
	double[] buildTreeRandom(int size, int numRuns){
		SplayTree<Integer> st;
		BiasedEnergyBalancedTree<Integer> bt;
		long t1;
		long t2;
		
		Random r = new Random();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int num = 0;
		
		double[] times = new double[numRuns];
		double[] ebtTimes = new double[numRuns];
		double[] splayTimes = new double[numRuns];
		for(int k = 0; k < numRuns; k++){
			bt = new BiasedEnergyBalancedTree<Integer>();
			st = new SplayTree<Integer>();
			
			nums.clear();
			for(int i = 0; i < size; i++){
				num = r.nextInt(size);
				while(nums.contains(num))
					num = r.nextInt(size);
				nums.add(num);
			}
			
			t1 = System.nanoTime();
			for(int i = 0; i < size; i++){
				st.add(nums.get(i));
			}
			t2 = System.nanoTime();
			splayTimes[k] = (double)((t2-t1)/1000000);
			
			t1 = System.nanoTime();
			for(int i = 0; i < size; i++){
				bt.insert(nums.get(i));
			}
			t2 = System.nanoTime();
			ebtTimes[k] = (double)((t2-t1)/1000000);
		}
		
		double average = 0;
		for(double i : splayTimes){
			average += i;
		}
		average = average/splayTimes.length;
		times[0] = average;
		
		average = 0;
		for(double i : ebtTimes){
			average += i;
		}
		average = average/ebtTimes.length;
		times[1] = average;
		
		return times;
	}
}
