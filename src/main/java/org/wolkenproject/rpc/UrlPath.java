package org.wolkenproject.rpc;

import org.wolkenproject.utils.VoidCallable;

public class UrlPath {
    private String                      path;
    private UrlPath[]                   paths;
    private VoidCallable<Messenger>     onGET;

    public UrlPath(String path, UrlPath paths[], VoidCallable<Messenger> onGET) {
        this.path   = path;
        this.paths  = paths;
        this.onGET  = onGET;
    }

    public String getPath() {
        return path;
    }

    public UrlPath[] getPaths() {
        return paths;
    }
}
