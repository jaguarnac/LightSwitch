package com.jaguarnac.lightswitch.lightswitch;

import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by nachiket on 9/21/2014.
 */
public class ListenerService extends WearableListenerService {
    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        final String path = new String(messageEvent.getPath());
        if (path.equals("/message_path")) {
            final String message = new String(messageEvent.getData());
            Log.d("myTag", "Message path received on handheld is: " + path);
            Log.d("myTag", "Message received on handheld is: " + message);
        }
        else if (path.equals("/light")){
            Log.d("myTag","Toggling light");
            new LightSwitcherTask().execute();
        }
        else {
            super.onMessageReceived(messageEvent);
        }
    }
}
