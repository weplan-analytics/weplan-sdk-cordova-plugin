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
            this.enableSdk(args.getString(0), args.getString(1), callbackContext);
            return true;
        }
        else if (action.equals("disableSdk")) {
            this.disableSdk(callbackContext);
            return true;
        }
        return false;
    }

    private void enableSdk(String clientId, String clientSecret, CallbackContext callbackContext) {
        com.cumberland.weplansdk.WeplanSdk.INSTANCE.withContext(this.cordova.getActivity().getApplicationContext())
                .withClientId(clientId)
                .withClientSecret(clientSecret)
                .enable();
    }

    private void disableSdk(CallbackContext callbackContext){
        com.cumberland.weplansdk.WeplanSdk.INSTANCE.disable(this.cordova.getActivity().getApplicationContext());
    }
}
