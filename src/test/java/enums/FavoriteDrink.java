package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FavoriteDrink {

    WATER("drink1"),
    MILK("drink2"),
    COFFEE("drink3"),
    WINE("drink4"),
    CTRL_ALT_DELIGHT("drink5");

    private final String id;
}
