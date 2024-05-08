package org.example.item11.hashCode;

import lombok.RequiredArgsConstructor;

public class PhoneNumNoHashCode {

    private final int areaCode;
    private final int prefix;
    private final int lineNum;

    public PhoneNumNoHashCode(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PhoneNumNoHashCode that = (PhoneNumNoHashCode) o;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }
}
