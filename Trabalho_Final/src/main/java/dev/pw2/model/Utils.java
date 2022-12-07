/**
 * PW2 by Rodrigo Prestes Machado
 *
 * PW2 is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 *
*/
package dev.pw2.model;

import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@Entity
public class Utils extends PanacheEntity {

    static NumberFormat numberFormat = 
    //new DecimalFormat(s: "R$ #, ##0.00", new DecimalFormatSymbols(new locale(s: "pt", s1: "BR")));
    new DecimalFormat("R$ #, ##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static String doubleToString(Double value) {
    return numberFormat.format(value);
    }

    public void setValue(Double value) {

    }

    public void setnumberFormat(Double numberFormat) {

    }
}
