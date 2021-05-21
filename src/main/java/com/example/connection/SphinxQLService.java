package com.example.connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SphinxQLService {
    private final Connection sphinxConnection;
    private final Connection dbConnection;

    public SphinxQLService(Connection sphinxConnection, Connection dbConnection) {
        this.sphinxConnection = sphinxConnection;
        this.dbConnection = dbConnection;
    }


    public List<Integer> getIds() throws SQLException {
        List<Integer> ids = new ArrayList<>();
        try (Statement st = sphinxConnection.createStatement()) {
            try (ResultSet rs = st.executeQuery("SELECT id, weight() FROM addressBookIndex WHERE MATCH('Ranita | kumar') OPTION ranker=bm25, field_weights=(fname=100,lname=1)")) { //Order by id asc
                while (rs.next()) {
                    ids.add(rs.getInt(1));
                }
            }
        }
        return ids;
    }

    public List<AddressBook> getAddressBookList(List<Integer> addressIds) throws SQLException {

        List<AddressBook> addressBookList = new ArrayList();

        if (addressIds == null || addressIds.size() == 0) {
            return addressBookList;
        }

        try (CallableStatement callableStatement = dbConnection.prepareCall("{ call search_address_book(?)}")) {

            callableStatement.setString(1, addressIds.toString());
            callableStatement.execute();
            AddressBook addressBoook;
            try (ResultSet rs = callableStatement.getResultSet()) {
                while (rs.next()) {

                    addressBoook = new AddressBook();
                    addressBoook.setEmail(rs.getString("Email"));
                    addressBoook.setfName(rs.getString("FName"));
                    addressBoook.setlName(rs.getString("LName"));
                    addressBoook.setLocation(rs.getString("Location"));
                    addressBoook.setPhoneNo(rs.getString("PhoneNo"));
                    addressBoook.setTitle(rs.getString("Title"));
                    addressBoook.setId(rs.getLong("Id"));
                    addressBookList.add(addressBoook);
                }
            }
            return addressBookList;
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection sphinxConnection = SphinxConnectionCreator.init();
        Connection dbConnection = DatabaseConnectionCreator.init();
        SphinxQLService sphinxQLService = new SphinxQLService(sphinxConnection, dbConnection);
        List<Integer> ids = sphinxQLService.getIds(); // коллабл процедура теряет первый айдишник
        System.out.println(ids);
        List<AddressBook> addressBookList = sphinxQLService.getAddressBookList(ids);
        for (AddressBook value : addressBookList) {
            System.out.println(value);
        }
    }
}
