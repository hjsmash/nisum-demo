package com.example.demo;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.ZipCodeRange;

public class RangeConsolidatorTest extends NisumRangeConsolidatorApplicationTests {

	@Autowired
	private RangeConsolidator rangeConsolidator;

	ArrayList<ZipCodeRange> inputList;
	ArrayList<ZipCodeRange> outputList;

	@Before
	public void initSetup() {

		inputList = new ArrayList<>();
		outputList = new ArrayList<>();
		outputList.add(new ZipCodeRange(94133, 94133));
		outputList.add(new ZipCodeRange(94200, 94399));

	}

	@Test
	public void testMergeRange() {
		inputList.add(new ZipCodeRange(94133, 94133));
		inputList.add(new ZipCodeRange(94200, 94299));
		inputList.add(new ZipCodeRange(94226, 94399));

		Assert.assertArrayEquals(outputList.toArray(), rangeConsolidator.mergeRanges(inputList).toArray());
	}

}
