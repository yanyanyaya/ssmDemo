package com.mvcdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	// 早上时段
	private static final String morningSourceTime = "00:00-12:30";
	// 下午时段
	private static final String afternoonSourceTime = "12:00-19:30";
	// 晚上时段
	private static final String nightSourceTime = "19:00-24:00";
	
	public static String getMorningsourcetime() {
		return morningSourceTime;
	}
	public static String getAfternoonsourcetime() {
		return afternoonSourceTime;
	}
	public static String getNightsourcetime() {
		return nightSourceTime;
	}

	//判定早上时间�?
	public static boolean isMorning(Date curTime) {
		return isInTime(curTime,morningSourceTime);
	}
	//判定下午时间�?
	public static boolean isAfternoon(Date curTime) {
		return isInTime(curTime,afternoonSourceTime);
	}
	//判定晚上时间�?
	public static boolean isNight(Date curTime) {
		return isInTime(curTime,nightSourceTime);
	}

	/**
	 * 判定某时间是否在某个时间段内
	 * @param date
	 * @param SourceTime
	 * @return
	 */
	public static boolean isInTime(Date date, String SourceTime) {
		// 截取�?始，结束时间，精确到分钟
		String[] args = SourceTime.split("-");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String nowTime = dateToString(date).substring(11,16);
		try {
			long now = sdf.parse(nowTime).getTime();
			if (args[1].equals("00:00")) {
				args[1] = "24:00";
			}
			long start = sdf.parse(args[0]).getTime();
			long end = sdf.parse(args[1]).getTime();
	
			if (now >= start && now < end) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Date型转 yyyy-MM-dd HH:mm:ss字符�?
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strDate = sdf.format(date);
			return strDate;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new IllegalArgumentException("");
		}

	}

	/**
	 * 字符串转date类型
	 * 
	 * @param timeStr
	 * @return
	 */
	public static Date stringToDate(String timeStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(timeStr);
			return date;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new IllegalArgumentException("dateString like:'yyyy-MM-dd HH:mm:ss'");
		}
	}
	
	public static String getStartTime(String datePeriod){
		return datePeriod.split(" - ")[0];
	}
	public static String getEndTime(String datePeriod){
		return datePeriod.split(" - ")[1];
	}

}
