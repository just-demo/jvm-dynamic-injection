package self.ed;

import com.sun.java.accessibility.util.AccessibilityEventMonitor;
import com.sun.java.accessibility.util.EventQueueMonitor;
import sun.awt.AppContext;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.instrument.Instrumentation;

import static java.lang.System.identityHashCode;

public class InjectionApplet {

    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("Injected into applet!");
        System.out.println("currentThread = " + Thread.currentThread());
        System.out.println("currentThread identityHashCode = " + identityHashCode(Thread.currentThread()));
        System.out.println("currentThreadGroup = " + Thread.currentThread().getThreadGroup());
        System.out.println("currentThreadGroup identityHashCode = " + identityHashCode(Thread.currentThread().getThreadGroup()));
        ((Container) EventQueueMonitor.getTopLevelWindows()[0].getComponents()[0]).getComponents()[1].addPropertyChangeListener(e -> System.out.println("propertyChange (text): " + e));
        ((Container) EventQueueMonitor.getTopLevelWindows()[0].getComponents()[0]).getComponents()[1].addMouseListener(createMouseListener());
        System.out.println("Done!!!");

        AppContext appContext = AppContext.getAppContext();
        System.out.println("AppContext = " + appContext);

        System.out.println("Before");
        // TODO: this does not work:
        AccessibilityEventMonitor.addPropertyChangeListener(e -> System.out.println("propertyChange: " + e));

        System.out.println("After");
    }

    private static MouseListener createMouseListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked: " + e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mouseClicked: " + e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased: " + e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered: " + e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited: " + e);
            }
        };
    }
}
