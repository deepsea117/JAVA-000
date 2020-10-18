package com.deepsea.geekbang.jvm;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloXlassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] classData = getData(name);
        return defineClass(classData, 0, classData.length);
    }

    private byte[] getData(String xlassPath) {

        File file = new File(xlassPath);
        if (file.exists()) {
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            byte[] result = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();
                byte[] buffer = new byte[1];
                byte[] decoded = new byte[1];
                int size = 0;
                while ((size = in.read(buffer)) != -1) {
                    decoded[0] = (byte)((byte) 255 - buffer[0]);
                    out.write(decoded, 0, size);
                }
                result = out.toByteArray();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return result;
        } else {
            return null;
        }

    }

    public static void main(String[] args) {

        String xlassPath = "/Users/liangyanhong/geekbang/java-000/JAVA-000/Week_01/Hello.xlass";

        try {

            Class<?> xlass = new HelloXlassLoader().findClass(xlassPath);
            Method hello = xlass.getDeclaredMethod("hello");
            hello.setAccessible(true);
            hello.invoke(xlass.newInstance());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


}
