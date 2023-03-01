package com.Java8.newfeature.Java8.main;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.web.servlet.mvc.LastModified;

import com.Java8.newfeature.Java8.dblayer.DbLayer;
import com.Java8.newfeature.Java8.streams.StreamApis;

import ch.qos.logback.core.pattern.color.BoldWhiteCompositeConverter;

public class Test2 {
	static StreamApis getStreamApis() {
		DbLayer dbLayer = new DbLayer();
		StreamApis test = new StreamApis(dbLayer);
		return test;
	}
	
	static int[] printNGE(int arr[], int n)
    {	 int[] finalResutl = new int[n]; int finalArrayCount = 0;
    	boolean hit = false;
        int next, i, j;
        for (i=0; i<n; i++)
        {
            next = -1;
            for (j = i+1; j<n; j++)
            {
                if (arr[i] < arr[j])
                {
                    next = arr[j];
                    finalResutl[finalArrayCount++] = arr[j];
                    hit = true;
                    break;
                } else {
					hit = false;
				}
            }
            
            if(hit == false)
            	finalResutl[finalArrayCount++] = -1;
            
            System.out.println(arr[i]+" -- "+next);
        }

        return finalResutl;
    }
	
	
	static int[] printNGEV2(int arr[], int n)
    {
        int next, i, j,last;
        int[] finalResutl = new int[n]; int finalArrayCount = 0;
        for (i=0; i<n; i++)
        {
            next = -1;
            last=i+1;
           
            for (j = last; j<i-1; j++)
            {
                if (arr[i] < arr[j])
                {
                    next = arr[j];
                    finalResutl[finalArrayCount++] = arr[j];
                    break;
                }
                if(last == n-1)
                	last = 0;
            }
            System.out.println(arr[i]+" -- "+next);
            
        }
        
        return finalResutl;
    }
	//[1, 25, 2, 3]
	//[0, 1,  2, 3]
	//i = 1 = 2, 3,
	
	static int[] printNGE3(int arr[], int n) {
		
		int finalArrCounter = 0;
		boolean hit = false;
		int finalArr[] = new int[n];
		for (int i = 0; i < n; i++) {
			if (i != 0) {
				int tempCopiedArry[] = new int[i];
				int finalConatArr[] = new int[tempCopiedArry.length + arr.length];
				tempCopiedArry[i-1] = arr[i-1];
//				System.out.println(tempCopiedArry.length);
				System.arraycopy(tempCopiedArry, 0, finalConatArr, n, tempCopiedArry.length);
				System.out.println(Arrays.toString(arr));
			}
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					finalArr[finalArrCounter++] = arr[j];
					hit = true;
					break;
				} else {
					hit = false;
				}
			}
			
			if (hit == false)
				finalArr[finalArrCounter++] = -1;
		}

		return finalArr;
	}
	
static int[] printNGE4(int arr[], int n) {
		
		int finalArrCounter = 0;
		boolean hit = false;
		int finalArr[] = new int[n];
		for (int i = 0; i < n; i++) {
			
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					finalArr[finalArrCounter++] = arr[j];
					hit = true;
					break;
				} else {
					hit = false;
				}
			}
			
			if (hit == false)
				finalArr[finalArrCounter++] = -1;
		}

		return finalArr;
	}
	
	
	
	static public String longestCommonPrefix(String[] a)
    {
        int size = a.length;
 
        /* if size is 0, return empty string */
        if (size == 0)
            return "";
 
        if (size == 1)
            return a[0];
 
        /* sort the array of strings */
        Arrays.sort(a);
        
        System.out.println("Sorted array :"+ Arrays.toString(a));
      
        
        //[geek, geeks, geeksforgeeks, geezer]
        //[Man, Mango, banana, bawling]
        /* find the minimum length from first and last string */
        int end = Math.min(a[0].length(), a[size-1].length());
 
        /* find the common prefix between the first and
           last string */
        int i = 0;
        while (i < end && a[0].charAt(i) == a[size-1].charAt(i) )
            i++;
 
        String pre = a[0].substring(0, i);
        return pre;
    }
	
	public String longestCommonPrefix(String[] a)
    {
        int size = a.length;
 
        /* if size is 0, return empty string */
        if (size == 0)
            return "";
 
        if (size == 1)
            return a[0];
 
        /* sort the array of strings */
        Arrays.sort(a);
 
        /* find the minimum length from first and last string */
        int end = Math.min(a[0].length(), a[size-1].length());
 
        /* find the common prefix between the first and
           last string */
        int i = 0;
        while (i < end && a[0].charAt(i) == a[size-1].charAt(i) )
            i++;
 
        String pre = a[0].substring(0, i);
        return pre;
    }
	static void testLongestCommonPrefix() {	
        String[] input = {"geeksforgeeks", "geeks", "geek", "geezer"};
        
        String[] input2 = {"banana", "bawling", "Mango", "Man",""};
        
        String[] input3 = {"flower","flow","ight"};
        
        System.out.println( "The longest Common Prefix is : " +
                                   longestCommonPrefix(input3));
	}
	
	static public void testPrintNGE() {
		int arr[]= {11, 13, 21, 3};
		
		
        int n = arr.length;
        Integer[] printNGE = printNGE(arr, n);
        Arrays.asList(printNGE).stream().forEach(System.out::println);
//        
	}
	
	public static void main(String[] args) {
		StreamApis streamApis = getStreamApis();
		
//		testPrintNGE();
//		int arrInput[]= {11, 13, 21, 3};
//		int expected[] = {13,21,-1,-1};
//		printNGE3(arrInput, arrInput.length);
//		testLongestCommonPrefix();
//		streamApis.testMapReduce();
//		try {
//			streamApis.testPureOptionalWithoutStream();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		int[] array1 = {1, 2, 3};
//        int[] array2 = {4, 5, 6};
//        
//        int aLen = array1.length;
//        int bLen = array2.length;
//        int[] result = new int[aLen + bLen];
//        
//        System.arraycopy(array1, 0, result, 0, aLen);
//        System.arraycopy(array2, 0, result, aLen, bLen);
//        
//        System.out.println(Arrays.toString(result));
//		int[] a = {1, 2, 3,10,11};
//		int start = a[3];
//				for (int i = 0; i < a.length -1; i++) {
////					System.out.println((start + i) % a.length);
//				    System.out.println(a[(start + i) % a.length]);
//				}
//		int arrInput[]= {11, 13, 21, 3};
////		int expected[] = {13,21,-1,-1};
//		printNGE3(arrInput, arrInput.length);
		
		String[] input = {"geeksforgeeks", "geeks", "banana", "baal"};
        System.out.println( "The longest Common Prefix is : " +
                                   longestCommonPrefix(input));
		
	}
}
