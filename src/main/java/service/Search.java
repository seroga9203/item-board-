package service;

import entity.Item;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Search {

    public boolean indexesOf(char[] pattern, char[] text) {
        int[] pfl = pfl(pattern);
        int[] indexes = new int[text.length];
        int size = 0;
        int k = 0;
        for (int i = 0; i < text.length; ++i) {
            while (pattern[k] != text[i] && k > 0) {
                k = pfl[k - 1];
            }
            if (pattern[k] == text[i]) {
                k = k + 1;
                if (k == pattern.length) {
                    indexes[size] = i + 1 - k;
                    size += 1;
                    k = pfl[k - 1];
                }
            } else {
                k = 0;
            }
        }
        /*System.out.println("INDEXES: " + Arrays.toString(indexes));
        System.out.println("SIZE: " + (size));
        String str = Arrays.toString(Arrays.copyOfRange(indexes, 0, size));
        System.out.println(str);
        if (str.equals("[]")) {
            return false;
        } else {
            return true;
        }*/
        //Sys.out for debugging
        System.out.println("SIZE: " + (size));
        if (size!=1) {
            return false;
        } else {
            return true;
        }
    }

    public int[] pfl(char[] text) {
        int[] pfl = new int[text.length];
        pfl[0] = 0;

        for (int i = 1; i < text.length; ++i) {
            int k = pfl[i - 1];
            while (text[k] != text[i] && k > 0) {
                k = pfl[k - 1];
            }
            if (text[k] == text[i]) {
                pfl[i] = k + 1;
            } else {
                pfl[i] = 0;
            }
        }

        return pfl;
    }

    public List<Item> searchItem(List<Item> list, String searchWord) {
        List<Item> resultList = new LinkedList<>();
        for (Item i : list) {
            if (indexesOf(searchWord.toCharArray(), i.getName().toUpperCase().toCharArray())) {
                resultList.add(i);
            }
        }
        return resultList;
    }

}
