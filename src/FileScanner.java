import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileScanner {
	private File root;

	public FileScanner(File root) {
		this.root = root;
	}
	
	//Returns all the files/directories
	public List<String> scan() {
		return scan(filter -> true);
	}
	
	//Returns all the files/directories based on the filter
	public List<String> scan(Filter filter) {
		List<String> list = new ArrayList();
		scan(root, list, filter);
		return list;
	}
	
	//Recursive method to scan files/directories inside directories
	private static void scan(File file, List<String> list, Filter filter) {
		//If the file isn't a directory it checks for the condition based on the filters
		if(file.isFile()) {
			//If the file is accepted the program adds the file to the list of results found
			if(filter.accept(file)) {
				list.add(file.getAbsolutePath());				
			}
		}
		//If it's a directory the method will call itself (recursively) to scan for the files/directories inside the directory
		else {
			for(File child : file.listFiles()) {
				scan(child, list, filter);
			}
		}	
	}
	
	//Main
	public static void main(String[] args) {
		FileScanner t = new FileScanner(new File("C:\\Users\\Samuel Santos\\eclipse-workspace\\WarmUpFileScanner"));
		//List<String> list2 = t.scan(new Teste());
		List<String> list = t.scan(e -> e.getName().startsWith("F"));
		for(String path : list) {
			System.out.println(path);
		}
	}
}
