package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AutomationOption {

    DEFAULT("#automation option[value='default']"),
    YES("#automation option[value='yes']"),
    NO("#automation option[value='no']"),
    UNDECIDED("#automation option[value='undecided']");

    private final String css;
}
