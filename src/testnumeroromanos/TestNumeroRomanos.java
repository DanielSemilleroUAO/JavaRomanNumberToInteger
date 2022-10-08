/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testnumeroromanos;

import java.util.List;

/**
 *
 * @author delga
 */
public class TestNumeroRomanos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt(""));
        System.out.println(romanToInt("MMMDCCCLXXXVIII"));
    }

    public static int romanToInt(String s) {
        if (!s.contains("I") && !s.contains("V") && !s.contains("X")
                && !s.contains("L") && !s.contains("C")
                && !s.contains("D") && !s.contains("M")) {
            return 0;
        }

        if (s.length() < 1 || s.length() > 15) {
            return 0;
        }

        char[] caracter = s.toCharArray();
        int total = 0;
        int tamano = caracter.length - 1;
        for (int i = 0; i < caracter.length; i++) {
            if ( i != tamano && caracter[i] == 'I' && (caracter[i + 1] == 'V' || caracter[i + 1] == 'X')) {
                total += caracter[i + 1] == 'V' ? 4 : 9;
                i++;
            } else if ( i != tamano && caracter[i] == 'X' && (caracter[i + 1] == 'L' || caracter[i + 1] == 'C')) {
                total += caracter[i + 1] == 'L' ? 40 : 90;
                i++;
            } else if ( i != tamano && caracter[i] == 'C' && (caracter[i + 1] == 'D' || caracter[i + 1] == 'M')) {
                total += caracter[i + 1] == 'D' ? 400 : 900;
                i++;
            } else {
                switch(caracter[i]){
                    case 'I':
                        total += 1;
                        break;
                    case 'V':
                        total += 5;
                        break;
                    case 'X':
                        total += 10;
                        break;
                    case 'L':
                        total += 50;
                        break;
                    case 'C':
                        total += 100;
                        break;
                    case 'D':
                        total += 500;
                        break;
                    case 'M':
                        total += 1000;
                        break;
                     default:
                         break;
                }
            }
        }

        return total;
    }

}
