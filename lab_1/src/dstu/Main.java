package dstu;

import dstu.domain.Airplane;
import dstu.domain.ITransport;
import dstu.domain.Ship;
import dstu.until.CsvReader;
import dstu.until.Serialize;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length <2){
            System.out.println("You must specify data file name and serialize file name!");
            return;
        }

        String sourceFile = args[0];
        String binFile = args[1];

        List<String[]> strings = CsvReader.readCsvFile(args[0], ";");
        List<ITransport> transports = new ArrayList<>();
        for (String[] line: strings) {
            if (line[0].equals("0")) {
                transports.add(new Airplane(line));
            } else {
                transports.add(new Ship(line));
            }
        }
        transports.forEach(System.out::println);

        Serialize.serialize(transports, binFile);
        List<ITransport> newTransports = (List<ITransport>) Serialize.deserialize(binFile);
        System.out.println("Новый транспорт: ");
        newTransports.forEach(System.out::println);
    }
}
