package by.imix.homebot;

import java.util.Arrays;
import java.util.List;

public enum OperationEnum {
    PLUS("plus"),
    MINUS("minus");

    OperationEnum(String name) {
    }

    public static List<OperationEnum> getPlusMinus() {
        return Arrays.asList(OperationEnum.values());
    }
}
