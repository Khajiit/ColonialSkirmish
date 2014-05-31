package pl.edu.agh.colonialskirmish.rhino;

import java.util.Map;
import java.util.Map.Entry;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import android.util.Log;

public class RhinoContext {

	/* Map of all variables accessible from script context */
	protected Map<String, Object> variablesMap;

	/**
	 * Create new context, bind configured variables and execute given script in
	 * this context
	 * 
	 * @param script
	 *            - script code
	 * @param scriptId
	 *            - script sourceName, useful for debugging
	 */
	public void execute( String script, String scriptId, Map<String, Object> additionalVariablesMap ) {
		Context cx = Context.enter();
		cx.setOptimizationLevel(-1);

		try {
			// bind external variables to scope
			Scriptable scope = cx.initStandardObjects();
			for ( Entry<String, Object> variableEntry : variablesMap.entrySet() ) {
				ScriptableObject.putProperty(scope, variableEntry.getKey(),
						Context.javaToJS(variableEntry.getValue(), scope));
			}

			Log.i("RhinoContext", "Evaluating script: " + script);
			// evaluate script
			cx.evaluateString(scope, script, scriptId, 1, null);
		} finally {
			Context.exit();
		}
	}

	public Map<String, Object> getVariablesMap() {
		return variablesMap;
	}

	public void setVariablesMap( Map<String, Object> variablesMap ) {
		this.variablesMap = variablesMap;
	}

	public void onTerminate() {

	}

}
