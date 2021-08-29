package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;

    public static final int MAX_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(final String lottoNumber) {
        this(toInteger(lottoNumber.trim()));
    }

    private static int toInteger(final String lottoNumber) {
        checkIsInteger(lottoNumber);
        return Integer.parseInt(lottoNumber);
    }

    private static void checkIsInteger(String input) {
        if (input == null || !input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("입력된 값에 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    public LottoNumber(final int lottoNumber) {
        validateRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateRange(final int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이 값이어야 합니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
