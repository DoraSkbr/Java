package org.dstu.dao;//ДОБАВИТЬ

import org.dstu.domain.Airplane;
import org.hibernate.query.Query;

import java.util.List;

public class AirplaneDao extends BaseDaoImpl<Airplane, Integer> {
    public AirplaneDao() {
        super(Airplane.class);
    }
    public List<Airplane> getAllByGroup(String model) {
        Query q = getSession().createQuery("FROM Airplane WHERE Airplane.model =  \"" + model + "\"");
        return q.list();
    }
}
