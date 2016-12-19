import com.sun.jna.Library;
import com.sun.jna.Native;

public class Test {
    public interface CStdLib
            extends Library {
        int prctl(final int option, final long arg2);
    }

    public static void main(final String[] args) throws Throwable {
        final CStdLib c = (CStdLib) Native.loadLibrary("c", CStdLib.class);
        final int PR_SET_PDEATHSIG = 1;
        final long SIGKILL = 9;
        final int rc = c.prctl(PR_SET_PDEATHSIG, SIGKILL);
        if (rc != 0) {
            System.out.println("prctl failed, rc=" + rc);
            System.exit(1);
        }
        while (true) {
            Thread.sleep(1000L);
            System.out.println("java - ping");
            System.out.flush();
        }
    }
}
