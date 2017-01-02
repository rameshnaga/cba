/**
 * 
 */
package com.org.model;

import java.text.SimpleDateFormat;

import com.org.model.ItemLine;
import com.org.model.ItemUnit;

/**
 * @author MYPC
 *
 */
public class Item implements ItemLine{

	private static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat(
			"dd/MM/yy");

	private String station;
	private float latitude;
	private float longitude;
	private int elevation;
	private ItemUnit unit;
	private int jan;
	private int feb;
	private int mar;
	private int apr;
	private int may;
	private int jun;
	private int jul;
	private int aug;
	private int sep;
	private int oct;
	private int nov;
	private int dec;

	public String getStation() {
		return station;
	}

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public int getElevation() {
		return elevation;
	}

	public ItemUnit getUnit() {
		return unit;
	}

	public int getJan() {
		return jan;
	}

	public int getFeb() {
		return feb;
	}

	public int getMar() {
		return mar;
	}

	public int getApr() {
		return apr;
	}

	public int getMay() {
		return may;
	}

	public int getJun() {
		return jun;
	}

	public int getJul() {
		return jul;
	}

	public int getAug() {
		return aug;
	}

	public int getSep() {
		return sep;
	}

	public int getOct() {
		return oct;
	}

	public int getNov() {
		return nov;
	}

	public int getDec() {
		return dec;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public void setElevation(int elevation) {
		this.elevation = elevation;
	}

	public void setUnit(ItemUnit unit) {
		this.unit = unit;
	}

	public void setJan(int jan) {
		this.jan = jan;
	}

	public void setFeb(int feb) {
		this.feb = feb;
	}

	public void setMar(int mar) {
		this.mar = mar;
	}

	public void setApr(int apr) {
		this.apr = apr;
	}

	public void setMay(int may) {
		this.may = may;
	}

	public void setJun(int jun) {
		this.jun = jun;
	}

	public void setJul(int jul) {
		this.jul = jul;
	}

	public void setAug(int aug) {
		this.aug = aug;
	}

	public void setSep(int sep) {
		this.sep = sep;
	}

	public void setOct(int oct) {
		this.oct = oct;
	}

	public void setNov(int nov) {
		this.nov = nov;
	}

	public void setDec(int dec) {
		this.dec = dec;
	}


	@Override
	public String toString() {
		return "Item [station=" + station + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", elevation=" + elevation
				+ ", unit=" + unit + ", jan=" + jan + ", feb=" + feb + ", mar="
				+ mar + ", apr=" + apr + ", may=" + may + ", jun=" + jun
				+ ", jul=" + jul + ", aug=" + aug + ", sep=" + sep + ", oct="
				+ oct + ", nov=" + nov + ", dec=" + dec + "]";
	}

//	@Override
//	public long satisfy(ItemLine item) throws ParseException {
//		Date useByDate = SHORT_DATE_FORMAT.parse(SHORT_DATE_FORMAT.format(item
//				.getDate()));
//		if (item.getAmount() < getAmount())
//			return -1;
//		if (item.getUnit() != this.unit)
//			return -1;
//		return useByDate.getTime()
//				- (SHORT_DATE_FORMAT
//						.parse(SHORT_DATE_FORMAT.format(new Date()))).getTime();
//	}


}
