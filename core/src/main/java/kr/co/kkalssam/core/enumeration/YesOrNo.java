package kr.co.kkalssam.core.enumeration;

/**
 * Created by jslim@genieworks.net on 2018. 10. 10.
 */
public enum YesOrNo {
    Y("Yes"),
    N("No");

    private final String value;

    YesOrNo(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static YesOrNo fromValue(String v) {
        for (YesOrNo c : YesOrNo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
