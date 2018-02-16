/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.despairs.utils;

/**
 *
 * @author EKovtunenko
 */
public class StringUtils {

    public static String upFirstSymbol(String s) {
        char c[] = s.toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        return new String(c);
    }
}
