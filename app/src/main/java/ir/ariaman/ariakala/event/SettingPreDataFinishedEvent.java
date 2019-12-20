package ir.ariaman.ariakala.event;

import org.greenrobot.eventbus.EventBus;

public class SettingPreDataFinishedEvent {
    public static void postSettingPreDataFinishedEvent() {
        SettingPreDataFinishedEvent event = new SettingPreDataFinishedEvent();
        EventBus.getDefault().post(event);
    }
}
