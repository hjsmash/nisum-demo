package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.ZipCodeRange;

@Service
public class RangeConsolidator {

	public List<ZipCodeRange> mergeRanges(List<ZipCodeRange> inputList) {

		if (inputList.size() == 0 || inputList.size() == 1) {
			return inputList;
		}

		Collections.sort(inputList);

		ZipCodeRange first = inputList.get(0);
		int start = first.getStart();
		int end = first.getEnd();

		ArrayList<ZipCodeRange> result = new ArrayList<ZipCodeRange>();

		for (int i = 1; i < inputList.size(); i++) {
			ZipCodeRange current = inputList.get(i);
			if (current.getStart() <= end) {
				end = Math.max(current.getEnd(), end);
			} else {
				result.add(new ZipCodeRange(start, end));
				start = current.getStart();
				end = current.getEnd();
			}
		}

		result.add(new ZipCodeRange(start, end));
		return result;
	}

}
