package cordova.plugin.weplansdk;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class WeplanSdk extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("enableSdk")) {
            this.enableSdk(callbackContext);
            return true;
        }
        else if (action.equals("disableSdk")) {
            this.disableSdk(callbackContext);
            return true;
        }
        return false;
    }

    // TODO change keys
    private void enableSdk(CallbackContext callbackContext){
        com.cumberland.weplansdk.WeplanSdk.INSTANCE.withContext(this.cordova.getActivity().getApplicationContext())
                .withClientId("mLjamj5RzzNeHRMY9jTpstsKduTGiRrY69Wi55yDqwNBHYsPNwGKj3w6HedG1l1NvkuexTNPvT0j52thhtqnU1")
                .withClientSecret("Q0IRLVPdunhApbZGqSQBrvmNbCoOucaY7sRuwPuoBHnhFhrvbJoMfWOvqlfBKTCDWtOSGNuurcQVIBWmZBTnzF")
                .enable();
    }

    private void disableSdk(CallbackContext callbackContext){
        com.cumberland.weplansdk.WeplanSdk.INSTANCE.disable(this.cordova.getActivity().getApplicationContext());
    }
}
