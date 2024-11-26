import org.dstu.dao.AirplaneDao;
import org.dstu.dao.ShipDao;
import org.dstu.dao.PortDao;
import org.dstu.domain.Airplane;
import org.dstu.domain.Ship;
import org.dstu.domain.Port;
import org.dstu.util.HibernateUtil;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class Main {

    public static void main(final String[] args) throws Exception {
        final Session session = HibernateUtil.getSession();
        AirplaneDao airplaneDao = new AirplaneDao();

        //Сохранение самолета
        Airplane airplane = new Airplane();
        airplane.setModel("Airbus A380");//Модль самолета
        airplane.setCapacity(357);//Вметимость
        airplane.setReleaseYear(1989);//Год релиза
        airplane.setMaxSpeed(800);//Скорость самолета в км/ч
        airplane.setType("Пассажирский");//Тип
        airplaneDao.save(airplane);

        // Сохранение port
        PortDao portDao = new PortDao();

        Port prt = new Port();
        prt.setLocation("Сеул");//Местополоение порт
        prt.setDepth(15);//Глубина акватории в метрах
        prt.setOperatingHours("24/7");//Часы работы
        prt.setFacilities("Топливо, Ремонт, Склад");//Услуги в порту
        int saveId = portDao.save(prt);
        System.out.println(saveId);

        //Сохранение корабля
        ShipDao shipDao = new ShipDao();

        Ship ship = new Ship();
        ship.setName("Титаник");//Название корабля
        ship.setTonnage(46000);//Водоизмещение
        ship.setType("Круизный лайнер");//Тип
        ship.setLength(269);//Длина в м.
        ship.setWidth(28);//Ширина в м.
        ship.setEnginePower(3000);//Мозность двигателя
        ship.setPort(prt);
        shipDao.save(ship);



        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}