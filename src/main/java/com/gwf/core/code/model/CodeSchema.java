package com.gwf.core.code.model;



import com.gwf.core.common.model.DbModel;

import java.io.Serializable;

/**
 * Created by lcy on 17/7/1.
 *
 * code schema
 */
public class CodeSchema implements Serializable {


    private static final long serialVersionUID = 1154645476624841358L;

    private String ip;

    private String db;

    private String url;
    private String dbName;
    private String username;
    private String password;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    private String port;

    private String dbProduct;

    private String driverClass;

    private String basePackage;

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public CodeSchema() {
    }

    public String getUrl() {
        if(DbModel.MYSQL.getType().equals(getDb()))
            return "jdbc:mysql://" + getIp() + ":" + getPort() + "/" + getDbName();
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbProduct() {
        return dbProduct;
    }

    public void setDbProduct(String dbProduct) {
        this.dbProduct = dbProduct;
    }

    public String getDriverClass() {
        if(DbModel.MYSQL.getType().equals(getDb()))
            return "com.mysql.jdbc.Driver";
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    private String tables;

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }


    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
