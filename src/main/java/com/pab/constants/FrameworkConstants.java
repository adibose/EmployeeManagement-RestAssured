package com.pab.constants;

import lombok.Getter;

public final class FrameworkConstants {

    FrameworkConstants(){}

    private @Getter static final String RequestJsonFolderPath = System.getProperty("user.dir")+"/src/main/resources/jsons/";

    private @Getter static final String ResponseJsonFolderPath = System.getProperty("user.dir")+"/outputs/";
    private @Getter static final String PropertyConfigPath = System.getProperty("user.dir")+"/src/main/resources/";

}
