package com.vv.juc;


import lombok.Getter;

/**
 * 生产中枚举的用法
 *      类似数据库的字典表
 *      但是减少连接数据库的操作步骤，而且更灵活
 */
public enum Country {
    One(1, "齐"),
    Two(2, "赵"),
    Three(3, "燕"),
    Four(4, "楚"),
    Five(5, "魏"),
    Six(6, "韩");

    @Getter
    public Integer retCode;
    @Getter
    public String retName;

    Country(int retCode, String retName) {
        this.retCode = retCode;
        this.retName = retName;
    }

    public static Country forEach(int i) {
        Country[] countries = Country.values();

        for (Country country : countries) {
            if (country.retCode == i) {
                return country;
            }
        }
        return null;
    }
}
