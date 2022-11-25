package dev.ifrs;

import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Utils {
    static NumberFormat numberFormat = 
        //new DecimalFormat(s: "R$ #, ##0.00", new DecimalFormatSymbols(new locale(s: "pt", s1: "BR")));
        new DecimalFormat("R$ #, ##0.00", new DecimalFormatSymbols(new locale("pt", "BR")));
    
    public static String doubleToString(Double value) {
        return numberFormat.format(value);
    }
}
