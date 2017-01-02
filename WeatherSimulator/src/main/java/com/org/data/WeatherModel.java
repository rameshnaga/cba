/**
 * 
 */
package com.org.data;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import com.org.model.FeatureDetail;
import com.org.model.ItemLine;
import com.org.model.ItemUnit;
import com.org.io.ItemReader;

/**
 * @author MYPC
 *
 */
public class WeatherModel<T extends ItemLine> {
	
	Map<String, Map<Integer, Map<ItemUnit, FeatureDetail>>> itemsModel = new HashMap<>();

	private final ItemReader<T> itemReader;

	
	public WeatherModel(ItemReader<T> itemReader) throws ParseException {
		this.itemReader = itemReader;
		load();
	}

	
	public void load() {

		T line;

		// Map<String,Map<Integer,Map<ItemUnit,Integer>>> Map<Station,
		// Map<months, Map<features,value>>>
		while ((line = readNextLine()) != null) {
			Map<Integer, Map<ItemUnit, FeatureDetail>> stationMap = null;
			// Integer value range from 1-12,
			Map<ItemUnit, FeatureDetail> featureMap = null; // contain the
															// features i.e.
															// lowest
			String key = line.getStation() + "|" + line.getLatitude() + ","
					+ line.getLongitude() + "," + line.getElevation();
			if (!itemsModel.containsKey(key)) {
				itemsModel.put(key,
						new HashMap<Integer, Map<ItemUnit, FeatureDetail>>());
			}
			stationMap = itemsModel.get(key);
			// Jan
			if (!stationMap.containsKey(1)) {
				stationMap.put(1, new HashMap<ItemUnit, FeatureDetail>());
			}
			stationMap.get(1).put(
					line.getUnit(),
					new FeatureDetail(line.getDec(), line.getJan(), line
							.getFeb()));
			// Feb
			if (!stationMap.containsKey(2)) {
				stationMap.put(2, new HashMap<ItemUnit, FeatureDetail>());
			}
			stationMap.get(2).put(
					line.getUnit(),
					new FeatureDetail(line.getJan(), line.getFeb(), line
							.getMar()));
			// March
			if (!stationMap.containsKey(3)) {
				stationMap.put(3, new HashMap<ItemUnit, FeatureDetail>());
			}
			stationMap.get(3).put(
					line.getUnit(),
					new FeatureDetail(line.getFeb(), line.getMar(), line
							.getApr()));

			// Apri
			if (!stationMap.containsKey(4)) {
				stationMap.put(4, new HashMap<ItemUnit, FeatureDetail>());
			}
			stationMap.get(4).put(
					line.getUnit(),
					new FeatureDetail(line.getMar(), line.getApr(), line
							.getMay()));

			// May
			if (!stationMap.containsKey(5)) {
				stationMap.put(5, new HashMap<ItemUnit, FeatureDetail>());
			}
			stationMap.get(5).put(
					line.getUnit(),
					new FeatureDetail(line.getApr(), line.getMay(), line
							.getJun()));
			// June
			if (!stationMap.containsKey(6)) {
				stationMap.put(6, new HashMap<ItemUnit, FeatureDetail>());
			}
			stationMap.get(6).put(
					line.getUnit(),
					new FeatureDetail(line.getMay(), line.getJun(), line
							.getJul()));
			// July
			if (!stationMap.containsKey(7)) {
				stationMap.put(7, new HashMap<ItemUnit, FeatureDetail>());
			}
			stationMap.get(7).put(
					line.getUnit(),
					new FeatureDetail(line.getJun(), line.getJul(), line
							.getAug()));
			// Aug
			if (!stationMap.containsKey(8)) {
				stationMap.put(8, new HashMap<ItemUnit, FeatureDetail>());
			}
			stationMap.get(8).put(
					line.getUnit(),
					new FeatureDetail(line.getJul(), line.getAug(), line
							.getSep()));
			// Sep
			if (!stationMap.containsKey(9)) {
				stationMap.put(9, new HashMap<ItemUnit, FeatureDetail>());
			}
			stationMap.get(9).put(
					line.getUnit(),
					new FeatureDetail(line.getAug(), line.getSep(), line
							.getOct()));
			// Oct
			if (!stationMap.containsKey(10)) {
				stationMap.put(10, new HashMap<ItemUnit, FeatureDetail>());
			}
			stationMap.get(10).put(
					line.getUnit(),
					new FeatureDetail(line.getSep(), line.getOct(), line
							.getNov()));
			// Nov
			if (!stationMap.containsKey(11)) {
				stationMap.put(11, new HashMap<ItemUnit, FeatureDetail>());
			}
			stationMap.get(11).put(
					line.getUnit(),
					new FeatureDetail(line.getOct(), line.getNov(), line
							.getDec()));
			// Dec
			if (!stationMap.containsKey(12)) {
				stationMap.put(12, new HashMap<ItemUnit, FeatureDetail>());
			}
			stationMap.get(12).put(
					line.getUnit(),
					new FeatureDetail(line.getNov(), line.getDec(), line
							.getJan()));

		}
	}
	public T readNextLine() {
		try {
			return itemReader.readLine();
		} catch (IOException e) {
			throw new RuntimeException("Read line error", e);
		}
	}

	public Map<String, Map<Integer, Map<ItemUnit, FeatureDetail>>> getModel() {
		return itemsModel;
	}
}
