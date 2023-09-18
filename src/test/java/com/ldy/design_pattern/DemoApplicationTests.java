package com.ldy.design_pattern;

import com.ldy.design_pattern.factory_strategy_template.AbstractHandler;
import com.ldy.design_pattern.factory_strategy_template.StrategyFactory;
import com.ldy.design_pattern.observer.Observer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Test
    void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        ClassLoader classLoader = DemoApplicationTests.class.getClassLoader();
        Class<?> applicationClazz = classLoader.loadClass("");

        if (applicationClazz.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScan = applicationClazz.getAnnotation(ComponentScan.class);
            String[] path = componentScan.value();

            URL resource = classLoader.getResource(path[0]);
            File file = new File(resource.getFile());
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    String fileName = f.getAbsolutePath();
                    if (fileName.endsWith(".class")) {
                        String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                        className = className.replace("\\", ".");
                        Class<?> clazz = classLoader.loadClass(className);
                        if (applicationClazz.isAnnotationPresent(Component.class)) {
                            // Bean
                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                BeanPostProcessor instance = (BeanPostProcessor) clazz.newInstance();
                            }
                        }
                    }
                }
            }
        }
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = beanDefinition.getClazz();
        Object instance = clazz.getConstructor().newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                field.setAccessible(true);
                // field.set(instance, getBean(field.getName()));
            }
        }
        return instance;
    }

}
class BeanDefinition {
    private String beanName;
    private Class<?> clazz;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
}
