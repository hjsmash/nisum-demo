package com.example.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ZipCodeRange implements Comparable<ZipCodeRange> {

	private int start;
	private int end;

	public ZipCodeRange(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(ZipCodeRange o) {

		return start - o.getStart();
	}

	@Override
	public String toString() {
		return "[ " + start + ", " + end + " ]";
	}

}
