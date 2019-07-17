package self.ed;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.nio.file.Paths;

public class Injector {
    public static void main(String[] args) throws Exception {
        String app = "SwingSet2.jar";
        String pid = VirtualMachine.list().stream()
                .filter(vm -> vm.displayName().endsWith(app))
                .map(VirtualMachineDescriptor::id)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Target application " + app + " is not running"));
        VirtualMachine vm = VirtualMachine.attach(pid);
        String injection = Paths.get("injection", "build", "libs", "injection-1.0-SNAPSHOT.jar").toAbsolutePath().toString();
        vm.loadAgent(injection);
        vm.detach();
    }
}
