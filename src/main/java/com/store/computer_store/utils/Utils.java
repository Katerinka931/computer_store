package com.store.computer_store.utils;

public class Utils {
    public static String getShortClassNameByPojoClass(String name) {
        return name.contains("pojo") ? name.substring(0, name.length()-4) : name;
    }
}
