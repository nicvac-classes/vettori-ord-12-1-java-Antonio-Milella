import java.util.Scanner;
import java.lang.Math;

class Esercizio {
    public static Random random = new Random();
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n, i;
        
        do {
            System.out.println("Inserisci un valore intero per N");
            n = Integer.parseInt(in.nextLine());
        }
        while (n <= 1);
        int[] r = new int[n];
        int[] o = new int[n];
        
        i = 0;
        while (i <= n - 1) {
            r[i] = random.nextInt(n * 10);
            i = i + 1;
        }
        i = 0;
        while (i <= n - 1) {
            System.out.println("R[" + i + "] = " + r[i]);
            i = i + 1;
        }
        copiaVettore(r, o, n);
        String comando;
        
        do {
            System.out.println("Scegli quale metodo del bubble sort utilizzare per ordinare il vettore R: 1. NON Ottimizzato | 2. Ottimizzato Base | 3. Ottimizzato Plus");
            comando = in.nextLine();
            if (comando.equals("1")) {
                noOPT(o, n);
            } else {
                if (comando.equals("2")) {
                    oPT(o, n);
                } else {
                    oPTPLUS(o, n);
                }
            }
        }
        while (!comando.equals("1") && !comando.equals("2") && !comando.equals("3"));
    }
    
    public static void copiaVettore(int[] r, int[] o, int n) {
        int i;
        
        for (i = 0; i <= n - 1; i++) {
            o[i] = r[i];
        }
    }
    
    public static void noOPT(int[] v, int nv) {
        int i, j, t, confronti;
        
        i = 0;
        confronti = 0;
        while (i <= nv - 1) {
            j = 0;
            while (j <= nv - 2) {
                if (v[j] > v[j + 1]) {
                    t = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = t;
                }
                confronti = confronti + 1;
                j = j + 1;
            }
            i = i + 1;
        }
        System.out.println("Versione utilizzata del bubble sort: NON ottimizzato");
        for (i = 0; i <= nv - 1; i++) {
            System.out.println("V[" + i + "] = " + v[i]);
        }
        System.out.println("Numero confronti: " + confronti);
    }
    
    public static void oPT(int[] v, int n) {
        int t, i, j, confronti;
        
        i = 0;
        confronti = 0;
        while (i <= n - 1) {
            j = 0;
            while (j <= n - 2 - i) {
                if (v[j] > v[j + 1]) {
                    t = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = t;
                }
                confronti = confronti + 1;
                j = j + 1;
            }
            i = i + 1;
        }
        System.out.println("Versione utilizzata del bubble sort: Ottimizzato base");
        for (i = 0; i <= n - 1; i++) {
            System.out.println("V[" + i + "] = " + v[i]);
        }
        System.out.println("Numero confronti: " + confronti);
    }
    
    public static void oPTPLUS(int[] v, int nv) {
        boolean scambio;
        int i, j, t, confronti;
        
        i = 0;
        confronti = 0;
        scambio = true;
        while (i <= nv - 1 && scambio == true) {
            j = 0;
            scambio = false;
            while (j <= nv - 2 - i) {
                if (v[j] > v[j + 1]) {
                    t = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = t;
                    scambio = true;
                }
                confronti = confronti + 1;
                j = j + 1;
            }
            i = i + 1;
        }
        System.out.println("Versione utilizzata del bubble sort: SUPER Ottimizzato");
        for (i = 0; i <= nv - 1; i++) {
            System.out.println("V[" + i + "] = " + v[i]);
        }
        System.out.println("Numero confronti: " + confronti);
    }
}
