package br.com.alura.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Transformator {

    public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> source = input.getClass();
        Class<?> target = Class.forName(source + "DTO");

        O targetClass = (O) target.getDeclaredConstructor().newInstance();

        Field[] sourcesFields = source.getDeclaredField();
        Field[] targetFields = target.getDeclaredField();
        return targetClass;
    }
}
