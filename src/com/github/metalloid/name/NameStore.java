package com.github.metalloid.name;

import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.HashMap;

public class NameStore {
    public static HashMap<WebElement, String> map = new HashMap<>();

    public static void store(Object pageObject) {
        Field[] fields = pageObject.getClass().getDeclaredFields();
        for (Field field : fields) {
            Name annotation = field.getAnnotation(Name.class);
            if (annotation != null) {
                try {
                    map.put((WebElement) field.get(pageObject), annotation.Description());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static String getDescription(WebElement element) {
        return map.get(element);
    }
}