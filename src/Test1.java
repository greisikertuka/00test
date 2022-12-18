import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Jepni vitin e kupes se botes");
        String viti = scn.next();
        System.out.println("Jepni grupin e kupes se botes");
        String grupi = scn.next();
        String header = "World Cup" + viti + " - Group " + grupi;
        System.out.println("Jep 4 ekipet:");
        String[] ekipet = new String[4];
        for (int i = 0; i < 4; i++) {
            ekipet[i] = scn.next();
        }
        System.out.println("Jep ndeshjet ne formatin : Ekipi1#2@1#Ekipi2");
        String[] ndeshjet = new String[6];
        for (int i = 0; i < 6; i++) {
            ndeshjet[i] = scn.next();
        }
        String outputi = llogaritGrupin(ekipet, ndeshjet, header);
        System.out.println(outputi);
    }

    static String llogaritGrupin(String[] ekipet, String[] ndeshjet, String header) {
        int[] piket = new int[ekipet.length];
        int[] diferencaEGolave = new int[ekipet.length];
        for (String ndeshje : ndeshjet) {
            int index1 = -1;
            int index2 = -1;
            String gjysma1 = ndeshje.split("@")[0];
            String ekipi1 = gjysma1.split("#")[0];
            int golatEkipi1 = Integer.parseInt(gjysma1.split("#")[1]);
            String gjysma2 = ndeshje.split("@")[1];
            String ekipi2 = gjysma2.split("#")[1];
            int golatEkipi2 = Integer.parseInt(gjysma2.split("#")[0]);
            for (int i = 0; i < 4; i++) {
                if (ekipet[i].equals(ekipi1)) index1 = i;
                else if (ekipet[i].equals(ekipi2)) index2 = i;
            }
            int gd = golatEkipi1 - golatEkipi2;
            if (gd == 0) {
                piket[index1] += 1;
                piket[index2] += 1;
            } else if (gd > 0) {
                piket[index1] += 3;
                diferencaEGolave[index1] += gd;
                diferencaEGolave[index2] -= gd;
            } else {
                piket[index2] += 3;
                diferencaEGolave[index1] += gd;
                diferencaEGolave[index2] -= gd;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (piket[i] < piket[j]) {
                    int tempNumber = piket[i];
                    piket[i] = piket[j];
                    piket[j] = tempNumber;
                    String tempString = ekipet[i];
                    ekipet[i] = ekipet[j];
                    ekipet[j] = tempString;
                    int tempGoalDif = diferencaEGolave[i];
                    diferencaEGolave[i] = diferencaEGolave[j];
                    diferencaEGolave[j] = tempGoalDif;
                }
            }
        }
        header += "\n\n";
        for (int i = 0; i < ekipet.length; i++) {
            header = header.concat((i + 1) + ") " + ekipet[i] + " " + piket[i] + "p , " + diferencaEGolave[i] + "gd\n");
        }
        return header;
    }
}
