package com.gs.practice;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RepeatedNumberInFractionAfterDecimal {
	/**
	 * Return the fraction output in the following way Examples: If after decimal,
	 * repeating numbers are there in the output . eg. 1/3=0.333333333, this should
	 * be represented as 0.(3) 6/11=0.54545454, this should be represented as 0.(54)
	 * fractionRepresentation(1,2)=0.5 fractionRepresentation(1,3)=0.(3)
	 * fractionRepresentation(6,11)=0.(54)
	 */
	public static String fractionRepresentation(int num, int den) {
		float d = (float) num / (float) den;
		String number = String.valueOf(d);
		String result = "";
		String subString = number.substring(number.indexOf(".") + 1);
		result = number.substring(0, number.indexOf(".") + 1);

		String intermediateSubString = "";
		int i = 0;
		boolean repeated = false;
		while (i < subString.length()) {
			if (intermediateSubString.length() > 0 &&
					(i + intermediateSubString.length() < subString.length())
					&& subString.substring(i, i + intermediateSubString.length()).equals(intermediateSubString)) {
				repeated = true;
				break;

			} else {
				intermediateSubString = intermediateSubString + subString.charAt(i);
				i++;
			}
		}

		if (repeated) {
			result = result + "(" + intermediateSubString + ")";
		} else {
			result = result + subString;
		}
		// System.out.println(result);
		return result;
	}

	public static String fractionRepresentationNew(int numerator, int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("Denominator cannot be zero.");
		}

		if (numerator == 0) {
			return "0";
		}

		StringBuilder result = new StringBuilder();

		// Handle the sign (positive/negative)
		if (numerator < 0 ^ denominator < 0) {
			result.append("-");
		}

		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);

		// Calculate the integer part
		result.append(num / den);
		num %= den;

		if (num == 0) {
			return result.toString(); // No fractional part
		}

		result.append(".");

		// Create a map to store the remainder and its position
		Map<Long, Integer> remainderMap = new HashMap<>();
		int position = result.length();

		while (num != 0) {
			if (remainderMap.containsKey(num)) {
				int startIndex = remainderMap.get(num);
				String recurringPart = result.substring(startIndex, position);
				result.insert(startIndex, "(").append(")");
				return result.toString();
			}

			remainderMap.put(num, position);
			num *= 10;
			result.append(num / den);
			num %= den;
			position++;
		}

		return result.toString();
	}

	public static void main(String args[]) {
		// float f=6/11f;
		// System.out.println(f);
		System.out.println(fractionRepresentationNew(1, 2) + " " + fractionRepresentationNew(1, 3) + " "
				+ fractionRepresentation(6, 11));

		if (fractionRepresentationNew(1, 2).equals("0.5") && fractionRepresentation(6, 11).equals("0.(54)")
				&& fractionRepresentationNew(1, 3).equals("0.(3)")) {
			System.out.println("All passed");
		} else {
			System.out.println("Failed");
		}

	}
}