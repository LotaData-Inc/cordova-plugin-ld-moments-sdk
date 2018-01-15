package com.lotadata.moments.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import com.lotadata.moments.MomentsClient;
import com.lotadata.moments.Moments;

public class MomentsPlugin extends CordovaPlugin {
    private Moments momentsClient;

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("initialize")) {

            String api_key = data.getString(0);
            momentsClient = MomentsClient.getInstance(this.cordova.getActivity(), api_key);
            callbackContext.success("Connected!");

            return true;

        } else {
            
            return false;

        }
    }

    protected void onDestroy() {
        if (momentsClient) {
            momentsClient.disconnect();
        }
        super.onDestroy();
    }
}
