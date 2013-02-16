/**
 *  This contains the various methods to work with color names
 */
package com.mohanaravind.colorpicker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravind_Mohan
 * 
 */
public class ColorNameProvider {

	/**
	 * Private fields
	 */
	private static Map<String, String> _hmR = null;
	private static Map<String, String> _hmG = null;
	private static Map<String, String> _hmB = null;
	private static Map<String, String> _hmRGB = null;

	/**
	 * Static constructor
	 */
	static {
		_hmR = new HashMap<String, String>();
		_hmG = new HashMap<String, String>();
		_hmB = new HashMap<String, String>();
		_hmRGB = new HashMap<String, String>();

		// Set the maps
		setRMap();
		setGMap();
		setBMap();

		setRGBMap();
	}

	/**
	 * Set the Red map
	 */
	private static void setRMap() {
		_hmR.put("ForestGreen", "34");
		_hmR.put("Green", "0");
		_hmR.put("DarkGreen", "0");
		_hmR.put("SeaGreen", "46");
		_hmR.put("Olive", "128");
		_hmR.put("OliveDrab", "107");
		_hmR.put("DarkOliveGreen", "85");
		_hmR.put("LimeGreen", "50");
		_hmR.put("DarkSlateGray", "47");
		_hmR.put("Lime", "0");
		_hmR.put("Teal", "0");
		_hmR.put("DarkGoldenrod", "184");
		_hmR.put("DarkCyan", "0");
		_hmR.put("Black", "0");
		_hmR.put("MediumSeaGreen", "60");
		_hmR.put("SaddleBrown", "139");
		_hmR.put("DimGray", "105");
		_hmR.put("LightSeaGreen", "32");
		_hmR.put("SteelBlue", "70");
		_hmR.put("LawnGreen", "124");
		_hmR.put("MidnightBlue", "25");
		_hmR.put("Sienna", "160");
		_hmR.put("Chartreuse", "127");
		_hmR.put("Gray", "128");
		_hmR.put("SlateGray", "112");
		_hmR.put("Peru", "205");
		_hmR.put("Chocolate", "210");
		_hmR.put("DarkOrange", "255");
		_hmR.put("LightSlateGray", "119");
		_hmR.put("Maroon", "128");
		_hmR.put("YellowGreen", "154");
		_hmR.put("CadetBlue", "95");
		_hmR.put("Goldenrod", "218");
		_hmR.put("DarkSlateBlue", "72");
		_hmR.put("DarkRed", "139");
		_hmR.put("DodgerBlue", "30");
		_hmR.put("Orange", "255");
		_hmR.put("Brown", "165");
		_hmR.put("SpringGreen", "0");
		_hmR.put("FireBrick", "178");
		_hmR.put("RoyalBlue", "65");
		_hmR.put("Navy", "0");
		_hmR.put("MediumSpringGreen", "0");
		_hmR.put("OrangeRed", "255");
		_hmR.put("DarkBlue", "0");
		_hmR.put("Indigo", "75");
		_hmR.put("IndianRed", "205");
		_hmR.put("DarkSeaGreen", "143");
		_hmR.put("RosyBrown", "188");
		_hmR.put("DarkTurquoise", "0");
		_hmR.put("GreenYellow", "173");
		_hmR.put("Coral", "255");
		_hmR.put("MediumAquamarine", "102");
		_hmR.put("DarkKhaki", "189");
		_hmR.put("Gold", "255");
		_hmR.put("MediumTurquoise", "72");
		_hmR.put("CornflowerBlue", "100");
		_hmR.put("SlateBlue", "106");
		_hmR.put("Tomato", "255");
		_hmR.put("Turquoise", "64");
		_hmR.put("Salmon", "250");
		_hmR.put("SandyBrown", "244");
		_hmR.put("DarkSalmon", "233");
		_hmR.put("DeepSkyBlue", "0");
		_hmR.put("DarkGray", "169");
		_hmR.put("LightCoral", "240");
		_hmR.put("MediumPurple", "147");
		_hmR.put("PaleVioletRed", "219");
		_hmR.put("Yellow", "255");
		_hmR.put("Purple", "128");
		_hmR.put("MediumSlateBlue", "123");
		_hmR.put("LightGreen", "144");
		_hmR.put("Crimson", "220");
		_hmR.put("Tan", "210");
		_hmR.put("MediumBlue", "0");
		_hmR.put("Red", "255");
		_hmR.put("LightSalmon", "255");
		_hmR.put("LightSalmon", "255");
		_hmR.put("BurlyWood", "222");
		_hmR.put("DarkMagenta", "139");
		_hmR.put("PaleGreen", "152");
		_hmR.put("Aqua", "0");
		_hmR.put("Cyan", "0");
		_hmR.put("DarkOrchid", "153");
		_hmR.put("SkyBlue", "135");
		_hmR.put("Silver", "192");
		_hmR.put("MediumVioletRed", "199");
		_hmR.put("MediumOrchid", "186");
		_hmR.put("Blue", "0");
		_hmR.put("Orchid", "218");
		_hmR.put("BlueViolet", "138");
		_hmR.put("LightSkyBlue", "135");
		_hmR.put("Aquamarine", "127");
		_hmR.put("LightSteelBlue", "176");
		_hmR.put("HotPink", "255");
		_hmR.put("Plum", "221");
		_hmR.put("Khaki", "240");
		_hmR.put("Violet", "238");
		_hmR.put("LightBlue", "173");
		_hmR.put("Thistle", "216");
		_hmR.put("DarkViolet", "148");
		_hmR.put("PowderBlue", "176");
		_hmR.put("LightPink", "255");
		_hmR.put("LightGrey", "211");
		_hmR.put("PaleGoldenrod", "238");
		_hmR.put("Wheat", "245");
		_hmR.put("DeepPink", "255");
		_hmR.put("NavajoWhite", "255");
		_hmR.put("Pink", "255");
		_hmR.put("PaleTurquoise", "175");
		_hmR.put("PeachPuff", "255");
		_hmR.put("Gainsboro", "220");
		_hmR.put("Moccasin", "255");
		_hmR.put("Bisque", "255");
		_hmR.put("BlanchedAlmond", "255");
		_hmR.put("AntiqueWhite", "250");
		_hmR.put("PapayaWhip", "255");
		_hmR.put("MistyRose", "255");
		_hmR.put("LemonChiffon", "255");
		_hmR.put("LightGoldenrodYellow", "250");
		_hmR.put("Lavender", "230");
		_hmR.put("Beige", "245");
		_hmR.put("Linen", "250");
		_hmR.put("Cornsilk", "255");
		_hmR.put("OldLace", "253");
		_hmR.put("LightYellow", "255");
		_hmR.put("LightCyan", "224");
		_hmR.put("Honeydew", "240");
		_hmR.put("WhiteSmoke", "245");
		_hmR.put("Seashell", "255");
		_hmR.put("LavenderBlush", "255");
		_hmR.put("AliceBlue", "240");
		_hmR.put("FloralWhite", "255");
		_hmR.put("MintCream", "245");
		_hmR.put("Azure", "240");
		_hmR.put("Ivory", "255");
		_hmR.put("GhostWhite", "248");
		_hmR.put("Snow", "255");
		_hmR.put("White", "255");
		_hmR.put("Fuchsia", "255");
		_hmR.put("Magenta", "255");

	}

