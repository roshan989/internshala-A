package com.example.internshala.repo;

import com.example.internshala.model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository(value = "shipA")
public class ShipRepo implements InterfaceRepo{

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public ShipRepo(JdbcTemplate jdbcTemplate) {
       this.jdbcTemplate = jdbcTemplate;
    }


    //-----------------------------------------------------------
    //for POST METHOD
    @Override
    public int addShipment(String comment, UUID id, Date date, Ship ship) {

        Ship ins = new Ship(ship.getLoadingPoint(),
                ship.getUnloadingPoint(),
                ship.getProductType(),
                ship.getTruckType(),ship.getNoOfTrucks(),ship.getWeight(),
                comment, id, date);

        final String sql="INSERT INTO payload VALUES ('"+ins.getLoadingPoint()+"','"
                +ins.getUnloadingPoint()+"','"+ins.getProductType()+"','"
                +ins.getTruckType()+"',"+ins.getNoOfTrucks()+","
                +ins.getWeight()+",'"+ins.getComment()+"','"+ins.getShipperId()+"','"
                +ins.getDate()+"');";
        try {
            jdbcTemplate.execute(sql);
            return 1;
            }catch(Exception e){
            e.printStackTrace();
            System.out.println("not able to insert");
            return 0;
        }
    }
    //------------------------------------------------------------------------
    //FOR GET METHOD
    @Override
    public List<Ship> getShipping(UUID id) {
        final String sql="SELECT *FROM payload WHERE shipperId = '"+id+"';";
        try{
        List<Ship> outList =
                jdbcTemplate.query(sql,(resultSet,i)-> new Ship(
                    resultSet.getString("loadingpoint"),
                    resultSet.getString("unloadingpoint"),
                    resultSet.getString("producttype"),
                    resultSet.getString("trucktype"),
                    resultSet.getInt("nooftrucks"),
                    resultSet.getInt("weight"),
                    resultSet.getString("comment"),
                    UUID.fromString(resultSet.getString("shipperid")),
                    resultSet.getDate("date")
        ));
        return outList;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("not able to reach db");
            return null;
        }

    }
    //-------------------------------------------------------------------------
    //FOR PUT METHOD

    @Override
    public int putShipping(UUID id, Ship ship) {
        final String sql="UPDATE payload SET "
                +"loadingpoint= '"+ship.getLoadingPoint()+"',"
                +"unloadingpoint= '"+ship.getUnloadingPoint()+"',"
                +"producttype= '"+ship.getProductType()+"',"
                +"trucktype= '"+ship.getTruckType()+"',"
                +"nooftrucks= "+ship.getNoOfTrucks()+","
                +"weight= "+ship.getWeight()+","
                +"comment= '"+ship.getComment()+"',"
                +"date= '"+ship.getDate()+"' "+
                "WHERE shipperid ='"+id+ "';";
        //------------------------------------------
        try {
            jdbcTemplate.execute(sql);
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No Update made sorry");
            return 0;
        }
        //------------------------------------------

    }

    //------------------------------------------------------------
    //FOR DELETE METHOD

    @Override
    public int deleteShipping(UUID id) {
        final String sql="DELETE FROM payload WHERE shipperid ='"+id+"';";
        try {
            jdbcTemplate.execute(sql);
            return 1;
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("not deleted entity");
            return 0;
        }
    }

    //----------------------------------------------------------------

}

