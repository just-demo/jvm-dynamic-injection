package self.ed;

import sun.awt.AppContext;

import java.applet.Applet;
import java.awt.*;

import static java.lang.System.identityHashCode;

public class TestApplet extends Applet {
    private TextField text = new TextField("Example3!!!");
    private Button button = new Button("Reset");

    @Override
    public void init() {
        AppContext appContext = AppContext.getAppContext();
        System.out.println("AppContext (init) = " + appContext);
        System.out.println("currentThread (init) = " + Thread.currentThread());
        System.out.println("currentThread identityHashCode (init) = " + identityHashCode(Thread.currentThread()));
        System.out.println("currentThreadGroup (init) = " + Thread.currentThread().getThreadGroup());
        System.out.println("currentThreadGroup identityHashCode (init) = " + identityHashCode(Thread.currentThread().getThreadGroup()));

//        AccessibilityEventMonitor.addPropertyChangeListener(e -> System.out.println("propertyChange (init): " + e));

        System.out.println("Init...");
        add(button);
        add(text);
        button.addActionListener(e -> {
            text.setText("Reset!");
            System.out.println("actionPerformed: " + e);
            System.out.println("AppContext (actionPerformed) = " + AppContext.getAppContext());
        });
    }

    public void paint(Graphics g) {
        System.out.println("Print...");
        g.drawString("It works!", 50, 25);
    }
}
