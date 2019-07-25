java -jar C:\...\jvm-dynamic-injection\injector\build\libs\injector-1.0-SNAPSHOT.jar

java -cp "C:\...\jvm-dynamic-injection\injector\build\libs\injector-1.0-SNAPSHOT.jar;C:\Program Files\Java\jdk1.8...\lib\tools.jar" self.ed.Injector

"C:\Program Files\Java\jdk1.8...\bin\java.exe" -cp "C:\...\jvm-dynamic-injection\injector\build\libs\injector-1.0-SNAPSHOT.jar;C:\Program Files\Java\jdk1.8...\lib\tools.jar" self.ed.Injector
"C:\Program Files\Java\jdk1.8...\jre\bin\java.exe" -cp "C:\...\jvm-dynamic-injection\injector\build\libs\injector-1.0-SNAPSHOT.jar;C:\Program Files\Java\jdk1.8...\lib\tools.jar" self.ed.Injector
"C:\Program Files\Java\jre1.8...\bin\java.exe" -Djava.library.path=C:\...\java-libs -cp "C:\...\jvm-dynamic-injection\injector\build\libs\injector-1.0-SNAPSHOT.jar;C:\Program Files\Java\jdk1.8...\lib\tools.jar" self.ed.Injector

"C:\Program Files (x86)\Java\jdk1.8...\jre\bin\java.exe" -Djava.library.path=C:\...\java-libs -cp "C:\...\jvm-dynamic-injection\injector\build\libs\injector-1.0-SNAPSHOT.jar;C:\Program Files\Java\jdk1.8...\lib\tools.jar" self.ed.Injector

"C:\Program Files (x86)\Java\jdk1.8...\jre\bin\java.exe" -jar C:\Work\java-access-bridge\SwingSet2\SwingSet2.jar


Exception in thread "main" com.sun.tools.attach.AttachNotSupportedException: Unable to attach to 32-bit process running under WOW64
        at sun.tools.attach.WindowsVirtualMachine.openProcess(Native Method)
        at sun.tools.attach.WindowsVirtualMachine.<init>(WindowsVirtualMachine.java:56)
        at sun.tools.attach.WindowsAttachProvider.attachVirtualMachine(WindowsAttachProvider.java:69)
        at com.sun.tools.attach.VirtualMachine.attach(VirtualMachine.java:208)
        at self.ed.Injector.main(Injector.java:35)


java.lang.reflect.InvocationTargetException
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	at java.lang.reflect.Method.invoke(Unknown Source)
	at sun.instrument.InstrumentationImpl.loadClassAndStartAgent(Unknown Source)
	at sun.instrument.InstrumentationImpl.loadClassAndCallAgentmain(Unknown Source)
Caused by: java.lang.NullPointerException
	at java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager(Unknown Source)
	at java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager(Unknown Source)
	at java.awt.Component.hasFocus(Unknown Source)
	at java.awt.Component.isFocusOwner(Unknown Source)
	at java.awt.Component.getAccessibleStateSet(Unknown Source)
	at java.awt.Component$AccessibleAWTComponent.getAccessibleStateSet(Unknown Source)
	at java.awt.Window$AccessibleAWTWindow.getAccessibleStateSet(Unknown Source)
	at java.awt.Frame$AccessibleAWTFrame.getAccessibleStateSet(Unknown Source)
	at com.sun.java.accessibility.util.AccessibilityEventMonitor$AccessibilityEventListener.installListeners(AccessibilityEventMonitor.java:159)
	at com.sun.java.accessibility.util.AccessibilityEventMonitor$AccessibilityEventListener.installListeners(AccessibilityEventMonitor.java:148)
	at com.sun.java.accessibility.util.AccessibilityEventMonitor$AccessibilityEventListener.installListeners(AccessibilityEventMonitor.java:136)
	at com.sun.java.accessibility.util.AccessibilityEventMonitor.addPropertyChangeListener(AccessibilityEventMonitor.java:83)
	at self.ed.Injection.agentmain(Injection.java:48)
	... 6 more
