package models;

import java.util.List;

public class ReceiverModels {
    static String f;
    public ReceiverModels(String f) {
        ReceiverModels.f = f;
    }
    @Override
    public String toString() {
        return f;
    }
}
