package ir.ariaman.ariakala.event;

import org.greenrobot.eventbus.EventBus;

public class RetrySettingDataEvent {
    public static void postRetrySettingDataEvent() {
        RetrySettingDataEvent event = new RetrySettingDataEvent();
        EventBus.getDefault().post(event);
    }
}
