package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FavoriteColor {

    RED("color1"),
    BLUE("color2"),
    YELLOW("color3"),
    GREEN("color4"),
    FFC0CB("color5");

    private final String id;
}
