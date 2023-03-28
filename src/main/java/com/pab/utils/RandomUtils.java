package com.pab.utils;

public final class RandomUtils {

    //business layer -- All the business changes should be updated here.
    private RandomUtils(){
    }

    public static int getID(){
        return FakerUtils.getNumber(1000000,3000000);
    }

    public static String getFirstName(){
        return FakerUtils.getfirstName();
    }

    public static String getLastName(){
        return FakerUtils.getlastName();
    }

    public static String getEmail(){
        return FakerUtils.getEmailAddress();
    }


}
