package com.Java8.newfeature.Java8.streams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.Java8.newfeature.Java8.dblayer.DbLayer;

class StreamApisTestCase1 {
	
	StreamApis getStreamApis() {
		DbLayer dbLayer = new DbLayer();
		StreamApis test = new StreamApis(dbLayer);
		return test;
	}
	
	StreamApis streamApis = getStreamApis();
	
//	@Test
//	void testTestMap() {
//		streamApis.testMap();
//	}
//
//	@Test
//	void testTestFlatMap() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testConvertListOfListToSingleList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testTestMapToObj() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testTestMapReduce() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testTestPureOptionalWithoutStream() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testTestOptionalwithStream() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testWriteLogsToLogsFile() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSortMapUsingStreamApi() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSortMapUsingTraditionalApproach() {
//		fail("Not yet implemented");
//	}
//
//	@Test
	void testTestConvertListToMap() {
		streamApis.testConvertListToMap();
	}
	
	@Test
	void testsortListUsingStreamApi() {
		streamApis.sortListUsingStreamApi();
	}
//
//	@Test
//	void testTestConvertListToArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testTestConvertMapToList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testObject() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetClass() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testHashCode() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testEquals() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testClone() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testToString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testNotify() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testNotifyAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testWait() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testWaitLong() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testWaitLongInt() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFinalize() {
//		fail("Not yet implemented");
//	}

}
