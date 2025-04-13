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

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeriesCollection;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        XYSeriesCollection dataset = new XYSeriesCollection();
        System.out.println("\n===============================================");
        System.out.println(" G2 - Iterative Methods on Systems of Equation");
        System.out.println("===============================================\n");
        System.out.println("Given: \n\t12x - 2y + 6z = 86 \n\t2x + 8y + 3z = -5 \n\t6x + 2y - 9z = -53");
        System.out.println("\n\tx = (86 + 2y - 6z) / 12 \n\ty = (-5 - 2x - 3z) / 8 \n\tz = (-53 - 6x - 2y) / -9 \n");

        int input;
        Jacobi jacobi = new Jacobi(dataset);
        GaussSeidel gaussSeidel = new GaussSeidel(dataset);
        do {
            System.out.println("Pick an iterative method: ");
            System.out.println("\t1. Jacobi Method");
            System.out.println("\t2. Gauss-Seidel Method");
            System.out.println("\t3. Both Method");
            System.out.println("\t4. Exit\n");
            System.out.print("Choice => ");
            input = scanner.nextInt();

            switch (input) {
                case 1:
                    System.out.println("\n[JACOBI METHOD]");
                    jacobi.printSolution(0, 0, 0, 1);
                    break;
                case 2:
                    System.out.println("\n[GAUSS-SEIDEL METHOD]");
                    gaussSeidel.printSolution(0, 0, 0, 1);
                    break;
                case 3:
                    System.out.println("\n[JACOBI METHOD]");
                    jacobi.printSolution(0, 0, 0, 1);
                    System.out.println("\n[GAUSS-SEIDEL METHOD]");
                    gaussSeidel.printSolution(0, 0, 0, 1);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid input, please try again...\n");
            }
        } while (input < 1 || input > 4);

        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "Plot of Error",
                "Iteration", "Value of Error (e)",
                dataset);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        lineChart.getXYPlot().setRenderer(renderer);

        new Window(lineChart);
        scanner.close();
    }
}
