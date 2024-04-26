package com.suppergerrie2.autof5;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import net.minecraft.client.option.Perspective;

@Modmenu(modId = AutoF5.MOD_ID)
@Config(name = "auto-f5-config", wrapperName = "AutoF5Config")
public class AutoF5ConfigModel {
    public ReturnPerspective returnPerspective = ReturnPerspective.PREVIOUS;
    public ReturnPerspective defaultVehiclePerspective = ReturnPerspective.THIRD_PERSON_BACK;

    public enum ReturnPerspective {
        PREVIOUS,
        FIRST_PERSON,
        THIRD_PERSON_BACK,
        THIRD_PERSON_FRONT;

        public Perspective getPerspective(Perspective previousPerspective) {
            return switch (this) {
                case PREVIOUS -> previousPerspective == null ? Perspective.FIRST_PERSON : previousPerspective; // Default to first person if previous perspective is null
                case FIRST_PERSON -> Perspective.FIRST_PERSON;
                case THIRD_PERSON_BACK -> Perspective.THIRD_PERSON_BACK;
                case THIRD_PERSON_FRONT -> Perspective.THIRD_PERSON_FRONT;
            };
        }
    }
}
