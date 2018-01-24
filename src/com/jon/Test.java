package com.jon;

public class Test {

	public Test() {
	}

	public static void main(String[] args) {
		
        
		String raw = "5956.6182N,1043.0844E"; // 59 concatenated with 57.2109/60
		if(raw.matches("\\d{4}\\.\\d{4}[NS],\\d{4}\\.\\d{4}[EW]")){
			String[] latlong = raw.split(",");
			String lat = latlong[0];
			String lon = latlong[1];
			boolean northern = lat.substring(lat.length() - 1, lat.length()).equals("N");
			boolean eastern = lon.substring(lon.length() - 1, lon.length()).equals("E");
			lat = lat.substring(0, lat.length() - 1); // 5957.2109
			lon = lon.substring(0, lon.length() - 1);
			String latDeg = lat.substring(0, 2); // 59
			String lonDeg = lon.substring(0, 2);
			String latMin = lat.substring(2); // 57.2109
			String lonMin = lon.substring(2);

			String googleMapCoord = (northern ? "+" : "-") + (Integer.parseInt(latDeg) + Float.parseFloat(latMin) / 60)
					+ "," + (eastern ? "+" : "-") + (Integer.parseInt(lonDeg) + Float.parseFloat(lonMin) / 60);
			System.out.println("googleMapCoord:" + googleMapCoord);
			System.out.println(Integer.parseInt(latDeg) + Float.parseFloat(latMin) / 60);
			System.out.println(Integer.parseInt(lonDeg) + Float.parseFloat(lonMin) / 60);
		}else{
			System.out.println(" Input does not match the pattern");
		}
	}
}
