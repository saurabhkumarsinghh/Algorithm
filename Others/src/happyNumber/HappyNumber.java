package happyNumber;

import java.util.HashSet;

/*Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive 
 integer, replace the number by the sum of the squares of its digits, and repeat the 
 process until the number equals 1 (where it will stay), or it loops endlessly in a cycle
 which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 */

public class HappyNumber {
	public int squireSum(int n) {
		int last, sum = 0;
		while (n > 0) {
			last = n % 10;
			sum = sum + last * last;
			n = n / 10;
		}
		return sum;
	}

	public boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		while (n != 1) {
			if (set.contains(n))
				return false;
			set.add(n);
			n = squireSum(n);
		}
		return true;
	}

	
	public static void main(String[] args){
		HappyNumber happy = new HappyNumber();
		System.out.println(happy.isHappy(19));
	}
}
