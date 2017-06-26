package com.scherule.notifying;

import com.scherule.commons.MicroServiceLauncher;

class NotifyingApplication extends MicroServiceLauncher {

    public static void main(String[] args) {
        new NotifyingApplication().dispatch(args);
    }

}