package com.suppergerrie2.autof5;

import blue.endless.jankson.Jankson;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.util.Observable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class AutoF5Config extends ConfigWrapper<com.suppergerrie2.autof5.AutoF5ConfigModel> {

    public final Keys keys = new Keys();

    private final Option<com.suppergerrie2.autof5.AutoF5ConfigModel.ReturnPerspective> returnPerspective = this.optionForKey(this.keys.returnPerspective);
    private final Option<com.suppergerrie2.autof5.AutoF5ConfigModel.ReturnPerspective> defaultVehiclePerspective = this.optionForKey(this.keys.defaultVehiclePerspective);

    private AutoF5Config() {
        super(com.suppergerrie2.autof5.AutoF5ConfigModel.class);
    }

    private AutoF5Config(Consumer<Jankson.Builder> janksonBuilder) {
        super(com.suppergerrie2.autof5.AutoF5ConfigModel.class, janksonBuilder);
    }

    public static AutoF5Config createAndLoad() {
        var wrapper = new AutoF5Config();
        wrapper.load();
        return wrapper;
    }

    public static AutoF5Config createAndLoad(Consumer<Jankson.Builder> janksonBuilder) {
        var wrapper = new AutoF5Config(janksonBuilder);
        wrapper.load();
        return wrapper;
    }

    public com.suppergerrie2.autof5.AutoF5ConfigModel.ReturnPerspective returnPerspective() {
        return returnPerspective.value();
    }

    public void returnPerspective(com.suppergerrie2.autof5.AutoF5ConfigModel.ReturnPerspective value) {
        returnPerspective.set(value);
    }

    public com.suppergerrie2.autof5.AutoF5ConfigModel.ReturnPerspective defaultVehiclePerspective() {
        return defaultVehiclePerspective.value();
    }

    public void defaultVehiclePerspective(com.suppergerrie2.autof5.AutoF5ConfigModel.ReturnPerspective value) {
        defaultVehiclePerspective.set(value);
    }


    public static class Keys {
        public final Option.Key returnPerspective = new Option.Key("returnPerspective");
        public final Option.Key defaultVehiclePerspective = new Option.Key("defaultVehiclePerspective");
    }
}

