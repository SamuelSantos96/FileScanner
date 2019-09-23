import java.io.File;

public class Teste implements Filter {
	public boolean accept(File f) {
		return f.getName().startsWith("F");
	}
}
