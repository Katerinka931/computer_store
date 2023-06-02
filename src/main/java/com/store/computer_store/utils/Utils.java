package com.store.computer_store.utils;

import java.util.Locale;

public class Utils {
    public static String getShortClassNameByPojoClass(String name) {
        name = name.toLowerCase(Locale.ROOT);
        return name.contains("pojo") ? name.substring(0, name.length()-4) : name;
    }
}
