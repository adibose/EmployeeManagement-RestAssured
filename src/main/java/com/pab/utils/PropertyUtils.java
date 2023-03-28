package com.pab.utils;

import com.pab.enums.PropertiesType;

import static com.pab.constants.FrameworkConstants.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class PropertyUtils {
    PropertyUtils(){
    }

    private static Properties properties = new Properties();

    static{
        try( FileInputStream inputStream = new FileInputStream(getPropertyConfigPath()+"config.properties")){
            properties.load(inputStream);
        }catch (IOException e){
            e.printStackTrace();
            System.exit(0);
        }

    }

    public static String getValue(PropertiesType key){
        return properties.getProperty(key.name().toLowerCase());

    }
}
