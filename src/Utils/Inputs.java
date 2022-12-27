package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


/*
*Clase pra manejar as entradas de datos, son ferramentas pra validar a informacion.
*@author Jose PS
*/
public class Inputs {

    private static Scanner lec = new Scanner(System.in);

    public static int getInt() {
        int numero = 0;
        try {
            numero = Integer.parseInt(lec.nextLine());
        } catch (NumberFormatException e) {
        }
        return numero;
    }
    
    public static double getDouble(String num) throws Exception {
        double numd = 0;
        try {
            numd = Double.parseDouble(num);           
        } catch (NumberFormatException e) {
            throw new Exception("Debes introducir un numero.");
        }
        return numd;
    }
    
    public static String getString(String menu) throws CancelException {
        System.out.println(menu);
        String txt;
        txt = lec.nextLine();
        if (txt.charAt(0)=='*') throw new CancelException();
        return txt;
    }

    public static int getInt(String txt) throws CancelException {
        System.out.println(txt);
        int numero = 0;
        String num=lec.nextLine();
        if(num.charAt(0)=='*') throw new CancelException ();
        try {
            numero = Integer.parseInt(num);
        } catch (NumberFormatException e) {
        }
        return numero;

    }

    public static int getInt(String txt, int min, int max) throws CancelException {
        String input = null;
        int numero = 0;
        boolean sigue = false;
        while (!sigue) {
            try {
                System.out.println(txt);
                input = lec.nextLine();
                if (input.charAt(0) == '*') {
                    throw new CancelException();
                }
                numero = Integer.parseInt(input);
                if (numero < min || numero > max) {
                    System.out.println("O numero debe ser maior que " + min + " e menor que " + max);
                } else {
                    sigue = true;
                }
            } catch (NumberFormatException ne) {
            }
        }
        return numero;
    }

    public static Calendar getDate(String str) throws CancelException {
        Calendar data1 = Calendar.getInstance();
        String data;
        boolean sigue = false;
        while (!sigue) {
            try {
                System.out.println(str);
                data = lec.nextLine();
                if (data.charAt(0)=='*') {
                    throw new CancelException();
                }
                SimpleDateFormat dataf = new SimpleDateFormat("dd/MM/yyyy");
                dataf.setLenient(false);
                data1.setTime(dataf.parse(data));
                sigue = true;
            } catch (ParseException pa) {
                System.out.println("Non e unha data valida");
                sigue = false;
            }
        }
        return data1;
    }

    public static String calendarToString(Calendar c) {
        Date date = c.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public static void validaDni(String dni) throws  CancelException, Exception {
        char letradni;
        int numsDni;
        final char[] letras = new char[]{'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        try {
            if (dni.length() < 9 || dni.length() > 9) {
               throw new Exception("Non Valido");
            }
            else if (dni == null) {
                throw new Exception ("Non pode quedar baleiro");
            }
            else if (dni.charAt(0)== '*') throw new CancelException();
            letradni = dni.toUpperCase().charAt(dni.length() - 1);
            numsDni = Integer.parseInt(dni.substring(0, dni.length() - 1));
            int pos = numsDni % 23;
            if (letras[pos] != letradni) {
                throw new Exception ("Non Valido");
            }
        } catch (NumberFormatException n) {
            throw new Exception ("Non Valido");
        }
    }

    public static float getFloat(String txt) throws CancelException {
        System.out.println(txt);
        float numero = 0;
        String num=lec.nextLine();
        if(num.charAt(0)=='*') throw new CancelException ();
        try {
            numero = Float.parseFloat(num);
        } catch (NumberFormatException e) {
        }
        return numero;
    }
}
