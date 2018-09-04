package com.Adapters;

import org.json.JSONObject;
import org.telegram.telegrambots.api.objects.Update;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by xsd on 02.09.2017 with love.
 * :)
 *
 * @author xsd
 * @author alekseysavin.com
 * @version 0.1
 */

public class dbmodel {
    public static class sqllite {
        // http://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/

    }

    public static class MysqlCon {

        static String sqlUser = "bot";
        static String sqlPass = "bot";
        static String sqlHost = "jdbc:mysql://localhost:3306/cb";


        public static void procedureActivityStreak(Long chatid) {

        }

        public static void addWaterToDiary(Long chatid, int count) throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
            Statement statement = connection.createStatement();

            System.out.println("Water added by" + chatid + "/n" + " count" + count);

            String query = "insert into diary.waterdiary (tid, watercount) " +
                    "values ('" + chatid + "', '" + count + "');";
            statement.execute(query);
            System.out.println(query);
        }

        // todo i need to generate db objects, need to test
        public static List<Integer> getWaterSubscribers() throws ClassNotFoundException, SQLException {
            List<Integer> subscrabers = new ArrayList<Integer>();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
            Statement stmt = con.createStatement();
            String query = "select tid from diary.water.subscribers"; //"select sum(watercount) from diary.waterdiary WHERE tid = + '" + chatid + "' AND datetime BETWEEN  '2017-12-10 00:00:00' AND '2017-12-10 23:59:00'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                subscrabers.add(rs.getInt(1));
            }
            return subscrabers;
        }



        public static void addUnrecognizedQuestion(String nrbotname, String nrbottoken, int nrmessageid, long nrchatid, String nrmessagetext) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
            Statement statement = connection.createStatement();

            System.out.println(nrbotname + ":" + nrbottoken + ":" + nrmessageid + ":" + nrchatid + ":" + nrmessagetext);

            String query = "insert into telegram.notrecognizedmessages (botname, bottoken, messageid, chatid, messagetext) " +
                    //" VALUES " + "('" + nrbotname + "'," '" nrbottoken, nrchatid, nrmessageid, nrmessagetext)";
                    "values ('" + nrbotname + "', '" + nrbottoken + "' , '" + nrmessageid + "' , '" + nrchatid + "' , '" + nrmessagetext + "');";

            System.out.println(query);
            statement.execute(query);

        }

        // for plank and water bot
        public static void addAnswerForSheduledMessage(String nrbotname, String nrbottoken, int nrmessageid, long nrchatid, String nrmessagetext, long contact_chatid) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
            Statement statement = connection.createStatement();

            System.out.println(nrbotname + ":" + nrbottoken + ":" + nrmessageid + ":" + nrchatid + ":" + nrmessagetext);

            String query = "insert into telegram.sheduledanswers (botname, bottoken, messageid, chatid, messagetext, contact_chatid) " +
                    //" VALUES " + "('" + nrbotname + "'," '" nrbottoken, nrchatid, nrmessageid, nrmessagetext)";
                    "values ('" + nrbotname + "', '" + nrbottoken + "' , '" + nrmessageid + "' , '" + nrchatid + "' , '" + nrmessagetext + "' , '" + contact_chatid + "');";

            System.out.println(query);
            statement.execute(query);

        }


        public void addUser(long tid, String tname, String tnummber) throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
            Statement statement = connection.createStatement();

            String query = "insert into telegram.users (telegramid, telegramname, telegramnumber) " +
                    "values ('" + tid + "', '" + tname + "' , " + tnummber + ");";
            System.out.println(query);

            statement.execute(query);

        }

        public static void addConsult(long tid, String consultantCode) throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
            Statement statement = connection.createStatement();

            String query = null;

            if (consultantCode == "shoroh") {
                query = "insert into telegram.consults (idconsultant, idconsulted) " +
                        "values ('" + 70437788 + "', '" + tid + "');";
            } else if (consultantCode == "levcom") {
                query = "insert into telegram.consults (ifconsultant, idconsulted) " +
                        "values ('" + 120890854 + "', '" + tid + "');";
            }

            System.out.println("adConsultant: " + query);

            try {
                statement.execute(query);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        public static List<Integer> getAdmins() {
            List<Integer> admins = new ArrayList<Integer>();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
                Statement statement = connection.createStatement();

                String query = "SELECT telegramid FROM telegram.users WHERE userrole";

                ResultSet results = statement.executeQuery(query);

                while (results.next()) {
                    results.getStatement();
                    admins.add(results.getInt("telegramid"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return admins;
        }

        public static ArrayList<Integer> getConsultans() throws SQLException, ClassNotFoundException {
            // todo needed for getEveryDayWaterDiaryReport
            ArrayList<Integer> consultants = new ArrayList<Integer>();

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
            Statement statement = connection.createStatement();

            /*
            SELECT idconsultant FROM telegram.consults group by consults.idconsultant;
             */
            String query = "SELECT idconsultant FROM telegram.consults group by consults.idconsultant";
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                results.getStatement();
                consultants.add(results.getInt(1));
            }
            return consultants;
        }

        public static ArrayList<Integer> getFollowers() throws SQLException, ClassNotFoundException {
            // todo needed for getEveryDayWaterUserWaterCountView
            ArrayList<Integer> followers = new ArrayList<Integer>();

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
            Statement statement = connection.createStatement();

            String query = "SELECT idconsulted FROM telegram.consults group by consults.idconsulted";
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                results.getStatement();
                followers.add(results.getInt(1));
            }
            return followers;
        }

        // todo оповещение консультанта о выпитом консультируемым за сегодня
        public static String getEveryDayWaterDiaryReportView(long consul_tid) throws SQLException, ClassNotFoundException {
            String stroke = "";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT watercountsum, telegramname, datetime, wdv.idconsultant  FROM diary.waterdiaryview wdv where datetime > curdate() and wdv.idconsultant = '" + consul_tid + "';");

                while (rs.next()) {
                    // todo rewrite for needs
                    // System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getString(4));
                    stroke += rs.getString(2) + " за " + rs.getString(3) + " выпил: " + rs.getInt(1) + "\n";
                }
            } catch (SQLException sqlE) {
                System.out.println(sqlE.getErrorCode() + "\n" + sqlE.toString());
            }
            return stroke;
        }

        // todo оповещение пользователя о выпитом за сегодня
        public static String getEveryDayWaterUserWaterCountView(long user_tid) throws SQLException, ClassNotFoundException {
            String stroke = "";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT watercountsum, telegramname, datetime  FROM diary.waterdiaryview wdv where datetime > curdate() and wdv.idconsulted = '" + user_tid + "';");

                while (rs.next()) {
                    // todo rewrite for needs
                    // System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getString(4));
                    stroke += rs.getString(2) + ", Вы сегодня выпили " + rs.getInt(1) + " мл.";
                }
            } catch (SQLException sqlE) {
                System.out.println(sqlE.getErrorCode() + "\n" + sqlE.toString());
            }
            return stroke;
        }

        public void addProduct(String name, int pro, int fats, int carb) throws SQLException {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
                Statement statement = connection.createStatement();

                String query = "insert into clpr.products (name, protein, fat, carbohydrate)\n" +
                        "values ('" + name + "', " + pro + "," + fats + "," + carb + ");";

                // ResultSet results = statement.executeQuery(query);

                statement.execute(query);

//                while (results.next()) {
//                    results.getStatement();
//                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void testMsqlConnection() throws SQLException, ClassNotFoundException {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from People");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getString(4));
                }
            } catch (SQLException sqlE) {
                System.out.println(sqlE.getErrorCode() + "\n" + sqlE.toString());
            }
        }

        public static int getWaterFromPeriod(long chatid, String dateFrom, String dateTo) throws ClassNotFoundException, SQLException {
            int water = 0;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
            Statement stmt = con.createStatement();
            String query = "select sum(watercount) from diary.waterdiary WHERE tid = + '" + chatid + "' AND datetime > curdate();";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                water = rs.getInt(1);
            }
            return water;
        }

        public String getOwnPriceList(String q) throws SQLException, ClassNotFoundException {
            String header = "Last Loaded Price: " + "\n";
            String message = "";

            String id;
            String name;
            BigDecimal vp;
            Float price;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
                ResultSet rs;
                Statement stmt = con.createStatement();
                rs = stmt.executeQuery("select * from s_price_sv");

                while (rs.next()) {
                    id = rs.getString(1);
                    name = rs.getString(2);
                    vp = rs.getBigDecimal(3);
                    price = rs.getFloat(4);

                    System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getBigDecimal(3) + " " + rs.getString(4));

                    message += "/" + id + " " + name + "\n" + "Vp: " + vp + "\n" + "Rub: " + price + "\n";

                }

                return header + message;

            } catch (SQLException sqlE) {
                System.out.println(sqlE.getErrorCode() + "\n" + sqlE.toString());
            }

            return "Nothig";
        }

        public static String getNameById(String sponsor) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
                Statement statement = connection.createStatement();

                String query = "SELECT tfname, tlname, tuname from tele_users where sponsor = " + sponsor + " group by sponsor;";

                ResultSet results = statement.executeQuery(query);

                String tfname = null;
                String tlname = null;
                String tuname = null;

                while (results.next()) {
                    results.getStatement();
                    tfname = results.getString("tfname");
                    tlname = results.getString("tlname");
                    tuname = results.getString("tuname");
                }

                if (tfname != null) {
                    return tfname;
                }

                if (tlname != null) {
                    return tlname;
                }

                if (tuname != null) {
                    return tuname;
                }
                return "Хороший Человек!";
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return "Хороший Человек!";
        }

        public static boolean registerUser(Update update, String sponsor) {
            // userinfo
            int tid = update.getMessage().getFrom().getId();
            String tfname = update.getMessage().getFrom().getFirstName();
            String tlname = update.getMessage().getFrom().getLastName();
            String tuname = update.getMessage().getFrom().getUserName();
            String lang = update.getMessage().getFrom().getLanguageCode();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(sqlHost, sqlUser, sqlPass);
                Statement statement = connection.createStatement();

                String query = "insert into cb.tele_users (tid, tfname, tlname, tuname, lang, sponsor) " +
                        "values (?, ?, ?, ?,?,?);";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt (1,tid);
                preparedStmt.setString (2, tfname);
                preparedStmt.setString   (3, tlname);
                preparedStmt.setString(4, tuname);
                preparedStmt.setString    (5, lang);
                preparedStmt.setInt (6,Integer.parseInt(sponsor));

                // execute the preparedstatement
                preparedStmt.execute();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return true;
        }
    }


}