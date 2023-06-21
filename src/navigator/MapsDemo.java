package navigator;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MapsDemo {
    public static void main(String[] args) {

        interactive(createMap());

    }

    public static void interactive(List<Node> cityList) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two cities to calculate the minimum distance between them\n");
        System.out.print("Enter from: ");
        String cityFrom = scanner.next();
        System.out.print("Enter to: ");
        String cityTo = scanner.next();

        Node from = new Node("");
        Node to = new Node("");

        for (Node next : cityList) {
            if (next.getName().equals(cityFrom)) {
                from = next;
            } else if (next.getName().equals(cityTo)) {
                to = next;
            }
        }

        Node result = Dijkstra.calculateShortestPart(from, to);
        List<Node> results = result.getShortestPart();

        for (Node node : results) {
            System.out.print(node.getName() + " -> ");
        }
        System.out.println(" " + result.getName() + " - distance: " + result.getDistance());

    }

    private static List<Node> createMap() {
        Node odessa = new Node("Odessa");
        Node mykolaiv = new Node("Mykolaiv");
        Node kherson = new Node("Kherson");
        Node kryvyiRih = new Node("Kryvyi Rih");
        Node dnipro = new Node("Dnipro");
        Node kharkiv = new Node("Kharkiv");
        Node poltava = new Node("Poltava");
        Node sumy = new Node("Sumy");
        Node kropyvnytskyi = new Node("Kropyvnytskyi");
        Node uman = new Node("Uman");
        Node kyiv = new Node("Kyiv");
        Node vinnytsia = new Node("Vinnytsia");
        Node zhytomyr = new Node("Zhytomyr");
        Node khmelnytskyi = new Node("Khmelnytskyi");
        Node ternopil = new Node("Ternopil");
        Node rivne = new Node("Rivne");
        Node lviv = new Node("Lviv");

        odessa.addDestination(mykolaiv, 132);
        odessa.addDestination(uman, 271);

        mykolaiv.addDestination(kryvyiRih, 204);
        mykolaiv.addDestination(kherson, 71);

        kryvyiRih.addDestination(dnipro, 146);

        dnipro.addDestination(kharkiv, 216);

        uman.addDestination(vinnytsia, 160);
        uman.addDestination(kyiv, 212);
        uman.addDestination(kropyvnytskyi, 167);

        kropyvnytskyi.addDestination(kryvyiRih, 119);
        kropyvnytskyi.addDestination(dnipro, 245);

        kharkiv.addDestination(sumy, 183);

        poltava.addDestination(kharkiv, 143);

        kyiv.addDestination(poltava, 342);
        kyiv.addDestination(zhytomyr, 140);

        vinnytsia.addDestination(khmelnytskyi, 122);

        khmelnytskyi.addDestination(ternopil, 111);

        ternopil.addDestination(lviv, 127);
        ternopil.addDestination(rivne, 159);

        zhytomyr.addDestination(rivne, 188);

        rivne.addDestination(lviv, 121);

        List<Node> cityList = new LinkedList<>();
        cityList.add(odessa);
        cityList.add(mykolaiv);
        cityList.add(kryvyiRih);
        cityList.add(dnipro);
        cityList.add(uman);
        cityList.add(kropyvnytskyi);
        cityList.add(kharkiv);
        cityList.add(poltava);
        cityList.add(kyiv);
        cityList.add(vinnytsia);
        cityList.add(khmelnytskyi);
        cityList.add(ternopil);
        cityList.add(zhytomyr);
        cityList.add(rivne);
        cityList.add(lviv);

        return cityList;
    }
}
