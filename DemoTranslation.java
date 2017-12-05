package include;

import com.mtsystems.coot.NativeHelper;
import com.mtsystems.coot.String8;
import com.sun.jna.Library;

public class Stdio {
	private static interface IndirectMappings extends Library {
		int scanf(String8 format, Object... varargs);
	}

	private final static IndirectMappings INDIRECT_MAPPINGS;

	static {
		// The online demo uses the example library "libc.so.6".
		// Have a look at the translated programs for real values.
		NativeHelper h = NativeHelper.get("libc.so.6");
		INDIRECT_MAPPINGS = h.bindIndirect(IndirectMappings.class);
	}

	/**
	 * Read formatted input from stdin.
	 */
	public static int scanf(String8 format, Object... varargs) {
		return INDIRECT_MAPPINGS.scanf(format, varargs);
	}
}


// ----- ----- Class 2: DemoTranslation ----- -----

package demo;

import static com.mtsystems.coot.String8.cs8;
import static include.Stdio.scanf;

import com.mtsystems.coot.String8;

public class DemoTranslation {
	public static void main(String[] args) {
		String8 x = new String8(101), y = new String8(101);
		int i, j;

		i = scanf(cs8("%s\n%s"), x, y);
		i = 0;
		while(x.get(i) != 0 && x.get(i) >= y.get(i)) {
			i++;
		}
		if(x.get(i) < y.get(i)) {
			System.out.print("-1");
			return;
		}
		System.out.print(y);
	}
}