	/**
	 * Set the Green map
	 */
	private static void setGMap() {
		_hmG.put("ForestGreen", "139");
		_hmG.put("Green", "128");
		_hmG.put("DarkGreen", "100");
		_hmG.put("SeaGreen", "139");
		_hmG.put("Olive", "128");
		_hmG.put("OliveDrab", "142");
		_hmG.put("DarkOliveGreen", "107");
		_hmG.put("LimeGreen", "205");
		_hmG.put("DarkSlateGray", "79");
		_hmG.put("Lime", "255");
		_hmG.put("Teal", "128");
		_hmG.put("DarkGoldenrod", "134");
		_hmG.put("DarkCyan", "139");
		_hmG.put("Black", "0");
		_hmG.put("MediumSeaGreen", "179");
		_hmG.put("SaddleBrown", "69");
		_hmG.put("DimGray", "105");
		_hmG.put("LightSeaGreen", "178");
		_hmG.put("SteelBlue", "130");
		_hmG.put("LawnGreen", "252");
		_hmG.put("MidnightBlue", "25");
		_hmG.put("Sienna", "82");
		_hmG.put("Chartreuse", "255");
		_hmG.put("Gray", "128");
		_hmG.put("SlateGray", "128");
		_hmG.put("Peru", "133");
		_hmG.put("Chocolate", "105");
		_hmG.put("DarkOrange", "140");
		_hmG.put("LightSlateGray", "136");
		_hmG.put("Maroon", "0");
		_hmG.put("YellowGreen", "205");
		_hmG.put("CadetBlue", "158");
		_hmG.put("Goldenrod", "165");
		_hmG.put("DarkSlateBlue", "61");
		_hmG.put("DarkRed", "0");
		_hmG.put("DodgerBlue", "144");
		_hmG.put("Orange", "165");
		_hmG.put("Brown", "42");
		_hmG.put("SpringGreen", "255");
		_hmG.put("FireBrick", "34");
		_hmG.put("RoyalBlue", "105");
		_hmG.put("Navy", "0");
		_hmG.put("MediumSpringGreen", "250");
		_hmG.put("OrangeRed", "69");
		_hmG.put("DarkBlue", "0");
		_hmG.put("Indigo", "0");
		_hmG.put("IndianRed", "92");
		_hmG.put("DarkSeaGreen", "188");
		_hmG.put("RosyBrown", "143");
		_hmG.put("DarkTurquoise", "206");
		_hmG.put("GreenYellow", "255");
		_hmG.put("Coral", "127");
		_hmG.put("MediumAquamarine", "205");
		_hmG.put("DarkKhaki", "183");
		_hmG.put("Gold", "215");
		_hmG.put("MediumTurquoise", "209");
		_hmG.put("CornflowerBlue", "149");
		_hmG.put("SlateBlue", "90");
		_hmG.put("Tomato", "99");
		_hmG.put("Turquoise", "224");
		_hmG.put("Salmon", "128");
		_hmG.put("SandyBrown", "164");
		_hmG.put("DarkSalmon", "150");
		_hmG.put("DeepSkyBlue", "191");
		_hmG.put("DarkGray", "169");
		_hmG.put("LightCoral", "128");
		_hmG.put("MediumPurple", "112");
		_hmG.put("PaleVioletRed", "112");
		_hmG.put("Yellow", "255");
		_hmG.put("Purple", "0");
		_hmG.put("MediumSlateBlue", "104");
		_hmG.put("LightGreen", "238");
		_hmG.put("Crimson", "20");
		_hmG.put("Tan", "180");
		_hmG.put("MediumBlue", "0");
		_hmG.put("Red", "0");
		_hmG.put("LightSalmon", "160");
		_hmG.put("LightSalmon", "160");
		_hmG.put("BurlyWood", "184");
		_hmG.put("DarkMagenta", "0");
		_hmG.put("PaleGreen", "251");
		_hmG.put("Aqua", "255");
		_hmG.put("Cyan", "255");
		_hmG.put("DarkOrchid", "50");
		_hmG.put("SkyBlue", "206");
		_hmG.put("Silver", "192");
		_hmG.put("MediumVioletRed", "21");
		_hmG.put("MediumOrchid", "85");
		_hmG.put("Blue", "0");
		_hmG.put("Orchid", "112");
		_hmG.put("BlueViolet", "43");
		_hmG.put("LightSkyBlue", "206");
		_hmG.put("Aquamarine", "255");
		_hmG.put("LightSteelBlue", "196");
		_hmG.put("HotPink", "105");
		_hmG.put("Plum", "160");
		_hmG.put("Khaki", "230");
		_hmG.put("Violet", "130");
		_hmG.put("LightBlue", "216");
		_hmG.put("Thistle", "191");
		_hmG.put("DarkViolet", "0");
		_hmG.put("PowderBlue", "224");
		_hmG.put("LightPink", "182");
		_hmG.put("LightGrey", "211");
		_hmG.put("PaleGoldenrod", "232");
		_hmG.put("Wheat", "222");
		_hmG.put("DeepPink", "20");
		_hmG.put("NavajoWhite", "222");
		_hmG.put("Pink", "192");
		_hmG.put("PaleTurquoise", "238");
		_hmG.put("PeachPuff", "218");
		_hmG.put("Gainsboro", "220");
		_hmG.put("Moccasin", "228");
		_hmG.put("Bisque", "228");
		_hmG.put("BlanchedAlmond", "235");
		_hmG.put("AntiqueWhite", "235");
		_hmG.put("PapayaWhip", "239");
		_hmG.put("MistyRose", "228");
		_hmG.put("LemonChiffon", "250");
		_hmG.put("LightGoldenrodYellow", "250");
		_hmG.put("Lavender", "230");
		_hmG.put("Beige", "245");
		_hmG.put("Linen", "240");
		_hmG.put("Cornsilk", "248");
		_hmG.put("OldLace", "245");
		_hmG.put("LightYellow", "255");
		_hmG.put("LightCyan", "255");
		_hmG.put("Honeydew", "255");
		_hmG.put("WhiteSmoke", "245");
		_hmG.put("Seashell", "245");
		_hmG.put("LavenderBlush", "240");
		_hmG.put("AliceBlue", "248");
		_hmG.put("FloralWhite", "250");
		_hmG.put("MintCream", "255");
		_hmG.put("Azure", "255");
		_hmG.put("Ivory", "255");
		_hmG.put("GhostWhite", "248");
		_hmG.put("Snow", "250");
		_hmG.put("White", "255");
		_hmG.put("Fuchsia", "0");
		_hmG.put("Magenta", "0");
	}

