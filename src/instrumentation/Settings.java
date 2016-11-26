package instrumentation;

import java.util.Collections;

import soot.G;
import soot.Scene;
import soot.options.Options;

public class Settings {
	private static boolean SOOT_INITIALIZED = false;
	private final static String androidJAR = "./lib/android.jar";
	
	public static void initialiseSoot(){
		if (SOOT_INITIALIZED)
			return;
		G.reset();
		
		Options.v().set_allow_phantom_refs(true);
//		Options.v().set_whole_program(true);
		Options.v().set_prepend_classpath(true);
		Options.v().set_validate(true);
		
		Options.v().set_output_format(Options.output_format_dex);
		Options.v().set_process_dir(Collections.singletonList(Main.apk));
		Options.v().set_force_android_jar(androidJAR);
		Options.v().set_src_prec(Options.src_prec_apk);
		Options.v().set_force_overwrite(true);
		Options.v().set_soot_classpath(androidJAR);
		
		Scene.v().loadNecessaryClasses();

		SOOT_INITIALIZED = true;
	}
	
}
