package com.rnappzilo;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import com.appzilo.sdk.Offerwall;

public class AppziloModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public AppziloModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        Offerwall.onNewIntent(reactContext.getApplicationContext(), getCurrentActivity().getIntent());
    }

    @Override
    public String getName() {
        return "Appzilo";
    }

    @ReactMethod
    public void init(String appKey, String userId) {
        Offerwall.initApp(getCurrentActivity(), appKey, userId);
    }

    @ReactMethod
    public void showOfferwall() {
        Offerwall.show();
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }
}
