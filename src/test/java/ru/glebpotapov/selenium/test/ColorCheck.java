package ru.glebpotapov.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.Arrays;


/**
 *
 * @author PotapovGA
 */
public class ColorCheck {
    public static int[] convert(String color, ChromeDriver driver) {
        String[] str_RGB = color.replace("rgba(", "")
                .replace(")", "")
                .replace(" ", "")
                .split(",");
        int[] int_RGB = Arrays.asList(str_RGB).stream().mapToInt(Integer::parseInt).toArray();
        return int_RGB;
    }

    public static int[] convert(String color, FirefoxDriver driver) {
        String[] str_RGB = color.replace("rgb(", "")
                .replace(")", "")
                .replace(" ", "")
                .split(",");
        int[] int_RGB = Arrays.asList(str_RGB).stream().mapToInt(Integer::parseInt).toArray();
        return int_RGB;
    }

    public static int[] convert(String color, InternetExplorerDriver driver) {
        String[] str_RGB = color.replace("rgba(", "")
                .replace(")", "")
                .replace(" ", "")
                .split(",");
        int[] int_RGB = Arrays.asList(str_RGB).stream().mapToInt(Integer::parseInt).toArray();
        return int_RGB;
    }

    public static boolean isGray(int[] color_arr) {
        if (color_arr[0] == color_arr[1] && color_arr[1] == color_arr[2]) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isRed(int[] color_arr) {
        if (color_arr[0] > 0 && color_arr[1] == 0 && color_arr[2] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isGreen(int[] color_arr) {
        if (color_arr[1] > 0 && color_arr[0] == color_arr[2] && color_arr[2] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBlue(int[] color_arr) {
        if (color_arr[2] > 0 && color_arr[0] == color_arr[1] && color_arr[1] == 0) {
            return true;
        } else {
            return false;
        }
    }
}