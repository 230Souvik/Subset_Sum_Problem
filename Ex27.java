
package ex27;
import java.util.*;

public class Ex27 {

   static boolean isSubsetSum1(int set[], int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
 
        // If last element is greater than
        // sum, then ignore it
        if (set[n - 1] > sum)
            return isSubsetSum1(set, n - 1, sum);
 
        // Else, check if sum can be obtained
        // by any of the following
        // (a) including the last element
        // (b) excluding the last element
        return isSubsetSum1(set, n - 1, sum)
            || isSubsetSum1(set, n - 1, sum - set[n - 1]);
    }
   
   
   static boolean isSubsetSum2(int set[], int n, int sum)
    {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum + 1][n + 1];
 
        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;
 
        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;
 
        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j]
                        = subset[i][j]
                          || subset[i - set[j - 1]][j - 1];
            }
        }
 
        return subset[sum][n];
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        Scanner sc=new Scanner(System.in);
        int n = set.length;
        System.out.println("1-> recursion \n2. DP Table");
        int k=sc.nextInt();
        switch(k){
            case 1:{
        if (isSubsetSum1(set, n, sum) == true)
            System.out.println("Found a subset"
                               + " with given sum");
        else
            System.out.println("No subset with"
                               + " given sum");
        break;
        }
            case 2:{
                 if (isSubsetSum2(set, n, sum) == true)
            System.out.println("Found a subset"
                               + " with given sum");
        else
            System.out.println("No subset with"
                               + " given sum");
            }
    }
    }
    
}
