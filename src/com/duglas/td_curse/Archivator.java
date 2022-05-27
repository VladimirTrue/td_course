package com.duglas.td_curse;

import java.util.*;
import java.util.stream.Collectors;

public class Archivator {

    public static void main(String[] args) {
        System.out.println(doArchiveStr("AAABBcCssssSAA"));
        System.out.println(doArchiveStr("A"));
        System.out.println(doArchiveStr("DDD"));
        System.out.println(doArchiveStr("AADDDdd"));
        System.out.println(doArchiveStr("214141SS"));
        System.out.println(doArchiveStr(" "));
    }

    public static String doArchiveStr(String str) {
        if (str.isEmpty()) {
            return "Недопустимое значение: Введенная строка пустая";
        }

        //проверка на наличиче чисел или пробелов
        if (str.matches(".*[0-9].*|\\s*")) {
            return "недопустимое значение: Строка содержит цифры или пробел";
        }

        StringBuilder sb = new StringBuilder();
        //лист значений из получаемой строки
        List<Character> strChars = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.toList());

        Character bufCh;//текущее значение для цикла
        int cnt = 0; //счётчик
        for (int i = 0; i < strChars.size(); i++) {
            cnt++;
            bufCh = strChars.get(i);
            if ((i + 1) < strChars.size() && bufCh == strChars.get(i + 1)) { //если есть следующий элемент и если он раввен текущему
                continue;
            } else if (cnt == 1) { //если счетчик 1, добавляем просто символ, обнуляем cnt
                sb.append(bufCh);
                cnt = 0;
            } else { //иначе добавляем количество текущего символа и сам символ, обнуляем cnt
                sb.append(cnt);
                sb.append(bufCh);
                cnt = 0;
            }
        }

        return sb.toString();
    }

}
