package ir.ariaman.ariakala.event;

import org.greenrobot.eventbus.EventBus;

public class NetworkConnectionErrorEvent {
    private final String networkErrorDetails;

    public NetworkConnectionErrorEvent(String networkErrorDetails) {
        this.networkErrorDetails = networkErrorDetails;
    }

    public String getNetworkErrorDetails() {
        return networkErrorDetails;
    }

    public static void postNetworkConnectionError(String errorDetails) {
        NetworkConnectionErrorEvent errorEvent = new NetworkConnectionErrorEvent(errorDetails);
        EventBus.getDefault().post(errorEvent);
    }
}
