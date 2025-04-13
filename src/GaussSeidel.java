/*
 * Solve:
 * 12x - 2y + 6z = 86        
 * 2x + 8y + 3z = -5
 * 6x + 2y - 9z = -53
 * 
 * 3 Unknowns: x = 3, y = -4, z = 7
 * 3 Solution:  x = (86 + 2y - 6z) / 12
 *              y = (-5 - 2x - 3z) / 8
 *              z = (-53 - 6x - 2y) / -9
 */

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GaussSeidel {
    private XYSeries gaussSeidelSeries = new XYSeries("Gauss-Seidel");

    GaussSeidel(XYSeriesCollection dataset) {
        dataset.addSeries(gaussSeidelSeries);
    }

    public void printSolution(double x, double y, double z, int k) {    
        double new_x, new_y, new_z;
        double ex, ey, ez, e;
        
        //Formulas
        new_x = (86 + (2 * y) - (6 * z)) / 12;
        new_y = (-5 - (2 * new_x) - (3 * z)) / 8;
        new_z = (-53 - (6 * new_x) - (2 * new_y)) / -9;

        ex = Math.abs((new_x - x) / new_x);
        ey = Math.abs((new_y - y) / new_y);
        ez = Math.abs((new_z - z) / new_z);
        e = (ex + ey + ez) / 3;

        //Print Values
        System.out.println("K = " + k);
        System.out.println("\tx = [86 + 2(" + y + ") - 6(" + z + ")] / 12 = " + new_x);
        System.out.println("\ty = [-5 - " + "2(" + new_x + ") - 3(" + z + ")] / 8 = " + new_y);
        System.out.println("\tz = [-53 - 3(" + new_x + ") - 2(" + new_y + ")] / -9 = " + new_z);

        System.out.println("\n\tex = |(" + new_x + " - " + x + ") / " + new_x + "| = " + ex);
        System.out.println("\tey = |(" + new_y + " - " + y + ") / " + new_y + "| = " + ey);
        System.out.println("\tez = |(" + new_z + " - " + z + ") / " + new_z + "| = " + ez);

        System.out.println("\n\te = (" + ex + " + " + ey + " + " + ez + ") / 3 = " + e + "\n");

        //Add values to gauss-seidel series
        gaussSeidelSeries.add(k, e);

        if(e < 0.000000000000001) {
            System.out.println("FINAL VALUES:");
            System.out.println("\tk: " + k);
            System.out.println("\tx: " + new_x);
            System.out.println("\ty: " + new_y);
            System.out.println("\tz: " + new_z);
            System.out.println("\te: " + e + "\n\n");
        }
        else
            printSolution(new_x, new_y, new_z, k + 1);
    }
}
