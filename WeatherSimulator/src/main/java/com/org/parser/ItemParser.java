/**
 * 
 */
package com.org.parser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.org.model.Item;
import com.org.model.ItemUnit;
import com.org.parser.ItemParser;
import com.org.parser.LineParser;

/**
 * @author MYPC
 *
 */
public class ItemParser implements LineParser<Item> {
	private final static Logger LOGGER = Logger.getLogger(ItemParser.class
			.getName());
	public static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat(
			"dd/MM/yy");
	static Date todayDate = null;

	public ItemParser() throws Exception {
		todayDate = SHORT_DATE_FORMAT.parse(SHORT_DATE_FORMAT
				.format(new Date()));
	}

	public Item parseLine(String line) {
		final List<String> parts = split(line);
		final int numberOfTokens = parts.size();
		if (numberOfTokens < 17) {
			return null;
		}
		final Item result = new Item();
		final String station = parts.get(0);
		try {
			final float latitude = Float.valueOf(parts.get(1));
			final ItemUnit unit = ItemUnit.getUnit(parts.get(4));
			if (unit == null)
				return null;

			result.setStation(station.toUpperCase());
			result.setLatitude(latitude);
			result.setLongitude(Float.valueOf(parts.get(2)));
			result.setElevation(Integer.valueOf(parts.get(3)));
			result.setUnit(unit);
			result.setJan((int) (Float.valueOf(parts.get(5)) * 100));
			result.setFeb((int) (Float.valueOf(parts.get(6)) * 100));
			result.setMar((int) (Float.valueOf(parts.get(7)) * 100));
			result.setApr((int) (Float.valueOf(parts.get(8)) * 100));
			result.setMay((int) (Float.valueOf(parts.get(9)) * 100));
			result.setJun((int) (Float.valueOf(parts.get(10)) * 100));
			result.setJul((int) (Float.valueOf(parts.get(11)) * 100));
			result.setAug((int) (Float.valueOf(parts.get(12)) * 100));
			result.setSep((int) (Float.valueOf(parts.get(13)) * 100));
			result.setOct((int) (Float.valueOf(parts.get(14)) * 100));
			result.setNov((int) (Float.valueOf(parts.get(15)) * 100));
			result.setDec((int) (Float.valueOf(parts.get(16)) * 100));
		} catch (Exception e) {
			LOGGER.severe("One Item in csv file format is not valid. The name of this Item is "
					+ station + ":" + parts.get(2) + "/n " + e.getMessage());
			return null;
		}
		return result;
	}

	/**
	 * 
	 * @param line
	 *            is split by array
	 * @return
	 */
	private List<String> split(final String line) {
		final ArrayList<String> result = new ArrayList<String>(10);
		final ArrayList<Integer> indexes = new ArrayList<Integer>(10);

		final int strLen = line.length();
		int index = -1;
		indexes.add(0);
		for (int i = 0; i < strLen; i++) {
			index = line.indexOf(',', Math.min(index + 1, strLen));
			if (-1 == index) {
				break;
			}
			indexes.add(index + 1);
		}
		index = 0;
		int max = indexes.size() - 1;
		for (; index < max; index++) {
			result.add(line.substring(indexes.get(index),
					indexes.get(index + 1) - 1));
		}
		result.add(line.substring(indexes.get(index), line.length()));

		return Collections.unmodifiableList(result);
	}

}
