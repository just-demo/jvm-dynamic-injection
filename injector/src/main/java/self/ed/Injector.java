package self.ed;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.nio.file.Paths;
import java.util.List;

public class Injector {
    // Required permissions https://docs.oracle.com/javase/7/docs/jdk/api/attach/spec/com/sun/tools/attach/AttachPermission.html
    // In com.sun.tools.attach.spi.AttachProvider.AttachProvider there is: System.getSecurityManager().checkPermission(new AttachPermission("createAttachProvider"));
    // https://spaceflight.nasa.gov/realdata/sightings/SSapplications/Post/JavaSSOP/JavaSSOP.html
    // sun.tools.attach.WindowsAttachProvider has static code: System.loadLibrary("attach");
    public static void main(String[] args) throws Exception {
//        String app = "SwingSet2.jar";
        String app = "sun.plugin2.main.client.PluginMain";
//        String app = "sun.applet.AppletViewer";
        System.out.println(app);
        List<VirtualMachineDescriptor> vms = VirtualMachine.list();
        String pid = vms.stream()
                .filter(vm -> vm.displayName().contains(app))
                .map(VirtualMachineDescriptor::id)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Target application " + app + " was not found"));
        VirtualMachine vm = VirtualMachine.attach(pid);
        String injection = Paths.get("injection", "build", "libs", "injection-1.0-SNAPSHOT.jar").toAbsolutePath().toString();
        vm.loadAgent(injection);
        vm.detach();
        System.out.println("OK!");
    }
}
