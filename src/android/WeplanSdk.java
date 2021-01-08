package cordova.plugin.weplansdk;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeplanSdk extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("enableSdk")) {
            this.enableSdk(args.getString(0), args.getString(1), args.getBoolean(2), callbackContext);
            return true;
        }
        else if (action.equals("disableSdk")) {
            this.disableSdk(callbackContext);
            return true;
        }
        return false;
    }

    private void enableSdk(String clientId, String clientSecret, boolean startOnUpdate, CallbackContext callbackContext) {
        com.cumberland.utils.init.Weplan.Sdk.enable(this.cordova.getActivity(), clientId, clientSecret, startOnUpdate);
    }

    private void disableSdk(CallbackContext callbackContext){
        com.cumberland.utils.init.Weplan.Sdk.disable(this.cordova.getActivity().getApplicationContext());
    }
}
