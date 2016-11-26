package instrumentation;

import soot.PackManager;
import soot.Transform;

public class Main {
	
	public static String apk = null;
	public static String className = null;
	public static String hostname1 = null;
	public static String hostname2 = null;

	public static void main(String[] args) {
		
		if (args.length != 4)
		{
			System.out.println("Usage: java -jar Soot-repackage.jar hostname1 hostname2 className file.apk");
			System.out.println("Replaces the found hostname1 by hostname2 in invocations statements of class className.");
			System.exit(-1);
		}
		
		
		
		
		hostname1 = args[0];
		hostname2 = args[1];
		className = args[2];
		apk = args[3];
		System.out.println("Replacing " + hostname1 + " by "+ hostname2 + " in class " + className + " of file " + apk);
		
		Settings.initialiseSoot();
		
		PackManager.v().getPack("jtp").add(new Transform("jtp.myAnalysis", new MyBodyTransformer()));
		PackManager.v().runPacks();
		PackManager.v().writeOutput();
	}

}
