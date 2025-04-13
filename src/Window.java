import javax.swing.JFrame;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

public class Window extends ChartFrame {
    Window(JFreeChart chart) {
        super("Group 2 - ModSim", chart);
        this.setSize(1500, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
