package com.Java8.newfeature.Java8.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test2Test {
	int arr[]= {11, 13, 21, 3};
	
//	@Test
//	void testPrintNGEV2() {
//		int arrInput[]= {11, 13, 21, 3};
//		int expected[] = {13,21,-1,-1};
//		assertArrayEquals(expected, new Test2().printNGE(arrInput, 4));
//	}
	
	@Test
	void testPrintNGEV3() {
		int arrInput[]= {11, 13, 21, 3};
		int expected[] = {13,21,-1,-1};
		assertArrayEquals(expected, new Test2().printNGE3(arrInput, 4));
	}
	

}
