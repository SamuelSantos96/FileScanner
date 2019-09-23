import java.io.File;

public abstract class NameFilter implements Filter {
	public boolean accept(File f) {
		//String name = f.getName();
		//String extension = 
		
		return true;
	}
	
	public abstract boolean accept(String name, String extension);
}
