package self.ed;

import com.sun.java.accessibility.util.SwingEventMonitor;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.lang.instrument.Instrumentation;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.swing.BoxLayout.Y_AXIS;

public class InjectionSwing {
    public static void agentmain(String agentArgs, Instrumentation inst) {
        Console console = new Console();
        // This produces too many events
        // AccessibilityEventMonitor.addPropertyChangeListener(e -> console.log("propertyChange: " + e));
        SwingEventMonitor.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                console.log("menuSelected: " + e);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                console.log("menuDeselected: " + e);
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                console.log("menuCanceled: " + e);
            }
        });
    }

    static class Console {
        JPanel panel;

        Console() {
            JFrame frame = new JFrame("Injection");
            panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, Y_AXIS));
            frame.add( new JScrollPane(panel));
            frame.setSize(500, 500);
            frame.setVisible(true);
        }

        void log(String message) {
            SwingUtilities.invokeLater(() -> {
                panel.add(new JLabel(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()) + " - " + message));
                panel.updateUI();
            });
        }
    }
}
