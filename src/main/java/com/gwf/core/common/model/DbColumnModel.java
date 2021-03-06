package com.gwf.core.common.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lcy on 17/7/5.
 */
public class DbColumnModel implements Serializable {
    private static final long serialVersionUID = -7808860348918160912L;


    public DbColumnModel() {
    }

    private String colName;  //列名

    private String typeName; //类型名称

    private String typeNameUpper; //类型名称


    private int precision, isNull, dataType, scale; //精度,是否为空,类型,小数的位数

    private boolean isKey = false;  //是否为主键

    private String columnNameLowerCamel;  //列名转化为小写驼峰式

    private String columnNameUpperCamel;  //列名转化为大写驼峰式

    private String javaType;  //数据库属性名转化为java属性名

    public String getJavaType() {
        String typeNamel = typeName.toLowerCase();
        switch (typeNamel) {
            case "int":
                javaType = "Integer";
                break;
            case "varchar":
                javaType = "String";
                break;
            case "char":
                javaType = "Char";
                break;
            case "blob":
                javaType = "Byte[]";
                break;
            case "text":
                javaType = "String";
                break;
            case "integer":
                javaType = "Long";
                break;
            case "tinyint":
                javaType = "Integer";
                break;
            case "smallint":
                javaType = "Integer";
                break;
            case "mediumint":
                javaType = "Integer";
                break;
            case "bit":
                javaType = "Boolean";
                break;
            case "bigint":
                javaType = "BigInteger";
                break;
            case "float":
                javaType = "Float";
                break;
            case "double":
                javaType = "Double";
                break;
            case "decimal":
                javaType = "BigDecimal";
                break;
            case "id":
                javaType = "Long";
                break;
            case "date":
                javaType = "Date";
                break;
            case "year":
                javaType = "Date";
                break;
            case "time":
                javaType = "Time";
                break;
            case "datetime":
                javaType = "Timestamp";
                break;
            case "timestamp":
                javaType = "Timestamp";
                break;
        }
        return javaType;
    }

    public String getColumnNameLowerCamel() {
        columnNameLowerCamel = columnNameConvertLowerCamel(colName);
        return columnNameLowerCamel;
    }


    public String getColumnNameUpperCamel() {
        columnNameUpperCamel = columnNameConvertUpperCamel(colName);
        return columnNameUpperCamel;
    }

    /**
     * 将数据库属性名改为驼峰式，首字母大写
     *
     * @param columnName 列名
     * @return
     */
    private static String columnNameConvertLowerCamel(String columnName) {
        StringBuilder result = new StringBuilder();
        if (columnName != null && columnName.length() > 0) {
            columnName = columnName.toLowerCase();//兼容使用大写的表名
            boolean flag = false;
            for (int i = 0; i < columnName.length(); i++) {
                char ch = columnName.charAt(i);
                if ("_".charAt(0) == ch) {
                    flag = true;
                } else {
                    if (flag) {
                        result.append(Character.toUpperCase(ch));
                        flag = false;
                    } else {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }

    /**
     * 将数据库属性名改为驼峰式，首字母大写
     *
     * @param columnName 列名
     * @return
     */
    private static String columnNameConvertUpperCamel(String columnName) {
        String camel = columnNameConvertLowerCamel(columnName);
        return camel.substring(0, 1).toUpperCase() + camel.substring(1);
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getIsNull() {
        return isNull;
    }

    public void setIsNull(int isNull) {
        this.isNull = isNull;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public boolean getIsKey() {
        return isKey;
    }

    public void setKey(boolean key) {
        isKey = key;
    }

    public String getTypeNameUpper() {
        typeNameUpper = typeName.toUpperCase();
        if(typeNameUpper.equals("INT"))
            typeNameUpper = "INTEGRE";
        return typeNameUpper;
    }


    /**
     * 复制属性
     *
     * @param rs
     * @throws SQLException
     */
    public void copyColumnFromSqlResult(ResultSet rs) throws SQLException {
        try {
            String colName = rs.getString("COLUMN_NAME");//列名
            String typeName = rs.getString("TYPE_NAME");//类型名称
            int precision = rs.getInt("COLUMN_SIZE");//精度
            int isNull = rs.getInt("NULLABLE");//是否为空
            int dataType = rs.getInt("DATA_TYPE");//类型
            int scale = rs.getInt("DECIMAL_DIGITS");// 小数的位数

            this.setColName(colName);
            this.setTypeName(typeName);
            this.setPrecision(precision);
            this.setIsNull(isNull);
            this.setDataType(dataType);
            this.setScale(scale);
        } catch (SQLException e) {
            throw e;
        }
    }
}
