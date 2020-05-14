package com.akash.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Date_051420_ContinousSubArrayWithGivenSum 
{
	/*
	 * Platform:- GeeksForGeeks
	 * Problem:- https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
	 * My Solution:- https://practice.geeksforgeeks.org/viewSol.php?subId=2624ee4543e296ffe0eb53652abbda4b&pid=590&user=13akashnigam
	 * Solution Date:- 05/14/2020
	 */
	public static String getContinousSubArrayIndexWithSum(int a[], int expectedSum)
	{
		if(expectedSum<0)
			return "-1";
		int leftPointer1 = 0;
		int leftPointer2 = 0;
		int currentSum = a[0];

		while(leftPointer1<a.length && leftPointer2<a.length)
		{
			if(currentSum == expectedSum)
				return ""+(leftPointer1+1)+" "+(leftPointer2+1);
			else if(currentSum < expectedSum)
			{
				leftPointer2++;
				if(leftPointer2 < a.length)
					currentSum = currentSum + a[leftPointer2];
			}
			else
			{
				if(leftPointer1 < a.length)
				{
					currentSum = currentSum - a[leftPointer1];
					leftPointer1++;
				}
			}	
		}
		return "-1";
	}
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		 //System.out.println("Enter the number of test cases");
		 int T = Integer.parseInt(in.readLine());
		 for(int i=0; i<T; i++)
		 {
			 //System.out.println("Enter the number of elements and expected sum");
			 String input[] = in.readLine().split(" ");
			 int N = Integer.parseInt(input[0]);
			 int S = Integer.parseInt(input[1]);
			 //System.out.println("Enter the elements");
			 String elements[] = in.readLine().split(" ");
			 int inputArr[] = new int[N];
			 for(int j=0; j<N; j++)
			 {
				 inputArr[j] = Integer.parseInt(elements[j]);
			 }
			 System.out.println(getContinousSubArrayIndexWithSum(inputArr, S));
		 }
	}

}
