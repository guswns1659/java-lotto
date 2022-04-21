package stringcalculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Equation {
    private final String input;
    private final static Pattern PATTERN = Pattern.compile("[0-9]+|[+-/*]");

    public Equation(String input) {
        if (isNullOrBlank(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_NOT_NULL_OR_BLANK.getMessage());
        }

        boolean isWhitespaceNotExists =
                Arrays.stream(input.split(" "))
                        .anyMatch(this::isWhitespaceNotExists);
        if (isWhitespaceNotExists) {
            throw new IllegalArgumentException(ExceptionMessage.WHITESPACE_REQUIRED_BETWEEN_CHARACTER.getMessage());
        }

        this.input = input;
    }

    public String getInput() {
        return input;
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    private boolean isWhitespaceNotExists(String chars) {
        return !PATTERN.matcher(chars).matches();
    }

}