	/**
	 * Set the Blue map
	 */
	private static void setBMap() {
		_hmB.put("ForestGreen", "34");
		_hmB.put("Green", "0");
		_hmB.put("DarkGreen", "0");
		_hmB.put("SeaGreen", "87");
		_hmB.put("Olive", "0");
		_hmB.put("OliveDrab", "35");
		_hmB.put("DarkOliveGreen", "47");
		_hmB.put("LimeGreen", "50");
		_hmB.put("DarkSlateGray", "79");
		_hmB.put("Lime", "0");
		_hmB.put("Teal", "128");
		_hmB.put("DarkGoldenrod", "11");
		_hmB.put("DarkCyan", "139");
		_hmB.put("Black", "0");
		_hmB.put("MediumSeaGreen", "113");
		_hmB.put("SaddleBrown", "19");
		_hmB.put("DimGray", "105");
		_hmB.put("LightSeaGreen", "170");
		_hmB.put("SteelBlue", "180");
		_hmB.put("LawnGreen", "0");
		_hmB.put("MidnightBlue", "112");
		_hmB.put("Sienna", "45");
		_hmB.put("Chartreuse", "0");
		_hmB.put("Gray", "128");
		_hmB.put("SlateGray", "144");
		_hmB.put("Peru", "63");
		_hmB.put("Chocolate", "30");
		_hmB.put("DarkOrange", "0");
		_hmB.put("LightSlateGray", "153");
		_hmB.put("Maroon", "0");
		_hmB.put("YellowGreen", "50");
		_hmB.put("CadetBlue", "160");
		_hmB.put("Goldenrod", "32");
		_hmB.put("DarkSlateBlue", "139");
		_hmB.put("DarkRed", "0");
		_hmB.put("DodgerBlue", "255");
		_hmB.put("Orange", "0");
		_hmB.put("Brown", "42");
		_hmB.put("SpringGreen", "127");
		_hmB.put("FireBrick", "34");
		_hmB.put("RoyalBlue", "225");
		_hmB.put("Navy", "128");
		_hmB.put("MediumSpringGreen", "154");
		_hmB.put("OrangeRed", "0");
		_hmB.put("DarkBlue", "139");
		_hmB.put("Indigo", "130");
		_hmB.put("IndianRed", "92");
		_hmB.put("DarkSeaGreen", "143");
		_hmB.put("RosyBrown", "143");
		_hmB.put("DarkTurquoise", "209");
		_hmB.put("GreenYellow", "47");
		_hmB.put("Coral", "80");
		_hmB.put("MediumAquamarine", "170");
		_hmB.put("DarkKhaki", "107");
		_hmB.put("Gold", "0");
		_hmB.put("MediumTurquoise", "204");
		_hmB.put("CornflowerBlue", "237");
		_hmB.put("SlateBlue", "205");
		_hmB.put("Tomato", "71");
		_hmB.put("Turquoise", "208");
		_hmB.put("Salmon", "114");
		_hmB.put("SandyBrown", "96");
		_hmB.put("DarkSalmon", "122");
		_hmB.put("DeepSkyBlue", "255");
		_hmB.put("DarkGray", "169");
		_hmB.put("LightCoral", "128");
		_hmB.put("MediumPurple", "219");
		_hmB.put("PaleVioletRed", "147");
		_hmB.put("Yellow", "0");
		_hmB.put("Purple", "128");
		_hmB.put("MediumSlateBlue", "238");
		_hmB.put("LightGreen", "144");
		_hmB.put("Crimson", "60");
		_hmB.put("Tan", "140");
		_hmB.put("MediumBlue", "205");
		_hmB.put("Red", "0");
		_hmB.put("LightSalmon", "122");
		_hmB.put("LightSalmon", "122");
		_hmB.put("BurlyWood", "135");
		_hmB.put("DarkMagenta", "139");
		_hmB.put("PaleGreen", "152");
		_hmB.put("Aqua", "255");
		_hmB.put("Cyan", "255");
		_hmB.put("DarkOrchid", "204");
		_hmB.put("SkyBlue", "235");
		_hmB.put("Silver", "192");
		_hmB.put("MediumVioletRed", "133");
		_hmB.put("MediumOrchid", "211");
		_hmB.put("Blue", "255");
		_hmB.put("Orchid", "214");
		_hmB.put("BlueViolet", "226");
		_hmB.put("LightSkyBlue", "250");
		_hmB.put("Aquamarine", "212");
		_hmB.put("LightSteelBlue", "222");
		_hmB.put("HotPink", "180");
		_hmB.put("Plum", "221");
		_hmB.put("Khaki", "140");
		_hmB.put("Violet", "238");
		_hmB.put("LightBlue", "230");
		_hmB.put("Thistle", "216");
		_hmB.put("DarkViolet", "211");
		_hmB.put("PowderBlue", "230");
		_hmB.put("LightPink", "193");
		_hmB.put("LightGrey", "211");
		_hmB.put("PaleGoldenrod", "170");
		_hmB.put("Wheat", "179");
		_hmB.put("DeepPink", "147");
		_hmB.put("NavajoWhite", "173");
		_hmB.put("Pink", "203");
		_hmB.put("PaleTurquoise", "238");
		_hmB.put("PeachPuff", "185");
		_hmB.put("Gainsboro", "220");
		_hmB.put("Moccasin", "181");
		_hmB.put("Bisque", "196");
		_hmB.put("BlanchedAlmond", "205");
		_hmB.put("AntiqueWhite", "215");
		_hmB.put("PapayaWhip", "213");
		_hmB.put("MistyRose", "225");
		_hmB.put("LemonChiffon", "205");
		_hmB.put("LightGoldenrodYellow", "210");
		_hmB.put("Lavender", "250");
		_hmB.put("Beige", "220");
		_hmB.put("Linen", "230");
		_hmB.put("Cornsilk", "220");
		_hmB.put("OldLace", "230");
		_hmB.put("LightYellow", "224");
		_hmB.put("LightCyan", "255");
		_hmB.put("Honeydew", "240");
		_hmB.put("WhiteSmoke", "245");
		_hmB.put("Seashell", "238");
		_hmB.put("LavenderBlush", "245");
		_hmB.put("AliceBlue", "255");
		_hmB.put("FloralWhite", "240");
		_hmB.put("MintCream", "250");
		_hmB.put("Azure", "255");
		_hmB.put("Ivory", "240");
		_hmB.put("GhostWhite", "255");
		_hmB.put("Snow", "250");
		_hmB.put("White", "255");
		_hmB.put("Fuchsia", "255");
		_hmB.put("Magenta", "255");
	}

