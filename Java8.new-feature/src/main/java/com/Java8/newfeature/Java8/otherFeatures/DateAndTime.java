package com.Java8.newfeature.Java8.otherFeatures;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.TreeSet;


public class DateAndTime {
	
	static Optional<TreeSet<String>> getTimeZones() {
		 return Optional.of(new TreeSet<>(ZoneId.getAvailableZoneIds()));
	}
	
	static void java8DateAndTime() {
		
		
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate+"\n\n");
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime+"\n\n");
		
		LocalTime localTimeOf = LocalTime.of(12,25,10,999);
		System.out.println(localTimeOf+"\n\n");
		
		LocalDate d = LocalDate.of(1992, 9, 05);
		System.out.println(d+"\n\n");
		
		LocalDate dUsingMonthEnum = LocalDate.of(1992, Month.MAY, 9);
		System.out.println(dUsingMonthEnum+"\n\n");
		
		ZoneId zoneId = ZoneId.systemDefault();
		System.err.println(zoneId+"\n\n");
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime+"\n\n");
		
		
//		getMyTimeZone(getTimeZones());
		ZoneId idHavana = ZoneId.of("America/Havana");	
		System.out.println(idHavana);
		
		System.out.println(LocalDateTime.now(idHavana)+"\n\n");
		
		System.out.println(ZonedDateTime.now(idHavana)+"\n\n");
		
		ZoneId zoneIdGMT = ZoneId.of("GMT+00:00");
		System.out.println(ZonedDateTime.now(zoneIdGMT)+"\n\n");
		
		System.out.println(Instant.now());
	}
	
	static void getMyTimeZone(Optional<TreeSet<String>> timezone) {
		if(timezone.isPresent()) {
			TreeSet<String> treeSet = timezone.get();			
			treeSet.stream().filter(zone -> zone.contains("America")).forEach(System.out::println);			
		} else {
			System.out.println("timezone is emplty.....");
		}
	}
	
	public static void main(String[] args) {
		DateAndTime.java8DateAndTime();
	}
	
}
