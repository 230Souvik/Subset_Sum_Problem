        #Recursion

Given a set of non-negative integers and a value sum, the task is to check if there is a subset of the given set whose sum is equal to the given sum. 

Examples: 

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True
Explanation: There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
Explanation: There is no subset that add up to 30.


Subset Sum Problem using Recursion:
For the recursive approach, there will be two cases. 

Consider the ‘last’ element to be a part of the subset. Now the new required sum = required sum – value of ‘last’ element.
Don’t include the ‘last’ element in the subset. Then the new required sum = old required sum.
In both cases, the number of available elements decreases by 1.

Mathematically the recurrence relation will look like the following:

isSubsetSum(set, n, sum) = isSubsetSum(set, n-1, sum) | isSubsetSum(set, n-1, sum-set[n-1])

Base Cases:
isSubsetSum(set, n, sum) = false, if sum > 0 and n = 0
isSubsetSum(set, n, sum) = true, if sum = 0

The structure of the recursion tree will be like the following:

Structure of the recursion tree of the above recursion formula
Structure of the recursion tree of the above recursion formula

Follow the below steps to implement the recursion:

Build a recursive function and pass the index to be considered (here gradually moving from the last end) and the remaining sum amount.
For each index check the base cases and utilize the above recursive call.
If the answer is true for any recursion call, then there exists such a subset. Otherwise, no such subset exists.






                  #DP

                  
To solve the problem in Pseudo-polynomial time we can use the Dynamic programming approach.

So we will create a 2D array of size (n + 1) * (sum + 1) of type boolean. The state dp[i][j] will be true if there exists a subset of elements from set[0 . . . i] with sum value = ‘j’. 

The dynamic programming relation is as follows: 

if (A[i-1] > j)
    dp[i][j] = dp[i-1][j]
else 
    dp[i][j] = dp[i-1][j] OR dp[i-1][j-set[i-1]]

This means that if the current element has a value greater than the ‘current sum value’ we will copy the answer for previous cases and if the current sum value is greater than the ‘ith’ element we will see if any of the previous states have already experienced the sum= j OR any previous states experienced a value ‘j – set[i]’ which will solve our purpose.

Illustration:

See the below illustration for a better understanding:

Consider set[] = {3, 4, 5, 2} and sum = 6.

The table will look like the following where the column number represents the sum and the row number represents the index of set[]:

 