	/**
	 * Sets the direct RGB map
	 */
	private static void setRGBMap() {
		_hmRGB.put("3413934","ForestGreen");
		_hmRGB.put("01280","Green");
		_hmRGB.put("01000","DarkGreen");
		_hmRGB.put("4613987","SeaGreen");
		_hmRGB.put("1281280","Olive");
		_hmRGB.put("10714235","OliveDrab");
		_hmRGB.put("8510747","DarkOliveGreen");
		_hmRGB.put("5020550","LimeGreen");
		_hmRGB.put("477979","DarkSlateGray");
		_hmRGB.put("02550","Lime");
		_hmRGB.put("0128128","Teal");
		_hmRGB.put("18413411","DarkGoldenrod");
		_hmRGB.put("0139139","DarkCyan");
		_hmRGB.put("000","Black");
		_hmRGB.put("60179113","MediumSeaGreen");
		_hmRGB.put("1396919","SaddleBrown");
		_hmRGB.put("105105105","DimGray");
		_hmRGB.put("32178170","LightSeaGreen");
		_hmRGB.put("70130180","SteelBlue");
		_hmRGB.put("1242520","LawnGreen");
		_hmRGB.put("2525112","MidnightBlue");
		_hmRGB.put("1608245","Sienna");
		_hmRGB.put("1272550","Chartreuse");
		_hmRGB.put("128128128","Gray");
		_hmRGB.put("112128144","SlateGray");
		_hmRGB.put("20513363","Peru");
		_hmRGB.put("21010530","Chocolate");
		_hmRGB.put("2551400","DarkOrange");
		_hmRGB.put("119136153","LightSlateGray");
		_hmRGB.put("12800","Maroon");
		_hmRGB.put("15420550","YellowGreen");
		_hmRGB.put("95158160","CadetBlue");
		_hmRGB.put("21816532","Goldenrod");
		_hmRGB.put("7261139","DarkSlateBlue");
		_hmRGB.put("13900","DarkRed");
		_hmRGB.put("30144255","DodgerBlue");
		_hmRGB.put("2551650","Orange");
		_hmRGB.put("1654242","Brown");
		_hmRGB.put("0255127","SpringGreen");
		_hmRGB.put("1783434","FireBrick");
		_hmRGB.put("65105225","RoyalBlue");
		_hmRGB.put("00128","Navy");
		_hmRGB.put("0250154","MediumSpringGreen");
		_hmRGB.put("255690","OrangeRed");
		_hmRGB.put("00139","DarkBlue");
		_hmRGB.put("750130","Indigo");
		_hmRGB.put("2059292","IndianRed");
		_hmRGB.put("143188143","DarkSeaGreen");
		_hmRGB.put("188143143","RosyBrown");
		_hmRGB.put("0206209","DarkTurquoise");
		_hmRGB.put("17325547","GreenYellow");
		_hmRGB.put("25512780","Coral");
		_hmRGB.put("102205170","MediumAquamarine");
		_hmRGB.put("189183107","DarkKhaki");
		_hmRGB.put("2552150","Gold");
		_hmRGB.put("72209204","MediumTurquoise");
		_hmRGB.put("100149237","CornflowerBlue");
		_hmRGB.put("10690205","SlateBlue");
		_hmRGB.put("2559971","Tomato");
		_hmRGB.put("64224208","Turquoise");
		_hmRGB.put("250128114","Salmon");
		_hmRGB.put("24416496","SandyBrown");
		_hmRGB.put("233150122","DarkSalmon");
		_hmRGB.put("0191255","DeepSkyBlue");
		_hmRGB.put("169169169","DarkGray");
		_hmRGB.put("240128128","LightCoral");
		_hmRGB.put("147112219","MediumPurple");
		_hmRGB.put("219112147","PaleVioletRed");
		_hmRGB.put("2552550","Yellow");
		_hmRGB.put("1280128","Purple");
		_hmRGB.put("123104238","MediumSlateBlue");
		_hmRGB.put("144238144","LightGreen");
		_hmRGB.put("2202060","Crimson");
		_hmRGB.put("210180140","Tan");
		_hmRGB.put("00205","MediumBlue");
		_hmRGB.put("25500","Red");
		_hmRGB.put("255160122","LightSalmon");
		_hmRGB.put("255160122","LightSalmon");
		_hmRGB.put("222184135","BurlyWood");
		_hmRGB.put("1390139","DarkMagenta");
		_hmRGB.put("152251152","PaleGreen");
		_hmRGB.put("0255255","Aqua");
		_hmRGB.put("0255255","Cyan");
		_hmRGB.put("15350204","DarkOrchid");
		_hmRGB.put("135206235","SkyBlue");
		_hmRGB.put("192192192","Silver");
		_hmRGB.put("19921133","MediumVioletRed");
		_hmRGB.put("18685211","MediumOrchid");
		_hmRGB.put("00255","Blue");
		_hmRGB.put("218112214","Orchid");
		_hmRGB.put("13843226","BlueViolet");
		_hmRGB.put("135206250","LightSkyBlue");
		_hmRGB.put("127255212","Aquamarine");
		_hmRGB.put("176196222","LightSteelBlue");
		_hmRGB.put("255105180","HotPink");
		_hmRGB.put("221160221","Plum");
		_hmRGB.put("240230140","Khaki");
		_hmRGB.put("238130238","Violet");
		_hmRGB.put("173216230","LightBlue");
		_hmRGB.put("216191216","Thistle");
		_hmRGB.put("1480211","DarkViolet");
		_hmRGB.put("176224230","PowderBlue");
		_hmRGB.put("255182193","LightPink");
		_hmRGB.put("211211211","LightGrey");
		_hmRGB.put("238232170","PaleGoldenrod");
		_hmRGB.put("245222179","Wheat");
		_hmRGB.put("25520147","DeepPink");
		_hmRGB.put("255222173","NavajoWhite");
		_hmRGB.put("255192203","Pink");
		_hmRGB.put("175238238","PaleTurquoise");
		_hmRGB.put("255218185","PeachPuff");
		_hmRGB.put("220220220","Gainsboro");
		_hmRGB.put("255228181","Moccasin");
		_hmRGB.put("255228196","Bisque");
		_hmRGB.put("255235205","BlanchedAlmond");
		_hmRGB.put("250235215","AntiqueWhite");
		_hmRGB.put("255239213","PapayaWhip");
		_hmRGB.put("255228225","MistyRose");
		_hmRGB.put("255250205","LemonChiffon");
		_hmRGB.put("250250210","LightGoldenrodYellow");
		_hmRGB.put("230230250","Lavender");
		_hmRGB.put("245245220","Beige");
		_hmRGB.put("250240230","Linen");
		_hmRGB.put("255248220","Cornsilk");
		_hmRGB.put("253245230","OldLace");
		_hmRGB.put("255255224","LightYellow");
		_hmRGB.put("224255255","LightCyan");
		_hmRGB.put("240255240","Honeydew");
		_hmRGB.put("245245245","WhiteSmoke");
		_hmRGB.put("255245238","Seashell");
		_hmRGB.put("255240245","LavenderBlush");
		_hmRGB.put("240248255","AliceBlue");
		_hmRGB.put("255250240","FloralWhite");
		_hmRGB.put("245255250","MintCream");
		_hmRGB.put("240255255","Azure");
		_hmRGB.put("255255240","Ivory");
		_hmRGB.put("248248255","GhostWhite");
		_hmRGB.put("255250250","Snow");
		_hmRGB.put("255255255","White");
		_hmRGB.put("2550255","Fuchsia");
		_hmRGB.put("2550255","Magenta");
	}

	/**
	 * Gets the hex string for the given red blue green color code
	 * 
	 * @param intRed
	 *            Red color code ( 0 to 255 )
	 * @param intGreen
	 *            Green color code ( 0 to 255 )
	 * @param intBlue
	 *            Blue color code ( 0 to 255 )
	 * @return The hexadecimal string constituting the red, blue, green color
	 *         code
	 */
	public static String getHexStringFromRGB(int intRed, int intGreen,
			int intBlue) {
		// Declarations
		String strRed = "";
		String strGreen = "";
		String strBlue = "";

		// Get the red hex string from the color code
		strRed = Integer.toHexString(intRed);
		// Check for full formation
		if (strRed.length() < 2)
			strRed = "0" + strRed;

		// Get the green hex string from the color code
		strGreen = Integer.toHexString(intGreen);
		// Check for full formation
		if (strGreen.length() < 2)
			strGreen = "0" + strGreen;

		// Get the blue hex string from the color code
		strBlue = Integer.toHexString(intBlue);
		// Check for full formation
		if (strBlue.length() < 2)
			strBlue = "0" + strBlue;

		// Return the hex string code
		return strRed + strGreen + strBlue;
	}

	/**
	 * Gets the nearest matching color name
	 * 
	 * @param intRed
	 * @param intGreen
	 * @param intBlue
	 * @return String which represents the nearest matching color name
	 */
	public static String getColorName(int intRed, int intGreen, int intBlue) {
		// Declarations
		String strColorName = "";
		Map<String, String> hmColors = new HashMap<String, String>();
		int arrValues[] = new int[_hmR.size()];
		int intIndex = 0;
		int intR = 0;
		int intG = 0;
		int intB = 0;
		int intDeviation = 0;
		String strRGBCode = String.valueOf(intRed) + String.valueOf(intGreen)
				+ String.valueOf(intBlue);

		// Check whether there is a direct match
		if (_hmRGB.containsKey(strRGBCode.trim())) {
			strColorName = _hmRGB.get(strRGBCode.trim());
		} else {
			// Build the map
			for (String strColorCode : _hmR.keySet()) {
				intR = Integer.valueOf(_hmR.get(strColorCode));
				intG = Integer.valueOf(_hmG.get(strColorCode));
				intB = Integer.valueOf(_hmB.get(strColorCode));

				// Get the deviation
				intDeviation = Math.abs(intR - intRed)
						+ Math.abs(intG - intGreen) + Math.abs(intB - intBlue);

				// Add it to the array
				arrValues[intIndex] = intDeviation;

				// Map it
				hmColors.put(String.valueOf(intDeviation), strColorCode);

				intIndex++;
			}

			// Sort and find the color which has least deviation
			Arrays.sort(arrValues);

			// Get the least deviation
			intDeviation = arrValues[0];

			// Get the color name
			strColorName = hmColors.get(String.valueOf(intDeviation));
		}

		return strColorName;
	}
	

}
